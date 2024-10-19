package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.GrupoDePerguntasModel;
import fai.cpa.entities.QuestionarioModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.GrupoDePerguntasRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GrupoDePerguntasDaoPostgres implements GrupoDePerguntasRepository {
    @Override
    public GrupoDePerguntasModel findById(int id) {

        final GrupoDePerguntasModel grupo = new GrupoDePerguntasModel();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM grupo_perguntas ";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                grupo.setId(resultSet.getInt("id"));
                grupo.setTipo(resultSet.getString("tipo"));
                grupo.setDescricao(resultSet.getString("descricao"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return grupo;
    }

    @Override
    public List<GrupoDePerguntasModel> findAll() {

        final List<GrupoDePerguntasModel> grupos = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM grupo_perguntas;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final GrupoDePerguntasModel grupo = new GrupoDePerguntasModel();
                grupo.setId(resultSet.getInt("id"));
                grupo.setTipo(resultSet.getString("tipo"));
                grupo.setDescricao(resultSet.getString("descricao"));

                grupos.add(grupo);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return grupos;
    }

    @Override
    public List<GrupoDePerguntasModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public List<GrupoDePerguntasModel> findAllByInstituicaoId(int instituicaoId) {
        final List<GrupoDePerguntasModel> grupos = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM grupo_perguntas WHERE id_instituicao = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, instituicaoId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final GrupoDePerguntasModel grupo = new GrupoDePerguntasModel();
                grupo.setId(resultSet.getInt("id"));
                grupo.setTipo(resultSet.getString("tipo"));
                grupo.setDescricao(resultSet.getString("descricao"));
//                questionario.setAvaliacaoId(resultSet.getInt("id_avaliacao"));
                grupo.setInstituicaoId(resultSet.getInt("id_instituicao"));

                grupos.add(grupo);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return grupos;
    }

    @Override
    public List<GrupoDePerguntasModel> findAllByQuestionarioId(int questionarioId) {
        final List<GrupoDePerguntasModel> grupos = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM grupo_perguntas WHERE id_questionario = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, questionarioId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final GrupoDePerguntasModel grupo = new GrupoDePerguntasModel();
                grupo.setId(resultSet.getInt("id"));
                grupo.setTipo(resultSet.getString("tipo"));
                grupo.setDescricao(resultSet.getString("descricao"));
                grupo.setInstituicaoId(resultSet.getInt("id_instituicao"));
                grupo.setQuestionarioId(resultSet.getInt("id_questionario"));

                grupos.add(grupo);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return grupos;
    }

    @Override
    public boolean update(GrupoDePerguntasModel grupo) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE grupo_perguntas SET id_questionario = ?, tipo = ?, descricao = ? ";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, grupo.getQuestionarioId());
            preparedStatement.setString(2, grupo.getTipo());
            preparedStatement.setString(3, grupo.getDescricao());
            preparedStatement.setInt(4, grupo.getId());

            preparedStatement.execute();

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
    public int create(GrupoDePerguntasModel grupo) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO grupo_perguntas (tipo, descricao, id_instituicao)";
        sql += " VALUES(?, ?, ?);";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, grupo.getTipo());
            preparedStatement.setString(2, grupo.getDescricao());
            preparedStatement.setInt(3, grupo.getInstituicaoId());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                final int id = resultSet.getInt(1);
                grupo.setId(id);
            }

            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return grupo.getId();

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
