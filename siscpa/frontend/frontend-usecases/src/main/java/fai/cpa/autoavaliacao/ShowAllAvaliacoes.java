package fai.cpa.autoavaliacao;

import fai.cpa.entities.AvaliacaoModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowAllAvaliacoes {

    private final RestService<AvaliacaoModel> restService;

    public ShowAllAvaliacoes(RestService<AvaliacaoModel> restService) {
        this.restService = restService;
    }

    public List<AvaliacaoModel> showAllAvaliacoes(){
        final String resource = "/avaliacao/all";
        final List<AvaliacaoModel> avaliacoes = restService.get(resource);
        return avaliacoes;
    }
}
