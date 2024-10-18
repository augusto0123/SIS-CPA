package fai.cpa.configuration;

import fai.cpa.autoavaliacao.CreateGrupo;
import fai.cpa.autoavaliacao.ShowAllGrupos;
import fai.cpa.autoavaliacao.UpdateGrupo;
import fai.cpa.entities.GrupoDePerguntasModel;
import fai.cpa.port.RestService;
import fai.cpa.port.impl.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrupoConfiguration {

    @Bean
    public CreateGrupo createGrupo(){
        RestService<GrupoDePerguntasModel> restService = new RestApiController<>();
        return new CreateGrupo(restService);
    }

    @Bean
    public ShowAllGrupos showAllGrupos(){
        RestService<GrupoDePerguntasModel> restService = new RestApiController<>();
        return new ShowAllGrupos(restService);
    }

    @Bean
    public UpdateGrupo updateGrupo(){
        RestService<GrupoDePerguntasModel> restService = new RestApiController<>();
        return new UpdateGrupo(restService);
    }
}
