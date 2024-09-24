package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.ReuniaoCpaModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.ReuniaoCpaRepository;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class ReuniaoDaoPostgres implements ReuniaoCpaRepository {
    @Override
    public ReuniaoCpaModel findById(int id) {

        final ReuniaoCpaModel reuniao = new ReuniaoCpaModel();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM reuniao_cpa";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                reuniao.setId(resultSet.getInt("id"));
                reuniao.setDataReuniao(resultSet.getDate("data_reuniao").toLocalDate());
                reuniao.setHorario(resultSet.getTime("horario").toLocalTime());
                reuniao.setPauta(resultSet.getString("pauta"));
                reuniao.setMembroCpaId(resultSet.getInt("id_membro_cpa"));
            }
            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return reuniao;
    }

    @Override
    public List<ReuniaoCpaModel> findAll() {
        return null;
    }

    @Override
    public List<ReuniaoCpaModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(ReuniaoCpaModel reuniaoCpaModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE reuniao_cpa SET pauta = ?, horario = ?, data_reuniao = ?";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, reuniaoCpaModel.getPauta());
            preparedStatement.setTime(2, Time.valueOf(reuniaoCpaModel.getHorario()));
            preparedStatement.setDate(3, Date.valueOf(reuniaoCpaModel.getDataReuniao()));

            preparedStatement.execute();

            preparedStatement.close();

            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public int create(ReuniaoCpaModel reuniaoCpaModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO reuniao_cpa (data_reuniao, horario, pauta, id_membro_cpa)";
        sql += "VALUES(?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDate(1, Date.valueOf(reuniaoCpaModel.getDataReuniao()));
            preparedStatement.setTime(2, Time.valueOf(reuniaoCpaModel.getHorario()));
            preparedStatement.setString(3, reuniaoCpaModel.getPauta());
            preparedStatement.setInt(4, reuniaoCpaModel.getMembroCpaId());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                final int id = resultSet.getInt(1);
                reuniaoCpaModel.setId(id);
            }

            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return reuniaoCpaModel.getId();

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
