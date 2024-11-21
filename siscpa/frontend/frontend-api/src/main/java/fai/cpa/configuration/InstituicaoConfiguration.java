package fai.cpa.configuration;

import fai.cpa.conta.ShowAllUsuarios;
import fai.cpa.entities.InstituicaoModel;
import fai.cpa.entities.UsuarioModel;
import fai.cpa.instituicao.CreateInstituicao;
import fai.cpa.instituicao.ShowAllInstituicoes;
import fai.cpa.instituicao.UpdateFoto;
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

    @Bean
    public CreateInstituicao createInstituicao(){
        RestService<InstituicaoModel> restService = new RestApiController<>();
        return new CreateInstituicao(restService);
    }

    @Bean
    public UpdateFoto updateFoto(){
        RestService<InstituicaoModel> restService = new RestApiController<>();
        return new UpdateFoto(restService);
    }

}
