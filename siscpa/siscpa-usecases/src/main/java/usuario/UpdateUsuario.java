package usuario;

import fai.cpa.entities.UsuarioModel;
import port.UsuarioRepositorty;

public class UpdateUsuario {

    private final UsuarioRepositorty usuarioRepositorty;

    public UpdateUsuario(UsuarioRepositorty usuarioRepositorty) {
        this.usuarioRepositorty = usuarioRepositorty;
    }

    public boolean update(final UsuarioModel usuarioModel){
        final UsuarioModel byId = usuarioRepositorty.findById(usuarioModel.getId());
        byId.setTelefone(usuarioModel.getTelefone());
        byId.setEmail(usuarioModel.getEmail());
        byId.setNome(usuarioModel.getNome());
        byId.setSenha(usuarioModel.getSenha());
        byId.setTipo(usuarioModel.getTipo());

        boolean updateUsuario = false;
        try {
            updateUsuario = usuarioRepositorty.update(byId);
            return updateUsuario;
        } catch (Exception e){
            return true;
        }
    }

    public boolean updateById(final UsuarioModel usuarioModel) {

        final UsuarioModel byId = usuarioRepositorty.findById(usuarioModel.getId());

        if (byId == null) {
            return false;
        }

        byId.setInstituicaoId(usuarioModel.getInstituicaoId());
        byId.setTipo(usuarioModel.getTipo());

        try {
            return usuarioRepositorty.updateById(byId);
        } catch (Exception e) {
            return false;
        }
    }
}
