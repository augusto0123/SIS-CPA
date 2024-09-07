package port;

import fai.cpa.entities.InstituicaoModel;

import java.util.List;
import java.util.Map;

public interface InstituicaoRepository {

    InstituicaoModel findById(int id);
    List<InstituicaoModel> findAll();
    List<InstituicaoModel> findByCriteria(Map<String, String> criteria);
    boolean update(InstituicaoModel instituicaoModel);
    boolean deleteById(int id);
    int create(InstituicaoModel instituicaoModel);

}
