package fai.cpa.autoavaliacao;

import fai.cpa.entities.GraficoModel;
import fai.cpa.entities.GrupoDePerguntasModel;
import fai.cpa.entities.RespostaModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowAllRespostas {

    private final RestService<RespostaModel> restService;

    public ShowAllRespostas(RestService<RespostaModel> restService) {
        this.restService = restService;
    }

    public List<RespostaModel> showAllRespostas(){
        final String resource = "/resposta/all";
        final List<RespostaModel> respostas = restService.get(resource);
        return respostas;
    }

    public List<RespostaModel> showAllRespostasByInstituicaoId(final int id){
        final String resource = "/respostas/findByInstituicaoId/" + id;
        final List<RespostaModel> respostas = restService.get(resource);
        return respostas;
    }

    public List<RespostaModel> showRespostasByAvaliacaoId(final int id){
        final String resource = "/resposta/findByAvaliacaoId/" + id;
        final List<RespostaModel> respostas = restService.get(resource);
        return respostas;
    }
}
