package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.PerguntaBackendConfiguration;
import fai.cpa.entities.PerguntaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pergunta")
public class PerguntaRestController {

    private final PerguntaBackendConfiguration perguntaBackendConfiguration = new PerguntaBackendConfiguration();

    @GetMapping("/all")
    @CrossOrigin
    public List<PerguntaModel> getPerguntas(){
        List<PerguntaModel> perguntas = perguntaBackendConfiguration.findPergunta().find();
        return perguntas;
    }

    @PostMapping("/add")
    public int getCreatePergunta(@RequestBody PerguntaModel pergunta){
        return perguntaBackendConfiguration.createPergunta().createPergunta(pergunta);
    }

    @GetMapping("/findByInstituicaoId/{id}")
    public List<PerguntaModel> getPerguntasByInstituicao(@PathVariable("id") int id){
        List<PerguntaModel> perguntas = perguntaBackendConfiguration.findPergunta().findAllByInstituicaoId(id);
        return perguntas;
    }
}
