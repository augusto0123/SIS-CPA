package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.InstituicaoModel;
import fai.cpa.entities.PerguntaModel;
import fai.cpa.entities.ReuniaoCpaModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.PerguntaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PerguntaDaoPostgres implements PerguntaRepository {
    @Override

    public PerguntaModel findById(int id) {
        final PerguntaModel pergunta = new PerguntaModel();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM pergunta ";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                pergunta.setId(resultSet.getInt("id"));
                pergunta.setDescricao(resultSet.getString("descricao"));
                pergunta.setTipo(resultSet.getString("tipo"));
                pergunta.setTipoEscala(resultSet.getInt("tipo_escala"));
            }
            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pergunta;
    }

    @Override
    public List<PerguntaModel> findAll() {

        final List<PerguntaModel> perguntas = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM pergunta;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final PerguntaModel pergunta = new PerguntaModel();
                pergunta.setId(resultSet.getInt("id"));
                pergunta.setDescricao(resultSet.getString("descricao"));
                pergunta.setTipo(resultSet.getString("tipo"));
                pergunta.setTipoEscala(resultSet.getInt("tipo_escala"));

                perguntas.add(pergunta);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return perguntas;
    }

    @Override
    public List<PerguntaModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(PerguntaModel perguntaModel) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public int create(PerguntaModel pergunta) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO pergunta (descricao, tipo, tipo_escala)";
        sql += " VALUES(?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,pergunta.getDescricao());
            preparedStatement.setString(2,pergunta.getTipo());
            preparedStatement.setInt(3,pergunta.getTipoEscala());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                final int id = resultSet.getInt(1);
                pergunta.setId(id);
            }
            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return pergunta.getId();

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
