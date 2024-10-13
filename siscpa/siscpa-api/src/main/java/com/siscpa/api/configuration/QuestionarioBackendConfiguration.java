package com.siscpa.api.configuration;

import autoavaliacao.CreateQuestionario;
import autoavaliacao.FindQuestionario;
import fai.cpa.repository.implementation.repository.QuestionarioDaoPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import port.QuestionarioRepository;

@Configuration
public class QuestionarioBackendConfiguration {

    private final QuestionarioRepository questionarioRepository;

    public QuestionarioBackendConfiguration() {
        this.questionarioRepository = new QuestionarioDaoPostgres();
    }

    @Bean
    public CreateQuestionario createQuestionario(){
        return new CreateQuestionario(questionarioRepository);
    }

    public FindQuestionario findQuestionario(){
        return new FindQuestionario(questionarioRepository);
    }
}
