package port;

import fai.cpa.entities.PerguntaModel;
import fai.cpa.entities.QuestionarioModel;

import java.util.List;
import java.util.Map;

public interface PerguntaRepository {
    PerguntaModel findById(int id);
    List<PerguntaModel> findAll();
    List<PerguntaModel> findByCriteria(Map<String, String> criteria);
    boolean update(PerguntaModel perguntaModel);
    boolean deleteById(int id);
    int create(PerguntaModel perguntaModel);

    List<PerguntaModel> findAllByInstituicaoId(int instituicaoId);

    List<PerguntaModel> findAllByGrupoId(int grupoId);
}
