package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.PerguntaModel;
import fai.cpa.entities.RespostaModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.RespostaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RespostaDaoPostgres implements RespostaRepository {

    @Override
    public RespostaModel findById(int id) {

        final RespostaModel resposta = new RespostaModel();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM resposta ";
        sql += "WHERE id = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                resposta.setId(resultSet.getInt("id"));
                resposta.setRespostaObjetiva(resultSet.getString("resposta_objetiva"));
                resposta.setRespostaSubjetiva(resultSet.getString("resposta_subjetiva"));
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resposta;
    }

    @Override
    public List<RespostaModel> findAll() {
        final List<RespostaModel> respostas = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM resposta;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final RespostaModel resposta = new RespostaModel();
                resposta.setId(resultSet.getInt("id"));
                resposta.setRespostaObjetiva(resultSet.getString("resposta_objetiva"));
                resposta.setRespostaSubjetiva(resultSet.getString("resposta_subjetiva"));

                respostas.add(resposta);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return respostas;
    }

    @Override
    public List<RespostaModel> findAllByPerguntaId(int perguntaId) {

        final List<RespostaModel> respostas = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM resposta WHERE id_pergunta = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, perguntaId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final RespostaModel resposta = new RespostaModel();
                resposta.setId(resultSet.getInt("id"));
                resposta.setRespostaObjetiva(resultSet.getString("resposta_objetiva"));
                resposta.setRespostaSubjetiva(resultSet.getString("resposta_subjetiva"));
                resposta.setInstituicaoId(resultSet.getInt("id_instituicao"));
                resposta.setPerguntaId(resultSet.getInt("id_pergunta"));

                respostas.add(resposta);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return respostas;
    }

    @Override
    public List<RespostaModel> findAllByAvaliacaoId(int avaliacaoId) {

        final List<RespostaModel> respostas = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM resposta WHERE id_avaliacao = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, avaliacaoId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final RespostaModel resposta = new RespostaModel();
                resposta.setId(resultSet.getInt("id"));
                resposta.setRespostaObjetiva(resultSet.getString("resposta_objetiva"));
                resposta.setRespostaSubjetiva(resultSet.getString("resposta_subjetiva"));
                resposta.setInstituicaoId(resultSet.getInt("id_instituicao"));
                resposta.setPerguntaId(resultSet.getInt("id_pergunta"));
                resposta.setAvaliacaoId(resultSet.getInt("id_avaliacao"));

                respostas.add(resposta);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return respostas;
    }

    @Override
    public List<RespostaModel> findAllByInstituicao(int instituicaoId) {

        final List<RespostaModel> respostas = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        final String sql = "SELECT * FROM resposta WHERE id_instituicao = ?;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, instituicaoId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                final RespostaModel resposta = new RespostaModel();
                resposta.setId(resultSet.getInt("id"));
                resposta.setRespostaObjetiva(resultSet.getString("resposta_objetiva"));
                resposta.setRespostaSubjetiva(resultSet.getString("resposta_subjetiva"));
                resposta.setAvaliacaoId(resultSet.getInt("id_avaliacao"));
                resposta.setPerguntaId(resultSet.getInt("id_pergunta"));
                resposta.setInstituicaoId(resultSet.getInt("id_instituicao"));

                respostas.add(resposta);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return respostas;
    }

    @Override
    public boolean update(RespostaModel respostaModel) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public int create(RespostaModel respostaModel) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "INSERT INTO resposta (resposta_objetiva, resposta_subjetiva,id_pergunta, id_instituicao, id_usuario)";
        sql += " VALUES(?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,respostaModel.getRespostaObjetiva());
            preparedStatement.setString(2,respostaModel.getRespostaSubjetiva());
            preparedStatement.setInt(3, respostaModel.getPerguntaId());
            preparedStatement.setInt(4,respostaModel.getInstituicaoId());
            preparedStatement.setInt(5, respostaModel.getUsuarioId());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                final int id = resultSet.getInt(1);
                respostaModel.setId(id);
            }
            connection.commit();

            resultSet.close();
            preparedStatement.close();

            return respostaModel.getId();

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
