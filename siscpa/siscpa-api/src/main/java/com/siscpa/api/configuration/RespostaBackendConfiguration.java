package com.siscpa.api.configuration;

import autoavaliacao.CreateResposta;
import autoavaliacao.FindResposta;
import fai.cpa.repository.implementation.repository.GraficoDaoPostgres;
import fai.cpa.repository.implementation.repository.PerguntaDaoPostgres;
import fai.cpa.repository.implementation.repository.RespostaDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.GraficoRepository;
import port.PerguntaRepository;
import port.RespostaRepository;

@Configuration
public class RespostaBackendConfiguration {

    private final RespostaRepository respostaRepository;

    private final GraficoRepository graficoRepository;

    private final PerguntaRepository perguntaRepository;


    public RespostaBackendConfiguration() {
        this.graficoRepository = new GraficoDaoPostgres();
        this.respostaRepository = new RespostaDaoPostgres();
        this.perguntaRepository = new PerguntaDaoPostgres();
    }

    @Bean
    public CreateResposta createResposta(){
        return new CreateResposta(respostaRepository);
    }

    @Bean
    public FindResposta findResposta(){
        return new FindResposta(respostaRepository, graficoRepository, perguntaRepository);
    }

}
