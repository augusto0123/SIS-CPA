package com.siscpa.api.configuration;

import endereco.CreateEndereco;
import fai.cpa.repository.implementation.repository.EnderecoDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.EnderecoRepository;

@Configuration
public class EnderecoBackendConfiguration {

    private final EnderecoRepository enderecoRepository;

    public EnderecoBackendConfiguration() {
        this.enderecoRepository = new EnderecoDaoPostgres();
    }

    @Bean
    public CreateEndereco createEndereco(){
        return new CreateEndereco(enderecoRepository);
    }
}
