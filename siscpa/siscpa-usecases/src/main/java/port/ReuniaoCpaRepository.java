package port;

import fai.cpa.entities.ReuniaoCpaModel;

import java.util.List;
import java.util.Map;

public interface ReuniaoCpaRepository {

    ReuniaoCpaModel findById(int id);
    List<ReuniaoCpaModel> findAll();
    List<ReuniaoCpaModel> findByCriteria(Map<String, String> criteria);
    boolean update(ReuniaoCpaModel reuniaoCpaModel);
    boolean deleteById(int id);
    int create(ReuniaoCpaModel reuniaoCpaModel);
}
