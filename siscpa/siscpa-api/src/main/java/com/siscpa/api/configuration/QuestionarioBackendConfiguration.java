package com.siscpa.api.configuration;

import autoavaliacao.CreateQuestionario;
import autoavaliacao.FindQuestionario;
import autoavaliacao.UpdateQuestionario;
import fai.cpa.repository.implementation.repository.InstituicaoDaoPostgres;
import fai.cpa.repository.implementation.repository.QuestionarioDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.InstituicaoRepository;
import port.QuestionarioRepository;

@Configuration
public class QuestionarioBackendConfiguration {

    private final QuestionarioRepository questionarioRepository;

    private final InstituicaoRepository instituicaoRepository;

    public QuestionarioBackendConfiguration() {
        this.instituicaoRepository = new InstituicaoDaoPostgres();
        this.questionarioRepository = new QuestionarioDaoPostgres();
    }

    @Bean
    public CreateQuestionario createQuestionario(){
        return new CreateQuestionario(questionarioRepository, instituicaoRepository);
    }

    @Bean
    public FindQuestionario findQuestionario(){
        return new FindQuestionario(questionarioRepository);
    }

    @Bean
    public UpdateQuestionario updateQuestionario(){
        return new UpdateQuestionario(questionarioRepository);
    }
}
