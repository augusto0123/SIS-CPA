package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.AvaliacaoModel;
import fai.cpa.entities.QuestionarioModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.QuestionarioRepository;

import java.security.PrivilegedAction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionarioDaoPostgres implements QuestionarioRepository {
    @Override
    public QuestionarioModel findById(int id) {

        final QuestionarioModel questionario = new QuestionarioModel();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM questionario ";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                questionario.setId(resultSet.getInt("id"));
                questionario.setCategoria(resultSet.getString("categoria"));
                questionario.setDescricao(resultSet.getString("descricao"));
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return questionario;
    }

    @Override
    public List<QuestionarioModel> findAll() {

        final List<QuestionarioModel> questionarios = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM questionario;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final QuestionarioModel questionario = new QuestionarioModel();
                questionario.setId(resultSet.getInt("id"));
                questionario.setCategoria(resultSet.getString("categoria"));
                questionario.setDescricao(resultSet.getString("descricao"));

                questionarios.add(questionario);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return questionarios;
    }

    @Override
    public List<QuestionarioModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public List<QuestionarioModel> findAllByInstituicaoId(int instituicaoId) {
        final List<QuestionarioModel> questionarios = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM questionario WHERE id_instituicao = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, instituicaoId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final QuestionarioModel questionario = new QuestionarioModel();
                questionario.setId(resultSet.getInt("id"));
                questionario.setCategoria(resultSet.getString("categoria"));
                questionario.setDescricao(resultSet.getString("descricao"));
                questionario.setAvaliacaoId(resultSet.getInt("id_avaliacao"));
                questionario.setInstituicaoId(resultSet.getInt("id_instituicao"));

                questionarios.add(questionario);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return questionarios;
    }

    @Override
    public List<QuestionarioModel> findAllByAvaliacaoId(int avaliacaoId) {
        final List<QuestionarioModel> questionarios = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM questionario WHERE id_avaliacao = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, avaliacaoId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final QuestionarioModel questionario = new QuestionarioModel();
                questionario.setId(resultSet.getInt("id"));
                questionario.setCategoria(resultSet.getString("categoria"));
                questionario.setDescricao(resultSet.getString("descricao"));
                questionario.setInstituicaoId(resultSet.getInt("id_instituicao"));
                questionario.setAvaliacaoId(resultSet.getInt("id_avaliacao"));

                questionarios.add(questionario);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return questionarios;
    }

    @Override
    public boolean update(QuestionarioModel questionario) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE questionario SET id_avaliacao = ?, categoria = ?, descricao = ? ";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, questionario.getAvaliacaoId());
            preparedStatement.setString(2, questionario.getCategoria());
            preparedStatement.setString(3, questionario.getDescricao());
            preparedStatement.setInt(4, questionario.getId());

            preparedStatement.execute();

            connection.commit();

            preparedStatement.close();

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public int create(QuestionarioModel questionario) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO questionario (categoria, descricao, id_instituicao)";
        sql += " VALUES(?, ?, ?);";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, questionario.getCategoria());
            preparedStatement.setString(2, questionario.getDescricao());
//            preparedStatement.setInt(3, questionario.getAvaliacaoId());
            preparedStatement.setInt(3, questionario.getInstituicaoId());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                final int id = resultSet.getInt(1);
                questionario.setId(id);
            }

            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return questionario.getId();

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
