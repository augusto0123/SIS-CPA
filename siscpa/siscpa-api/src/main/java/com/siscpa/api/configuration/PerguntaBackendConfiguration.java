package com.siscpa.api.configuration;

import autoavaliacao.CreatePergunta;
import autoavaliacao.FindPergunta;
import fai.cpa.repository.implementation.repository.PerguntaDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.PerguntaRepository;

@Configuration
public class PerguntaBackendConfiguration {

    private final PerguntaRepository perguntaRepository;

    public PerguntaBackendConfiguration() {
        this.perguntaRepository = new PerguntaDaoPostgres();
    }

    @Bean
    public CreatePergunta createPergunta(){
        return new CreatePergunta(perguntaRepository);
    }

    @Bean
    public FindPergunta findPergunta(){
        return new FindPergunta(perguntaRepository);
    }
}
