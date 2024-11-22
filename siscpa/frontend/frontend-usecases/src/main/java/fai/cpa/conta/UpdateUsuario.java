package fai.cpa.conta;

import fai.cpa.entities.UsuarioModel;
import fai.cpa.port.RestService;

public class UpdateUsuario {

    private final RestService<UsuarioModel> restService;

    public UpdateUsuario(RestService<UsuarioModel> restService) {
        this.restService = restService;
    }

    public boolean updateUsuario(final UsuarioModel usuarioModel){
        final String resource = "/conta/vincular-usuario";
        boolean usuario = restService.put(resource, usuarioModel);
        return usuario;
    }

    public boolean updateAll(final UsuarioModel usuarioModel){
        final String resource = "/conta/update/" + usuarioModel.getId();
        boolean result = restService.put(resource, usuarioModel);
        return result;
    }
}
