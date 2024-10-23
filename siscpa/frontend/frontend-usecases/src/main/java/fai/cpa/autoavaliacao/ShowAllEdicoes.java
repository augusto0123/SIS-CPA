package fai.cpa.autoavaliacao;

import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import fai.cpa.entities.ReuniaoCpaModel;
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

    public List<EdicaoDeAutoAvaliacaoModel> showAllEdicoesByInstituicaoId(final int id){
        final String resource = "/edicoes/findByInstituicaoId/" + id;
        final List<EdicaoDeAutoAvaliacaoModel> edicaoDeAutoAvaliacaoModelList = restService.get(resource);
        return edicaoDeAutoAvaliacaoModelList;
    }

    public EdicaoDeAutoAvaliacaoModel showEdicaoById(final int id) {
        final String resource = "/edicoes/findById/" + id;
        final EdicaoDeAutoAvaliacaoModel edicao = restService.getById(resource, EdicaoDeAutoAvaliacaoModel.class);
        return edicao;
    }
}
