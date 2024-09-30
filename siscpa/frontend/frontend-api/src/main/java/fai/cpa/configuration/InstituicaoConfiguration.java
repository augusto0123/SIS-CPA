package fai.cpa.configuration;

import fai.cpa.entities.InstituicaoModel;
import fai.cpa.instituicao.ShowAllInstituicoes;
import fai.cpa.port.RestService;
import fai.cpa.port.impl.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstituicaoConfiguration {
    @Bean
    public ShowAllInstituicoes showAllInstituicoes(){
        RestService<InstituicaoModel> restService = new RestApiController<>();
        return new ShowAllInstituicoes(restService);
    }
}
