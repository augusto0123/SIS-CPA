package port;

import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;

import java.util.List;
import java.util.Map;

public interface EdicaoDeAutoavaliacaoRepository {
    EdicaoDeAutoAvaliacaoModel findById(int id);
    List<EdicaoDeAutoAvaliacaoModel> findAll();
    List<EdicaoDeAutoAvaliacaoModel> findByCriteria(Map<String, String> criteria);
    boolean update(EdicaoDeAutoAvaliacaoModel edicaoDeAutoAvaliacaoModel);
    boolean deleteById(int id);
    int create(EdicaoDeAutoAvaliacaoModel edicaoDeAutoAvaliacaoModel);
}
