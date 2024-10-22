package fai.cpa.configuration;

import fai.cpa.autoavaliacao.CreateResposta;
import fai.cpa.autoavaliacao.ShowAllRespostas;
import fai.cpa.entities.RespostaModel;
import fai.cpa.port.RestService;
import fai.cpa.port.impl.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RespostaConfiguration {

    @Bean
    public CreateResposta createResposta(){
        RestService<RespostaModel> restService = new RestApiController<>();
        return new CreateResposta(restService);
    }

    @Bean
    public ShowAllRespostas showAllRespostas(){
        RestService<RespostaModel> restService = new RestApiController<>();
        return new ShowAllRespostas(restService);
    }

}
