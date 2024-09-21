package com.siscpa.api.configuration;

import autoavaliacao.CreateEdicaoDeAutoavaliacao;
import autoavaliacao.FindEdicaoDeAutoavaliacao;
import fai.cpa.repository.implementation.repository.EdicaoDeAutoavaliacaoDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.EdicaoDeAutoavaliacaoRepository;

@Configuration
public class EdicaoDeAutoavaliacaoBackendConfiguration {

    private final EdicaoDeAutoavaliacaoRepository edicaoDeAutoavaliacaoRepository;

    public EdicaoDeAutoavaliacaoBackendConfiguration() {
        this.edicaoDeAutoavaliacaoRepository = new EdicaoDeAutoavaliacaoDaoPostgres();
    }

    @Bean
    public CreateEdicaoDeAutoavaliacao createEdicaoDeAutoavaliacao(){
        return new CreateEdicaoDeAutoavaliacao(edicaoDeAutoavaliacaoRepository);
    }

    @Bean
    public FindEdicaoDeAutoavaliacao findEdicaoDeAutoavaliacao(){
        return new FindEdicaoDeAutoavaliacao(edicaoDeAutoavaliacaoRepository);
    }

}
