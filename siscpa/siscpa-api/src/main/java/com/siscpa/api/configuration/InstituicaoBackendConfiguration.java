package com.siscpa.api.configuration;

import fai.cpa.repository.implementation.repository.InstituicaoDaoPostgres;
import instituicao.CreateInstituicao;
import instituicao.FindInstituicao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.InstituicaoRepository;

@Configuration
public class InstituicaoBackendConfiguration {

    private final InstituicaoRepository instituicaoRepository;

    public InstituicaoBackendConfiguration() {
        this.instituicaoRepository = new InstituicaoDaoPostgres();
    }

    @Bean
    public FindInstituicao findInstituicao(){
        return new FindInstituicao(instituicaoRepository);
    }

    @Bean
    public CreateInstituicao createInstituicao(){
        return new CreateInstituicao(instituicaoRepository);
    }
}
