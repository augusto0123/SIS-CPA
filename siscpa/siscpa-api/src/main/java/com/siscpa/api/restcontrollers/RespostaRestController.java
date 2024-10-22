package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.RespostaBackendConfiguration;
import fai.cpa.entities.GraficoModel;
import fai.cpa.entities.PerguntaModel;
import fai.cpa.entities.RespostaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/resposta")
public class RespostaRestController {

    private final RespostaBackendConfiguration respostaBackendConfiguration = new RespostaBackendConfiguration();

    @GetMapping("/all")
    public List<RespostaModel> getRespostas(){
        List<RespostaModel> respostas = respostaBackendConfiguration.findResposta().find();
        return respostas;
    }

    @PostMapping("/add")
    public int getCreateResposta(@RequestBody RespostaModel resposta){
        return respostaBackendConfiguration.createResposta().createResposta(resposta);
    }

    @GetMapping("/findByInstituicaoId")
    public List<RespostaModel> getRespostasByInstituicaoId(@PathVariable("id") int id){
        List<RespostaModel> respostas = respostaBackendConfiguration.findResposta().findAllByInstituicaoId(id);
        return respostas;
    }

    @GetMapping("/findByAvaliacao/{id}")
    public List<RespostaModel> getRespostasByAvaliacaoId(@PathVariable("id") int id){
        List<RespostaModel> respostas = respostaBackendConfiguration.findResposta().findAllByAvaliacaoId(id);
        return respostas;
    }

    @GetMapping("/findObjetivaByAvaliacaoId/{id}")
    public List<GraficoModel> getRespostasObjetivasByAvaliacaoId(@PathVariable("id") int id) {
        List<GraficoModel> graficos = respostaBackendConfiguration.findResposta().findObjetivaByAvaliacaoId(id);
        return graficos;
    }

    @GetMapping("/findSubjetivaByAvaliacaoId/{id}")
    public List<GraficoModel> getRespostasSubjetivasByAvaliacaoId(@PathVariable("id") int id) {
        List<GraficoModel> graficos = respostaBackendConfiguration.findResposta().findSubjetivaByAvaliacaoId(id);
        return graficos;
    }
}
