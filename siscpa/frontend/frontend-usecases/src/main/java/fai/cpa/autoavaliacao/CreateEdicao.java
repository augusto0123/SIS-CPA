package fai.cpa.autoavaliacao;

import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import fai.cpa.port.RestService;

public class CreateEdicao {

    private final RestService<EdicaoDeAutoAvaliacaoModel> restService;

    public CreateEdicao(RestService<EdicaoDeAutoAvaliacaoModel> restService) {
        this.restService = restService;
    }

    public int createEdicao(EdicaoDeAutoAvaliacaoModel edicao){
        final String resource = "/edicoes/add";
        final int id = restService.post(resource, edicao);
        return id;
    }
}
