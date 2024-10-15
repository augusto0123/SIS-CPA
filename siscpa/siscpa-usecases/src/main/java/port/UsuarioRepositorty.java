package port;

import fai.cpa.entities.UsuarioModel;

import java.util.List;
import java.util.Map;

public interface UsuarioRepositorty {
    UsuarioModel findById(int id);

    UsuarioModel findByEmaileSenha(String email, String senha);

    List<UsuarioModel> findByTipo(String tipo);
    List<UsuarioModel> findAll();
    List<UsuarioModel> findByCriteria(Map<String, String> criteria);
    boolean update(UsuarioModel usuarioModel);
    boolean deleteById(int id);
    int create(UsuarioModel usuarioModel);

    boolean updateById(UsuarioModel usuarioModel);

}
