package port;

import fai.cpa.entities.AvaliacaoModel;
import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;

import java.util.List;
import java.util.Map;

public interface AvaliacaoRepository {

    AvaliacaoModel findById(int id);

    List<AvaliacaoModel> findAll();

    List<AvaliacaoModel> findByCriteria(Map<String, String> criteria);

    List<AvaliacaoModel> findAllByInstituicaoId(int instituicaoId);

    boolean update(AvaliacaoModel avaliacaoModel);

    boolean deleteById(int id);

    int create(AvaliacaoModel avaliacaoModel);
}
