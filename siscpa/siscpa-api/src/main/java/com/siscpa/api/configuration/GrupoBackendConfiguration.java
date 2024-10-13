package com.siscpa.api.configuration;

import autoavaliacao.CreateGrupoDePerguntas;
import autoavaliacao.FindGrupoDePerguntas;
import fai.cpa.repository.implementation.repository.GrupoDePerguntasDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.GrupoDePerguntasRepository;

@Configuration
public class GrupoBackendConfiguration {

    private final GrupoDePerguntasRepository grupoDePerguntasRepository;

    public GrupoBackendConfiguration() {
        this.grupoDePerguntasRepository = new GrupoDePerguntasDaoPostgres();
    }

    @Bean
    public FindGrupoDePerguntas findGrupoDePerguntas(){
        return new FindGrupoDePerguntas(grupoDePerguntasRepository);
    }

    @Bean
    public CreateGrupoDePerguntas createGrupoDePerguntas(){
        return new CreateGrupoDePerguntas(grupoDePerguntasRepository);
    }
}
