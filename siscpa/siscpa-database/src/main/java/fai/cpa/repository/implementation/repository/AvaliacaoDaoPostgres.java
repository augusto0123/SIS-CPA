package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.AvaliacaoModel;
import fai.cpa.entities.InstituicaoModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.AvaliacaoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AvaliacaoDaoPostgres implements AvaliacaoRepository {

    @Override
    public AvaliacaoModel findById(int id) {

        final AvaliacaoModel avaliacao =new AvaliacaoModel();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM avaliacao ";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                avaliacao.setId(resultSet.getInt("id"));
                avaliacao.setTema(resultSet.getString("tema"));
                avaliacao.setDescricao(resultSet.getString("descricao"));
//                avaliacao.setEdicaoId(resultSet.getInt("id_edicao_autoavaliacao"));
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return avaliacao;
    }

    @Override
    public List<AvaliacaoModel> findAll() {

        final List<AvaliacaoModel> avaliacoes = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM avaliacao;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final AvaliacaoModel avaliacao = new AvaliacaoModel();
                avaliacao.setId(resultSet.getInt("id"));
                avaliacao.setTema(resultSet.getString("tema"));
                avaliacao.setDescricao(resultSet.getString("descricao"));
//                avaliacao.setEdicaoId(resultSet.getInt("id_edicao_autoavaliacao"));

                avaliacoes.add(avaliacao);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return avaliacoes ;
    }

    @Override
    public List<AvaliacaoModel> findByCriteria(Map<String, String> criteria) {
        return null;
    }

    @Override
    public List<AvaliacaoModel> findAllByInstituicaoId(int instituicaoId) {
        final List<AvaliacaoModel> avaliacoes = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM avaliacao WHERE id_instituicao = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, instituicaoId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final AvaliacaoModel avaliacao = new AvaliacaoModel();
                avaliacao.setId(resultSet.getInt("id"));
                avaliacao.setTema(resultSet.getString("tema"));
                avaliacao.setDescricao(resultSet.getString("descricao"));
                avaliacao.setEdicaoId(resultSet.getInt("id_edicao_autoavaliacao"));
                avaliacao.setInstituicaoId(resultSet.getInt("id_instituicao"));

                avaliacoes.add(avaliacao);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return avaliacoes;
    }

    @Override
    public boolean update(AvaliacaoModel avaliacaoModel) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE avaliacao SET id_edicao_autoavaliacao = ?, descricao = ?, tema = ? ";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, avaliacaoModel.getEdicaoId());
            preparedStatement.setString(2, avaliacaoModel.getDescricao());
            preparedStatement.setString(3, avaliacaoModel.getTema());
            preparedStatement.setInt(4, avaliacaoModel.getId());

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
    public int create(AvaliacaoModel avaliacao) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO avaliacao (tema, descricao, id_instituicao)";
        sql += " VALUES(?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,avaliacao.getTema());
            preparedStatement.setString(2,avaliacao.getDescricao());
//            preparedStatement.setInt(3, avaliacao.getEdicaoId());
            preparedStatement.setInt(3,avaliacao.getInstituicaoId());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                final int id = resultSet.getInt(1);
                avaliacao.setId(id);
            }
            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return avaliacao.getId();

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
