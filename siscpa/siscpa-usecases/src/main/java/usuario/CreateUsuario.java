package usuario;

import fai.cpa.entities.UsuarioModel;
import port.InstituicaoRepository;
import port.UsuarioRepositorty;

public class CreateUsuario {
    private final UsuarioRepositorty usuarioRepositorty;

    private final InstituicaoRepository instituicaoRepository;

    public CreateUsuario(UsuarioRepositorty usuarioRepositorty, InstituicaoRepository instituicaoRepository) {
        this.usuarioRepositorty = usuarioRepositorty;
        this.instituicaoRepository = instituicaoRepository;
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
