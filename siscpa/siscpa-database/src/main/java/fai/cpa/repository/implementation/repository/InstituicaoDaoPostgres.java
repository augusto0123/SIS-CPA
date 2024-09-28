package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.InstituicaoModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.InstituicaoRepository;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InstituicaoDaoPostgres implements InstituicaoRepository {
    @Override
    public InstituicaoModel findById(int id) {

        final InstituicaoModel instituicao =new InstituicaoModel();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM instituicao ";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                instituicao.setId(resultSet.getInt("id"));
                instituicao.setSituacao(resultSet.getString("situacao"));
                instituicao.setNomeFantasia(resultSet.getString("nome_fantasia"));
                instituicao.setRazaoSocial(resultSet.getString("razao_social"));
                instituicao.setTelefone(resultSet.getString("telefone"));
                instituicao.setCnpj(resultSet.getString("cnpj"));
                instituicao.setEmail(resultSet.getString("email"));
                instituicao.setResponsavelNome(resultSet.getString("nome_responsavel"));
                instituicao.setResposavelEmail(resultSet.getString("email_responsavel"));
                instituicao.setResponsavelTelefone(resultSet.getString("telefone_responsavel"));
                instituicao.setEndereco_id(resultSet.getInt("id_endereco"));
            }
            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return instituicao;
    }

    @Override
    public List<InstituicaoModel> findAll() {
        final List<InstituicaoModel> instituicoes = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM instituicao;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final InstituicaoModel instituicao = new InstituicaoModel();
                instituicao.setId(resultSet.getInt("id"));
                instituicao.setSituacao(resultSet.getString("situacao"));
                instituicao.setNomeFantasia(resultSet.getString("nome_fantasia"));
                instituicao.setRazaoSocial(resultSet.getString("razao_social"));
                instituicao.setTelefone(resultSet.getString("telefone"));
                instituicao.setCnpj(resultSet.getString("cnpj"));
                instituicao.setEmail(resultSet.getString("email"));
                instituicao.setResponsavelNome(resultSet.getString("nome_responsavel"));
                instituicao.setResposavelEmail(resultSet.getString("email_responsavel"));
                instituicao.setResponsavelTelefone(resultSet.getString("telefone_responsavel"));
                instituicao.setEndereco_id(resultSet.getInt("id_endereco"));

                instituicoes.add(instituicao);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return instituicoes ;
    }

    @Override
    public List<InstituicaoModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(InstituicaoModel instituicaoModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE instituicao SET email = ?, cnpj = ?, razao_social = ?, nome_fantasia = ?, telefone = ?, email_responsavel = ?, telefone_responsavel = ?, nome_responsavel = ?, situacao = ?";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,instituicaoModel.getEmail());
            preparedStatement.setString(2,instituicaoModel.getCnpj());
            preparedStatement.setString(3,instituicaoModel.getRazaoSocial());
            preparedStatement.setString(4,instituicaoModel.getNomeFantasia());
            preparedStatement.setString(5,instituicaoModel.getTelefone());
            preparedStatement.setString(6,instituicaoModel.getResposavelEmail());
            preparedStatement.setString(7,instituicaoModel.getResponsavelTelefone());
            preparedStatement.setString(8,instituicaoModel.getResponsavelNome());
            preparedStatement.setString(9,instituicaoModel.getSituacao());
            preparedStatement.setInt(10,instituicaoModel.getId());

            preparedStatement.execute();
            preparedStatement.close();

            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM instituicao";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            preparedStatement.close();

            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int create(InstituicaoModel instituicao) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO instituicao (email, telefone, cnpj, situacao, nome_responsavel, telefone_responsavel, email_responsavel, nome_fantasia, razao_social, endereco_id)";
        sql += " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,instituicao.getEmail());
            preparedStatement.setString(2,instituicao.getTelefone());
            preparedStatement.setString(3,instituicao.getCnpj());
            preparedStatement.setString(4,instituicao.getSituacao());
            preparedStatement.setString(5,instituicao.getResponsavelNome());
            preparedStatement.setString(6,instituicao.getResponsavelTelefone());
            preparedStatement.setString(7,instituicao.getResposavelEmail());
            preparedStatement.setString(8,instituicao.getNomeFantasia());
            preparedStatement.setString(9,instituicao.getRazaoSocial());
            preparedStatement.setInt(10, instituicao.getEndereco_id());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                final int id = resultSet.getInt(1);
                instituicao.setId(id);
            }
            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return instituicao.getId();

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
}
