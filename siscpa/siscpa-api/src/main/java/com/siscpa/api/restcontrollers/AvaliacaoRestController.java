package com.siscpa.api.restcontrollers;


import com.siscpa.api.configuration.AvaliacaoBackendConfiguration;
import fai.cpa.entities.AvaliacaoModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoRestController {

    private final AvaliacaoBackendConfiguration avaliacaoBackendConfiguration = new AvaliacaoBackendConfiguration();

    @PostMapping("/add")
    public int createAvaliacao(@RequestBody AvaliacaoModel avaliacao){
        return avaliacaoBackendConfiguration.createAvaliacao().createAvaliacao(avaliacao);
    }

    @GetMapping("/all")
    @CrossOrigin
    public List<AvaliacaoModel> getAvaliacoes(){
        List<AvaliacaoModel> avaliacoes = avaliacaoBackendConfiguration.findAvaliacao().find();
        return avaliacoes;
    }

}
