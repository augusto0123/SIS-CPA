package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.EdicaoDeAutoavaliacaoBackendConfiguration;
import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/edicoes")
public class EdicaoDeAutoavaliacaoRestController {

    private final EdicaoDeAutoavaliacaoBackendConfiguration edicaoDeAutoavaliacaoBackendConfiguration = new EdicaoDeAutoavaliacaoBackendConfiguration();

    @PostMapping("/add")
    public int getCreateEdicao(@RequestBody EdicaoDeAutoAvaliacaoModel edicaoDeAutoAvaliacaoModel){
        return edicaoDeAutoavaliacaoBackendConfiguration.createEdicaoDeAutoavaliacao().createEdicaoDeAutoavaliacao(edicaoDeAutoAvaliacaoModel);
    }

    @GetMapping("/all")
    public List<EdicaoDeAutoAvaliacaoModel> getEdicoes(){
        List<EdicaoDeAutoAvaliacaoModel> edicoes = edicaoDeAutoavaliacaoBackendConfiguration.findEdicaoDeAutoavaliacao().find();
        return edicoes;
    }
}
