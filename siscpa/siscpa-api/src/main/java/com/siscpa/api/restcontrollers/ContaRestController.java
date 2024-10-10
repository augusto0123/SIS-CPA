package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.ContaBackendConfiguration;
import fai.cpa.entities.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usuario.CreateUsuario;

@RestController
@RequestMapping("/api/conta")
public class ContaRestController {

    private final ContaBackendConfiguration contaBackendConfiguration = new ContaBackendConfiguration();

    @PostMapping("/add")
    public int createUsuario(@RequestBody UsuarioModel usuario){
        return contaBackendConfiguration.createUsuario().createUsuario(usuario);
    }
}
