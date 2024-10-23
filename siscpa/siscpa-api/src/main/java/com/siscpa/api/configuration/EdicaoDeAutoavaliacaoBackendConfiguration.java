package com.siscpa.api.configuration;

import autoavaliacao.CreateEdicaoDeAutoavaliacao;
import autoavaliacao.FindEdicaoDeAutoavaliacao;
import autoavaliacao.UpdateEdicao;
import fai.cpa.repository.implementation.repository.EdicaoDeAutoavaliacaoDaoPostgres;
import fai.cpa.repository.implementation.repository.InstituicaoDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.EdicaoDeAutoavaliacaoRepository;
import port.InstituicaoRepository;

@Configuration
public class EdicaoDeAutoavaliacaoBackendConfiguration {

    private final EdicaoDeAutoavaliacaoRepository edicaoDeAutoavaliacaoRepository;

    private final InstituicaoRepository instituicaoRepository;

    public EdicaoDeAutoavaliacaoBackendConfiguration() {
        this.instituicaoRepository = new InstituicaoDaoPostgres();
        this.edicaoDeAutoavaliacaoRepository = new EdicaoDeAutoavaliacaoDaoPostgres();
    }

    @Bean
    public CreateEdicaoDeAutoavaliacao createEdicaoDeAutoavaliacao(){
        return new CreateEdicaoDeAutoavaliacao(edicaoDeAutoavaliacaoRepository, instituicaoRepository);
    }

    @Bean
    public FindEdicaoDeAutoavaliacao findEdicaoDeAutoavaliacao(){
        return new FindEdicaoDeAutoavaliacao(edicaoDeAutoavaliacaoRepository);
    }

    @Bean
    public UpdateEdicao updateEdicao(){
        return new UpdateEdicao(edicaoDeAutoavaliacaoRepository);
    }

}
