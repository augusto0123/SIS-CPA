package com.siscpa.api.configuration;


import autoavaliacao.CreateAvaliacao;
import autoavaliacao.FindAvaliacao;
import fai.cpa.repository.implementation.repository.AvaliacaoDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.AvaliacaoRepository;

@Configuration
public class AvaliacaoBackendConfiguration {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoBackendConfiguration() {
        this.avaliacaoRepository = new AvaliacaoDaoPostgres();
    }

    @Bean
    public CreateAvaliacao createAvaliacao(){
        return new CreateAvaliacao(avaliacaoRepository);
    }

    @Bean
    public FindAvaliacao findAvaliacao(){
        return new FindAvaliacao(avaliacaoRepository);
    }
}
