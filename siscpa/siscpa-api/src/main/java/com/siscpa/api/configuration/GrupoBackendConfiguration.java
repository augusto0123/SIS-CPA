package com.siscpa.api.configuration;

import autoavaliacao.CreateGrupoDePerguntas;
import autoavaliacao.FindGrupoDePerguntas;
import autoavaliacao.UpdateGrupo;
import fai.cpa.repository.implementation.repository.GrupoDePerguntasDaoPostgres;
import fai.cpa.repository.implementation.repository.InstituicaoDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.GrupoDePerguntasRepository;
import port.InstituicaoRepository;

@Configuration
public class GrupoBackendConfiguration {

    private final GrupoDePerguntasRepository grupoDePerguntasRepository;

    private final InstituicaoRepository instituicaoRepository;

    public GrupoBackendConfiguration() {
        this.instituicaoRepository = new InstituicaoDaoPostgres();
        this.grupoDePerguntasRepository = new GrupoDePerguntasDaoPostgres();
    }

    @Bean
    public FindGrupoDePerguntas findGrupoDePerguntas(){
        return new FindGrupoDePerguntas(grupoDePerguntasRepository);
    }

    @Bean
    public CreateGrupoDePerguntas createGrupoDePerguntas(){
        return new CreateGrupoDePerguntas(grupoDePerguntasRepository, instituicaoRepository);
    }

    @Bean
    public UpdateGrupo updateGrupo(){
        return new UpdateGrupo(grupoDePerguntasRepository);
    }
}
