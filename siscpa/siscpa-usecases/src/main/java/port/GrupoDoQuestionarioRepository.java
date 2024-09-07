package port;

import fai.cpa.entities.GrupoDePerguntasDoQuestionarioModel;
import fai.cpa.entities.InstituicaoModel;

import java.util.List;
import java.util.Map;

public interface GrupoDoQuestionarioRepository {

    GrupoDePerguntasDoQuestionarioModel findById(int id);
    List<GrupoDePerguntasDoQuestionarioModel> findAll();
    List<GrupoDePerguntasDoQuestionarioModel> findByCriteria(Map<String, String> criteria);
    boolean update(GrupoDePerguntasDoQuestionarioModel grupoDePerguntasDoQuestionarioModel);
    boolean deleteById(int id);
    int create(GrupoDePerguntasDoQuestionarioModel grupoDePerguntasDoQuestionarioModel);
}
