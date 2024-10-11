package fai.cpa.configuration;

import fai.cpa.conta.CreateUsuario;
import fai.cpa.conta.ShowAllUsuarios;
import fai.cpa.entities.InstituicaoModel;
import fai.cpa.entities.UsuarioModel;
import fai.cpa.instituicao.ShowAllInstituicoes;
import fai.cpa.port.RestService;
import fai.cpa.port.impl.RestApiController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContaConfiguration {

    @Bean
    public CreateUsuario createUsuario(){
        RestService<UsuarioModel> restService = new RestApiController<>();
        return new CreateUsuario(restService);
    }

    @Bean
    public ShowAllUsuarios showAllUsuarios(){
        RestService<UsuarioModel> restService = new RestApiController<>();
        return new ShowAllUsuarios(restService);
    }
}
