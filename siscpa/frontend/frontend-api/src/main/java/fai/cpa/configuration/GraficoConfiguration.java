package fai.cpa.configuration;

import fai.cpa.autoavaliacao.CreateResposta;
import fai.cpa.autoavaliacao.ShowAllGraficos;
import fai.cpa.entities.GraficoModel;
import fai.cpa.entities.RespostaModel;
import fai.cpa.port.RestService;
import fai.cpa.port.impl.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraficoConfiguration {

    @Bean
    public ShowAllGraficos showAllGraficos(){
        RestService<GraficoModel> restService = new RestApiController<>();
        return new ShowAllGraficos(restService);
    }
}
