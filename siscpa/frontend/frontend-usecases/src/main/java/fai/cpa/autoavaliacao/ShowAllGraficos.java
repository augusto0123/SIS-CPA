package fai.cpa.autoavaliacao;

import fai.cpa.entities.GraficoModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowAllGraficos {

    private final RestService<GraficoModel> restService;

    public ShowAllGraficos(RestService<GraficoModel> restService) {
        this.restService = restService;
    }

    public List<GraficoModel> showObjetivaByAvaliacaoId(final int avaliacaoId) {
        final String resource = "/resposta/findObjetivaByAvaliacaoId/" + avaliacaoId;
        final List<GraficoModel> graficos = restService.get(resource);
        return graficos;
    }
}
