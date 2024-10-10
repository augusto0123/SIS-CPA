package usuario;

import fai.cpa.entities.UsuarioModel;
import port.UsuarioRepositorty;

public class CreateUsuario {
    private final UsuarioRepositorty usuarioRepositorty;

    public CreateUsuario(UsuarioRepositorty usuarioRepositorty) {
        this.usuarioRepositorty = usuarioRepositorty;
    }

    public int createUsuario(final UsuarioModel usuarioModel){
        if(usuarioModel == null){
            return -1;
        }
        if(usuarioModel.getEmail().isEmpty()
                || usuarioModel.getNome().isEmpty()
                || usuarioModel.getTelefone().isEmpty()
                || usuarioModel.getSenha().isEmpty()){
            return -1;
        }
        return usuarioRepositorty.create(usuarioModel);
    }
}
