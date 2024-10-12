package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.EdicaoDeAutoavaliacaoBackendConfiguration;
import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/edicoes")
public class EdicaoDeAutoavaliacaoRestController {

    private final EdicaoDeAutoavaliacaoBackendConfiguration edicaoDeAutoavaliacaoBackendConfiguration = new EdicaoDeAutoavaliacaoBackendConfiguration();

    @GetMapping("/all")
    @CrossOrigin
    public List<EdicaoDeAutoAvaliacaoModel> getEdicoes(){
        List<EdicaoDeAutoAvaliacaoModel> edicoes = edicaoDeAutoavaliacaoBackendConfiguration.findEdicaoDeAutoavaliacao().find();
        return edicoes;
    }
    @PostMapping("/add")
    public int getCreateEdicao(@RequestBody EdicaoDeAutoAvaliacaoModel edicaoDeAutoAvaliacaoModel){
        return edicaoDeAutoavaliacaoBackendConfiguration.createEdicaoDeAutoavaliacao().createEdicaoDeAutoavaliacao(edicaoDeAutoAvaliacaoModel);
    }

}
