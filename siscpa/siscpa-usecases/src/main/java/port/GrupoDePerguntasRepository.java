package port;

import fai.cpa.entities.GrupoDePerguntasDoQuestionarioModel;
import fai.cpa.entities.GrupoDePerguntasModel;

import java.util.List;
import java.util.Map;

public interface GrupoDePerguntasRepository {

    GrupoDePerguntasModel findById(int id);
    List<GrupoDePerguntasModel> findAll();
    List<GrupoDePerguntasModel> findByCriteria(Map<String, String> criteria);
    boolean update(GrupoDePerguntasModel grupoDePerguntasModel);
    boolean deleteById(int id);
    int create(GrupoDePerguntasModel grupoDePerguntasModel);
}
