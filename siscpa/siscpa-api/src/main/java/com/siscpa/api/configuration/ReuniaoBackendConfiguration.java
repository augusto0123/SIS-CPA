package com.siscpa.api.configuration;

import autoavaliacao.CreateReuniaoCpa;
import autoavaliacao.FindReuniaoCpa;
import autoavaliacao.UpdateReuniaoCpa;
import fai.cpa.repository.implementation.repository.ReuniaoDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.ReuniaoCpaRepository;

@Configuration
public class ReuniaoBackendConfiguration {

    private final ReuniaoCpaRepository reuniaoCpaRepository;

    public ReuniaoBackendConfiguration() {
        this.reuniaoCpaRepository = new ReuniaoDaoPostgres();
    }

    @Bean
    public CreateReuniaoCpa createReuniaoCpa(){
        return new CreateReuniaoCpa(reuniaoCpaRepository);
    }

    @Bean
    public FindReuniaoCpa findReuniaoCpa(){
        return new FindReuniaoCpa(reuniaoCpaRepository);
    }

    @Bean
    public UpdateReuniaoCpa updateReuniaoCpa(){
        return new UpdateReuniaoCpa(reuniaoCpaRepository);
    }
}
