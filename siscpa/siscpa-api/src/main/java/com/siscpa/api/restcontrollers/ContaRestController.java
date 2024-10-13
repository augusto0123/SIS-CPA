package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.ContaBackendConfiguration;
import fai.cpa.entities.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usuario.CreateUsuario;

import java.util.List;

@RestController
@RequestMapping("/api/conta")
public class ContaRestController {

    private final ContaBackendConfiguration contaBackendConfiguration = new ContaBackendConfiguration();

    @PostMapping("/add")
    public int createUsuario(@RequestBody UsuarioModel usuario){
        return contaBackendConfiguration.createUsuario().createUsuario(usuario);
    }

    @GetMapping("/all")
    @CrossOrigin
    public List<UsuarioModel> getUsuarios(){
        List<UsuarioModel> usuarios = contaBackendConfiguration.findUsuario().find();
        return usuarios;
    }

    @GetMapping("/findById/{id}")
    @CrossOrigin
    public UsuarioModel findById(@PathVariable final int id){
        return contaBackendConfiguration.findUsuario().find(id);
    }

    @GetMapping("/findByTipo/{tipo}")
    @CrossOrigin
    public List<UsuarioModel> findByTipo(@PathVariable final String tipo){
        return contaBackendConfiguration.findUsuario().findByTipo(tipo);
    }


    @PostMapping("/login")
    public UsuarioModel login(@RequestParam String email,@RequestParam String senha){
        return contaBackendConfiguration.findUsuario().findByEmaileSenha(email, senha);
    }
}
