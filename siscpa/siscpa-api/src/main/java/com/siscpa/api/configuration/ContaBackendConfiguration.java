package com.siscpa.api.configuration;

import fai.cpa.repository.implementation.repository.UsuarioDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.UsuarioRepositorty;
import usuario.CreateUsuario;
import usuario.FindUsuario;

@Configuration
public class ContaBackendConfiguration {

    private final UsuarioRepositorty usuarioRepositorty;

    public ContaBackendConfiguration() {
        this.usuarioRepositorty = new UsuarioDaoPostgres();
    }

    @Bean
    public CreateUsuario createUsuario(){
        return new CreateUsuario(usuarioRepositorty);
    }

    @Bean
    public FindUsuario findUsuario(){
        return new FindUsuario(usuarioRepositorty);
    }
}
