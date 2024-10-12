package fai.cpa.autoavaliacao;

import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowAllEdicoes {

    private final RestService<EdicaoDeAutoAvaliacaoModel> restService;


    public ShowAllEdicoes(RestService<EdicaoDeAutoAvaliacaoModel> restService) {
        this.restService = restService;
    }

    public List<EdicaoDeAutoAvaliacaoModel> showAllEdicoes(){
        final String resource = "/edicoes/all";
        final List<EdicaoDeAutoAvaliacaoModel> edicoes = restService.get(resource);
        return edicoes;
    }
}
