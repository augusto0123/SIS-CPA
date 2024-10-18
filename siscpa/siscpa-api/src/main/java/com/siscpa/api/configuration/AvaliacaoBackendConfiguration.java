package com.siscpa.api.configuration;


import autoavaliacao.CreateAvaliacao;
import autoavaliacao.FindAvaliacao;
import autoavaliacao.UpdateAvaliacao;
import fai.cpa.repository.implementation.repository.AvaliacaoDaoPostgres;
import fai.cpa.repository.implementation.repository.InstituicaoDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.AvaliacaoRepository;
import port.InstituicaoRepository;

@Configuration
public class AvaliacaoBackendConfiguration {

    private final AvaliacaoRepository avaliacaoRepository;
    private final InstituicaoRepository instituicaoRepository;

    public AvaliacaoBackendConfiguration() {
        this.instituicaoRepository = new InstituicaoDaoPostgres();
        this.avaliacaoRepository = new AvaliacaoDaoPostgres();
    }

    @Bean
    public CreateAvaliacao createAvaliacao(){
        return new CreateAvaliacao(avaliacaoRepository,instituicaoRepository);
    }

    @Bean
    public FindAvaliacao findAvaliacao(){
        return new FindAvaliacao(avaliacaoRepository);
    }

    @Bean
    public UpdateAvaliacao updateAvaliacao(){
        return new UpdateAvaliacao(avaliacaoRepository);
    }
}
