package port;

import fai.cpa.entities.MembroCpaModel;

import java.util.List;
import java.util.Map;

public interface MembroCpaRepository {

    MembroCpaModel findById(int id);
    List<MembroCpaModel> findAll();

    List<MembroCpaModel> findAllByCriteria(Map<String, String> criteria);

    boolean update(MembroCpaModel membroCpaModel);

    boolean deleteById(int id);

    int create(MembroCpaModel membroCpaModel);

}
