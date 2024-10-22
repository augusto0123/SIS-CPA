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

    public UsuarioModel findById(final int id){
        final String resource = "/conta/findById/" + id;
        final UsuarioModel usuario = restService.getById(resource, UsuarioModel.class);
        return usuario;
    }

    public List<UsuarioModel> findByTipo(final String tipo){
        final String resource = "/conta/findByTipo/" + tipo;
        final List<UsuarioModel> usuarios = restService.get(resource);
        return usuarios;
    }

    public List<UsuarioModel> findAllByInstituicaoId(final int id){
        final String resource = "/conta/findAllByInstituicaoId/" + id;
        final List<UsuarioModel> usuarios = restService.get(resource);
        return usuarios;
    }
}
