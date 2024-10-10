package fai.cpa.configuration;


import fai.cpa.autoavaliacao.CreateReuniao;
import fai.cpa.autoavaliacao.ShowAllReunioes;
import fai.cpa.entities.ReuniaoCpaModel;
import fai.cpa.port.RestService;
import fai.cpa.port.impl.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReuniaoConfiguration {

    @Bean
    public ShowAllReunioes showAllReunioes(){
        RestService<ReuniaoCpaModel> restService = new RestApiController<>();
        return new ShowAllReunioes(restService);
    }

    @Bean
    public CreateReuniao createReuniao(){
        RestService<ReuniaoCpaModel> restService = new RestApiController<>();
        return new CreateReuniao(restService);
    }
}
