package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.EdicaoDeAutoavaliacaoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EdicaoDeAutoavaliacaoDaoPostgres implements EdicaoDeAutoavaliacaoRepository {

    @Override
    public EdicaoDeAutoAvaliacaoModel findById(int id) {
        return null;
    }

    @Override
    public List<EdicaoDeAutoAvaliacaoModel> findAll() {

        final List<EdicaoDeAutoAvaliacaoModel> edicoes = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM edicao_autoavaliacao;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final EdicaoDeAutoAvaliacaoModel edicao = new EdicaoDeAutoAvaliacaoModel();
                edicao.setId(resultSet.getInt("id"));
                edicao.setEdicao(resultSet.getInt("edicao"));
                edicao.setAnoDaAvaliacao(resultSet.getInt("ano_avaliacao"));
                edicao.setDescricao(resultSet.getString("descricao"));
                edicao.setDataInicio(resultSet.getDate("data_inicio").toLocalDate());
                edicao.setDataFim(resultSet.getDate("data_fim").toLocalDate());

                edicoes.add(edicao);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return edicoes;
    }

    @Override
    public List<EdicaoDeAutoAvaliacaoModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public boolean update(EdicaoDeAutoAvaliacaoModel edicaoDeAutoAvaliacaoModel) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public int create(EdicaoDeAutoAvaliacaoModel edicaoDeAutoAvaliacaoModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO edicao_autoavaliacao (edicao, ano_avaliacao, descricao, data_inicio, data_fim)";
        sql += "VALUES(?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, edicaoDeAutoAvaliacaoModel.getDescricao());
            preparedStatement.setInt(2, edicaoDeAutoAvaliacaoModel.getEdicao());
            preparedStatement.setInt(3, edicaoDeAutoAvaliacaoModel.getAnoDaAvaliacao());
            preparedStatement.setDate(4, Date.valueOf(edicaoDeAutoAvaliacaoModel.getDataFim()));
            preparedStatement.setDate(5, Date.valueOf(edicaoDeAutoAvaliacaoModel.getDataFim()));

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                final int id = resultSet.getInt(1);
                edicaoDeAutoAvaliacaoModel.setId(id);
            }

            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return edicaoDeAutoAvaliacaoModel.getId();

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
