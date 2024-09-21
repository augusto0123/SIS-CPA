package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.EnderecoBackendConfiguration;
import fai.cpa.entities.EnderecoModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/endereco")
public class EnderecoRestController {

    private final EnderecoBackendConfiguration enderecoBackendConfiguration = new EnderecoBackendConfiguration();

    @PostMapping("/add")
    public int getCreateEndereco(@RequestBody EnderecoModel enderecoModel){
        return enderecoBackendConfiguration.createEndereco().createEndereco(enderecoModel);
    }
}
