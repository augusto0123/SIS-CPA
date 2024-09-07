package port;

import fai.cpa.entities.InstituicaoModel;
import fai.cpa.entities.QuestionarioModel;

import java.util.List;
import java.util.Map;

public interface QuestionarioRepository {

    QuestionarioModel findById(int id);
    List<QuestionarioModel> findAll();
    List<QuestionarioModel> findByCriteria(Map<String, String> criteria);
    boolean update(QuestionarioModel questionarioModel);
    boolean deleteById(int id);
    int create(QuestionarioModel questionarioModel);
}
