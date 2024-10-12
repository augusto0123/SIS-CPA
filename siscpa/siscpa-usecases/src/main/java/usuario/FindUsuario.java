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
        final List<UsuarioModel> usuarios = usuarioRepositorty.findAll();
        if (usuarios == null){
            return null;
        }
        return usuarios;
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

    public UsuarioModel findByEmaileSenha(String email, String senha){
        if(email.isEmpty() || senha.isEmpty()){
            throw new InvalidException();
        }
        final UsuarioModel usuario = usuarioRepositorty.findByEmaileSenha(email, senha);
        if(usuario == null){
            final String message = "O id (" + email + ") nao foi encontrado";
            throw new NotFoundException(message);
        }
        return usuario;
    }
}
