package usuario;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.UsuarioModel;
import port.UsuarioRepositorty;

import java.util.List;

public class FindUsuario {

    private final UsuarioRepositorty usuarioRepositorty;

    public FindUsuario(UsuarioRepositorty usuarioRepositorty) {
        this.usuarioRepositorty = usuarioRepositorty;
    }

    public List<UsuarioModel> find(){
        final List<UsuarioModel> user = usuarioRepositorty.findAll();
        if(user == null){
            return null;
        }
        return user;
    }
    public UsuarioModel find(final int id){
        if(id < 0){
            throw new InvalidException();
        }
        final UsuarioModel usuario = usuarioRepositorty.findById(id);
        if(usuario == null){
            final String message = "O id (" + id + ") nao foi encontrado";
            throw new NotFoundException(message);
        }
        return usuario;
    }
}
