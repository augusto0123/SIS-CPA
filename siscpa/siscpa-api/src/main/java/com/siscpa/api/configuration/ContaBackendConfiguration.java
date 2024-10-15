package com.siscpa.api.configuration;

import fai.cpa.repository.implementation.repository.InstituicaoDaoPostgres;
import fai.cpa.repository.implementation.repository.UsuarioDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.InstituicaoRepository;
import port.UsuarioRepositorty;
import usuario.CreateUsuario;
import usuario.FindUsuario;
import usuario.UpdateUsuario;

@Configuration
public class ContaBackendConfiguration {

    private final UsuarioRepositorty usuarioRepositorty;
    private final InstituicaoRepository instituicaoRepository;

    public ContaBackendConfiguration() {
        this.usuarioRepositorty = new UsuarioDaoPostgres();
        this.instituicaoRepository = new InstituicaoDaoPostgres();
    }

    @Bean
    public CreateUsuario createUsuario(){
        return new CreateUsuario(usuarioRepositorty, instituicaoRepository);
    }

    @Bean
    public FindUsuario findUsuario(){
        return new FindUsuario(usuarioRepositorty);
    }

    @Bean
    public UpdateUsuario updateUsuario(){
        return new UpdateUsuario(usuarioRepositorty);
    }

}
