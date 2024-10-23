package fai.cpa.repository.implementation.repository;

import fai.cpa.entities.GraficoModel;
import fai.cpa.entities.RespostaModel;
import fai.cpa.repository.implementation.repository.connection.ConnectionFactory;
import port.GraficoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GraficoDaoPostgres implements GraficoRepository {
    @Override
    public int create(GraficoModel grafico) {
        return 0;
    }

    @Override
    public List<GraficoModel> findAllByInstituicaoId(int instituicaoId) {
        return null;
    }

    @Override
    public GraficoModel findById(int id) {
        return null;
    }

    @Override
    public List<GraficoModel> findAll() {
        return null;
    }

    @Override
    public List<GraficoModel> findObjetivaByAvaliacaoId(int avaliacaoId) {
        final List<GraficoModel> graficos = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT r.resposta_objetiva, COUNT(*) AS total, a.id " +
                "FROM resposta r " +
                "INNER JOIN pergunta p ON r.id_pergunta = p.id " +
                "INNER JOIN grupo_perguntas g ON p.id_grupo_perguntas = g.id " +
                "INNER JOIN questionario q ON g.id_questionario = q.id " +
                "INNER JOIN avaliacao a ON q.id_avaliacao = a.id " +
                "INNER JOIN edicao_autoavaliacao e ON a.id_edicao_autoavaliacao = e.id " +
                "INNER JOIN instituicao i ON e.id_instituicao = i.id " +
                "INNER JOIN usuario u ON r.id_usuario = u.id " +
                "WHERE e.id = ? " +
                "GROUP BY r.resposta_objetiva, a.id;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, avaliacaoId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GraficoModel grafico = new GraficoModel();
                grafico.setLabel(resultSet.getString("resposta_objetiva"));
                grafico.setTotal(resultSet.getInt("total"));
                grafico.setAvaliacaoId(resultSet.getInt("id"));
                graficos.add(grafico);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return graficos;
    }

    @Override
    public List<RespostaModel> findSubjetivaByAvaliacaoId(int avaliacaoId) {
        final List<RespostaModel> respostaModels = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT r.* " +
                "FROM resposta r " +
                "INNER JOIN pergunta p ON r.id_pergunta = p.id " +
                "INNER JOIN grupo_perguntas g ON p.id_grupo_perguntas = g.id " +
                "INNER JOIN questionario q ON g.id_questionario = q.id " +
                "INNER JOIN avaliacao a ON q.id_avaliacao = a.id " +
                "WHERE a.id = ? AND r.resposta_subjetiva IS NOT NULL AND r.resposta_subjetiva != '' ;";

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, avaliacaoId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RespostaModel resposta = new RespostaModel();
                resposta.setRespostaSubjetiva(resultSet.getString("resposta_subjetiva"));
                resposta.setAvaliacaoId(resultSet.getInt("id_avaliacao"));
                resposta.setPerguntaId(resultSet.getInt("id_pergunta"));

                respostaModels.add(resposta);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return respostaModels;
    }
}
