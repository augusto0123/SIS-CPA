package fai.cpa.configuration;

import fai.cpa.autoavaliacao.CreateEdicao;
import fai.cpa.autoavaliacao.ShowAllEdicoes;
import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import fai.cpa.port.RestService;
import fai.cpa.port.impl.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EdicaoConfiguration {

    @Bean
    public CreateEdicao createEdicao(){
        RestService<EdicaoDeAutoAvaliacaoModel> restService = new RestApiController<>();
        return new CreateEdicao(restService);
    }

    @Bean
    public ShowAllEdicoes showAllEdicoes(){
        RestService<EdicaoDeAutoAvaliacaoModel> restService = new RestApiController<>();
        return new ShowAllEdicoes(restService);
    }
}
