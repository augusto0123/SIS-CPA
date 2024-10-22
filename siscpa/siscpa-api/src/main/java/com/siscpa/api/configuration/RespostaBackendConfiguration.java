package com.siscpa.api.configuration;

import autoavaliacao.CreateResposta;
import autoavaliacao.FindResposta;
import fai.cpa.repository.implementation.repository.GraficoDaoPostgres;
import fai.cpa.repository.implementation.repository.RespostaDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.GraficoRepository;
import port.RespostaRepository;

@Configuration
public class RespostaBackendConfiguration {

    private final RespostaRepository respostaRepository;

    private final GraficoRepository graficoRepository;


    public RespostaBackendConfiguration() {
        this.graficoRepository = new GraficoDaoPostgres();
        this.respostaRepository = new RespostaDaoPostgres();
    }

    @Bean
    public CreateResposta createResposta(){
        return new CreateResposta(respostaRepository);
    }

    @Bean
    public FindResposta findResposta(){
        return new FindResposta(respostaRepository, graficoRepository);
    }

}
