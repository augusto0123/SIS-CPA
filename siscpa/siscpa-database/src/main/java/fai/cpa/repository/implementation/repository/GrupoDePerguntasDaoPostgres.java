package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.GrupoDePerguntasModel;
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
    public boolean update(GrupoDePerguntasModel grupoDePerguntasModel) {
        return false;
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

        String sql = "INSERT INTO grupo_perguntas (tipo, descricao)";
        sql += " VALUES(?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, grupo.getTipo());
            preparedStatement.setString(2, grupo.getDescricao());

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
