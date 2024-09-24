package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.UsuarioModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.UsuarioRepositorty;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class UsuarioDaoPostgres implements UsuarioRepositorty {
    @Override
    public UsuarioModel findById(int id) {

        final UsuarioModel usuarioModel = new UsuarioModel();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM usuario WHERE id = ?";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                usuarioModel.setId(resultSet.getInt("id"));
                usuarioModel.setNome(resultSet.getString("nome"));
                usuarioModel.setEmail(resultSet.getString("email"));
                usuarioModel.setSenha(resultSet.getString("senha"));
                usuarioModel.setTelefone(resultSet.getString("telefone"));
                usuarioModel.setTipo(resultSet.getString("tipo"));
                usuarioModel.setDataCadastro(resultSet.getDate("dataCadastro").toLocalDate());
                usuarioModel.setSituacao(resultSet.getString("situacao"));

                resultSet.close();
                preparedStatement.close();
            }else {
                return null;
            }
            return usuarioModel;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UsuarioModel> findAll() {
        return null;
    }

    @Override
    public List<UsuarioModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(UsuarioModel usuarioModel) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public int create(UsuarioModel usuarioModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO usuario(nome, email, senha, telefone, tipo, dataCadastro, situacao)";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, usuarioModel.getNome());
            preparedStatement.setString(2, usuarioModel.getEmail());
            preparedStatement.setString(3, usuarioModel.getSenha());
            preparedStatement.setString(4, usuarioModel.getTelefone());
            preparedStatement.setString(5, usuarioModel.getTipo());
            preparedStatement.setDate(6, Date.valueOf(usuarioModel.getDataCadastro()));
            preparedStatement.setString(7, usuarioModel.getSituacao());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                final int id = resultSet.getInt(1);
                usuarioModel.setId(id);
            }

            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return usuarioModel.getId();

        } catch (Exception e) {
            if (connection != null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            return -1;
        }
    }
}
