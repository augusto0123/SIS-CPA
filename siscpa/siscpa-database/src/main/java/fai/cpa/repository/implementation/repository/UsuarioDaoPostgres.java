package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.UsuarioModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.UsuarioRepositorty;

import java.sql.*;
import java.util.ArrayList;
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
                usuarioModel.setInstituicaoId(resultSet.getInt("id_instituicao"));

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
    public UsuarioModel findByEmaileSenha(String email, String senha) {

        final UsuarioModel usuarioModel = new UsuarioModel();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM usuario u WHERE u.email = ? and u.senha = ?";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,senha);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                usuarioModel.setId(resultSet.getInt("id"));
                usuarioModel.setNome(resultSet.getString("nome"));
                usuarioModel.setEmail(resultSet.getString("email"));
                usuarioModel.setSenha(resultSet.getString("senha"));
                usuarioModel.setTelefone(resultSet.getString("telefone"));
                usuarioModel.setTipo(resultSet.getString("tipo"));
                if(resultSet.getInt("id_instituicao") != 0) {
                    usuarioModel.setInstituicaoId(resultSet.getInt("id_instituicao"));
                }

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
    public List<UsuarioModel> findByTipoAndInstituicaoId(String tipo, int id) {
        List<UsuarioModel> usuarios = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM usuario WHERE tipo = ? AND id_instituicao = ?";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tipo);
            preparedStatement.setInt(2, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UsuarioModel usuarioModel = new UsuarioModel();
                usuarioModel.setId(resultSet.getInt("id"));
                usuarioModel.setNome(resultSet.getString("nome"));
                usuarioModel.setEmail(resultSet.getString("email"));
                usuarioModel.setSenha(resultSet.getString("senha"));
                usuarioModel.setTelefone(resultSet.getString("telefone"));
                usuarioModel.setTipo(resultSet.getString("tipo"));
                usuarioModel.setInstituicaoId(resultSet.getInt("id_instituicao"));

                usuarios.add(usuarioModel);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    @Override
    public List<UsuarioModel> findAll() {
        final List<UsuarioModel> usuarios = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM usuario;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final UsuarioModel usuario = new UsuarioModel();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setTipo(resultSet.getString("tipo"));
                usuario.setInstituicaoId(resultSet.getInt("id_instituicao"));

                usuarios.add(usuario);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    @Override
    public List<UsuarioModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public List<UsuarioModel> findAllByInstituicaoId(int instituicaoId) {

        List<UsuarioModel> usuarios = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM usuario WHERE id_instituicao = ?";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, instituicaoId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UsuarioModel usuarioModel = new UsuarioModel();
                usuarioModel.setId(resultSet.getInt("id"));
                usuarioModel.setNome(resultSet.getString("nome"));
                usuarioModel.setEmail(resultSet.getString("email"));
                usuarioModel.setSenha(resultSet.getString("senha"));
                usuarioModel.setTelefone(resultSet.getString("telefone"));
                usuarioModel.setTipo(resultSet.getString("tipo"));
                usuarioModel.setInstituicaoId(resultSet.getInt("id_instituicao"));

                usuarios.add(usuarioModel);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
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

        String sql = "INSERT INTO usuario(nome, email, senha, telefone, tipo) ";
//        id_instituicao
        sql += "VALUES (?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, usuarioModel.getNome());
            preparedStatement.setString(2, usuarioModel.getEmail());
            preparedStatement.setString(3, usuarioModel.getSenha());
            preparedStatement.setString(4, usuarioModel.getTelefone());
            preparedStatement.setString(5, usuarioModel.getTipo());
//            preparedStatement.setInt(6, usuarioModel.getInstituicaoId());

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
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateById(UsuarioModel usuarioModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE usuario SET tipo = ?, id_instituicao = ?";
        sql += " WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, usuarioModel.getTipo());
            preparedStatement.setInt(2, usuarioModel.getInstituicaoId());
            preparedStatement.setInt(3, usuarioModel.getId());

            preparedStatement.execute();

            preparedStatement.close();

            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
