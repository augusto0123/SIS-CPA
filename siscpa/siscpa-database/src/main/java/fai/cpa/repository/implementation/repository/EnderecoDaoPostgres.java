package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.EnderecoModel;
import fai.cpa.entities.InstituicaoModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.EnderecoRepository;

import java.sql.*;

public class EnderecoDaoPostgres implements EnderecoRepository {

    @Override
    public int create(EnderecoModel enderecoModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO endereco (logradouro, numero, bairro, cep)";
        sql += "VALUES(?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, enderecoModel.getLogradouro());
            preparedStatement.setString(2, enderecoModel.getNumero());
            preparedStatement.setString(3, enderecoModel.getBairro());
            preparedStatement.setString(4, enderecoModel.getCep());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                final int id = resultSet.getInt(1);
                enderecoModel.setId(id);
            }

            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return enderecoModel.getId();

        } catch (Exception e) {
            if (connection != null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        }
    }
    @Override
    public EnderecoModel findById(int id) {

        final EnderecoModel endereco  =new EnderecoModel();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM endereco ";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                endereco.setId(resultSet.getInt("id"));
                endereco.setLogradouro(resultSet.getString("logradouro"));
                endereco.setNumero(resultSet.getString("numero"));
                endereco.setBairro(resultSet.getString("bairro"));
                endereco.setCep(resultSet.getString("cep"));
                endereco.setComplemento(resultSet.getString("complemento"));
            }
            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }
}
