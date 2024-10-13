package fai.cpa.configuration;

import fai.cpa.autoavaliacao.CreateQuestionario;
import fai.cpa.autoavaliacao.ShowAllQuestionarios;
import fai.cpa.entities.QuestionarioModel;
import fai.cpa.port.RestService;
import fai.cpa.port.impl.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionarioConfiguration {

    @Bean
    public CreateQuestionario createQuestionario(){
        RestService<QuestionarioModel> restService = new RestApiController<>();
        return new CreateQuestionario(restService);
    }

    @Bean
    public ShowAllQuestionarios showAllQuestionarios(){
        RestService<QuestionarioModel> restService = new RestApiController<>();
        return new ShowAllQuestionarios(restService);
    }

}
