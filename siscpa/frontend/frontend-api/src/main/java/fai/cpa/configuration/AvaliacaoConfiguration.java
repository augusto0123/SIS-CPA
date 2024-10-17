package fai.cpa.configuration;

import fai.cpa.autoavaliacao.CreateAvaliacao;
import fai.cpa.autoavaliacao.ShowAllAvaliacoes;
import fai.cpa.autoavaliacao.UpdateAvaliacao;
import fai.cpa.entities.AvaliacaoModel;
import fai.cpa.port.RestService;
import fai.cpa.port.impl.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvaliacaoConfiguration {

    @Bean
    public CreateAvaliacao createAvaliacao(){
        RestService<AvaliacaoModel> restService = new RestApiController<>();
        return new CreateAvaliacao(restService);
    }

    @Bean
    public ShowAllAvaliacoes showAllAvaliacoes(){
        RestService<AvaliacaoModel> restService = new RestApiController<>();
        return new ShowAllAvaliacoes(restService);
    }

    @Bean
    UpdateAvaliacao updateAvaliacao(){
        RestService<AvaliacaoModel> restService = new RestApiController<>();
        return new UpdateAvaliacao (restService);
    }

}
