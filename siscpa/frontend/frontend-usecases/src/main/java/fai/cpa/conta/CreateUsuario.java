package fai.cpa.conta;

import fai.cpa.entities.ReuniaoCpaModel;
import fai.cpa.entities.UsuarioModel;
import fai.cpa.port.RestService;

public class CreateUsuario {

    private final RestService<UsuarioModel> restService;

    public CreateUsuario(RestService<UsuarioModel> restService) {
        this.restService = restService;
    }

    public int createUsuario(UsuarioModel usuario){
        final String resource = "/conta/add";
        final int id = restService.post(resource, usuario);
        return id;
    }

    public UsuarioModel login(String email, String senha){
        final String resource = "/conta/login?email=" + email + "&senha=" + senha ;
        final UsuarioModel usuarioModel = restService.login(resource);
        return usuarioModel;
    }
}
