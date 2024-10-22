package port;

import fai.cpa.entities.RespostaModel;

import java.util.List;

public interface RespostaRepository {

    RespostaModel findById(int id);

    List<RespostaModel> findAll();

    List<RespostaModel> findAllByPerguntaId(int perguntaId);
    List<RespostaModel> findAllByAvaliacaoId(int avaliacaoId);

    List<RespostaModel> findAllByInstituicao(int instituicaoId);

    boolean update(RespostaModel respostaModel);

    boolean deleteById(int id);

    int create(RespostaModel respostaModel);
}
