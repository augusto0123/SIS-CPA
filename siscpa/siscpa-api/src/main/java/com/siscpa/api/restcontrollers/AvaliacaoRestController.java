package com.siscpa.api.restcontrollers;


import com.siscpa.api.configuration.AvaliacaoBackendConfiguration;
import fai.cpa.entities.AvaliacaoModel;
import org.springframework.web.bind.annotation.*;
import fai.cpa.entities.QuestionarioModel;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/avaliacao")
public class AvaliacaoRestController {

    private final AvaliacaoBackendConfiguration avaliacaoBackendConfiguration = new AvaliacaoBackendConfiguration();

    @PostMapping("/add")
    public int createAvaliacao(@RequestBody AvaliacaoModel avaliacao){
        return avaliacaoBackendConfiguration.createAvaliacao().createAvaliacao(avaliacao);
    }

    @GetMapping("/all")
    public List<AvaliacaoModel> getAvaliacoes(){
        List<AvaliacaoModel> avaliacoes = avaliacaoBackendConfiguration.findAvaliacao().find();
        return avaliacoes;
    }


    @PutMapping("/vincular-avaliacao")
    public boolean vincularAvaliacao(@RequestBody final AvaliacaoModel avaliacao){
        return avaliacaoBackendConfiguration.updateAvaliacao().vincularAvaliacao(avaliacao);
    }

    @GetMapping("/findByInstituicaoId/{id}")
    public List<AvaliacaoModel> getAvaliacoesByInstituicaoId(@PathVariable("id") int id){
        List<AvaliacaoModel> avaliacoes = avaliacaoBackendConfiguration.findAvaliacao().findAllByInstituicaoId(id);
        return avaliacoes;
    }

    @GetMapping("/findByEdicaoId/{id}")
    public List<AvaliacaoModel> getAvaliacaoByEdicaoId(@PathVariable("id") int id){
        List<AvaliacaoModel> avaliacoes = avaliacaoBackendConfiguration.findAvaliacao().findAllByEdicaoId(id);
        return avaliacoes;
    }
}
