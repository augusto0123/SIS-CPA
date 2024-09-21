package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.InstituicaoBackendConfiguration;
import fai.cpa.entities.InstituicaoModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/instituicao")
public class InstituicaoRestController {

    private final InstituicaoBackendConfiguration instituicaoBackendConfiguration = new InstituicaoBackendConfiguration();

    @GetMapping("/all")
    public List<InstituicaoModel> getInstituicoes(){
        List<InstituicaoModel> instituicoes = instituicaoBackendConfiguration.findInstituicao().find();
        return instituicoes;
    }
}
