package fai.cpa.conta;

import fai.cpa.entities.UsuarioModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowAllUsuarios {

    private final RestService<UsuarioModel> restService;

    public ShowAllUsuarios(RestService<UsuarioModel> restService) {
        this.restService = restService;
    }

    public List<UsuarioModel> showAllUsuarios(){
        final String resource = "/conta/all";
        final List<UsuarioModel> usuarios = restService.get(resource);
        return usuarios;
    }
}
