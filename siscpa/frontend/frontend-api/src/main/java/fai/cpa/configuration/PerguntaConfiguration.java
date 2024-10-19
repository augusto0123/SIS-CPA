package fai.cpa.configuration;

import fai.cpa.autoavaliacao.CreatePergunta;
import fai.cpa.autoavaliacao.ShowAllPerguntas;
import fai.cpa.autoavaliacao.UpdatePergunta;
import fai.cpa.entities.PerguntaModel;
import fai.cpa.port.RestService;
import fai.cpa.port.impl.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PerguntaConfiguration {

    @Bean
    public CreatePergunta createPergunta(){
        RestService<PerguntaModel> restService = new RestApiController<>();
        return new CreatePergunta(restService);
    }

    @Bean
    public ShowAllPerguntas showAllPerguntas(){
        RestService<PerguntaModel> restService = new RestApiController<>();
        return new ShowAllPerguntas(restService);
    }

    @Bean
    public UpdatePergunta updatePergunta(){
        RestService<PerguntaModel> restService = new RestApiController<>();
        return new UpdatePergunta(restService);
    }
}
