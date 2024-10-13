package fai.cpa.autoavaliacao;

import fai.cpa.entities.AvaliacaoModel;
import fai.cpa.port.RestService;

public class CreateAvaliacao {

    private final RestService<AvaliacaoModel> restService;

    public CreateAvaliacao(RestService<AvaliacaoModel> restService) {
        this.restService = restService;
    }

    public int createAvaliacao(AvaliacaoModel avaliacao){
        final String resource = "/avaliacao/add";
        final int id = restService.post(resource, avaliacao);
        return id;
    }
}
