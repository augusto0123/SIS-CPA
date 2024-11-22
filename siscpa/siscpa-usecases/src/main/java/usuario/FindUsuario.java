package usuario;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.PerguntaModel;
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

    public List<UsuarioModel> findByTipoAndInstituicaoId(String tipo, int instituicaoId){
        if (tipo == null || tipo.isEmpty()){
            throw new InvalidException();
        }

        final List<UsuarioModel> usuarios = usuarioRepositorty.findByTipoAndInstituicaoId(tipo,instituicaoId);
        if (usuarios == null || usuarios.isEmpty()){
            final String message = "Nenhum usuário do tipo: (" + ") foi encontrado";
            return null;
        }
        return usuarios;
    }

    public List<UsuarioModel> findAllByInstituicaoId(final int instituicaoId){
        if (instituicaoId <= 0){
            throw new InvalidException();
        }
        List<UsuarioModel> usuarios = usuarioRepositorty.findAllByInstituicaoId(instituicaoId);
        if (usuarios == null){
            final String message = "O id (" + instituicaoId + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return usuarios;
    }
}
