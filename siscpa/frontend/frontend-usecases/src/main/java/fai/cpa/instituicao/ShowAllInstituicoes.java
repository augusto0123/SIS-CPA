package fai.cpa.instituicao;

import fai.cpa.entities.InstituicaoModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowAllInstituicoes {

    private final RestService<InstituicaoModel> restService;

    public ShowAllInstituicoes(RestService<InstituicaoModel> restService) {
        this.restService = restService;
    }

    public List<InstituicaoModel> showAllInstituicoes(){
        final String resource = "/instituicao/all";
        final List<InstituicaoModel> instituicaoModels = restService.get(resource);
        return instituicaoModels;
    }

    public InstituicaoModel findById(int id) {
        final String resource = "/instituicao/findById/" + id;
        InstituicaoModel byId = restService.getById(resource, InstituicaoModel.class);
        return byId;
    }
}
