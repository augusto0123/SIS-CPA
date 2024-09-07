package port;

import fai.cpa.entities.UsuarioModel;

import java.util.List;
import java.util.Map;

public interface UsuarioRepositorty {
    UsuarioModel findById(int id);
    List<UsuarioModel> findAll();
    List<UsuarioModel> findByCriteria(Map<String, String> criteria);
    boolean update(UsuarioModel usuarioModel);
    boolean deleteById(int id);
    int create(UsuarioModel usuarioModel);

}
