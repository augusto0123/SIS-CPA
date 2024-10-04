package fai.cpa.avaliacao;

import fai.cpa.entities.ReuniaoCpaModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowAllReunioes {

    private final RestService<ReuniaoCpaModel> restService;

    public ShowAllReunioes(RestService<ReuniaoCpaModel> restService) {
        this.restService = restService;
    }

    public List<ReuniaoCpaModel> showAllReunioes(){
        final String resource = "/reuniao/all";
        final List<ReuniaoCpaModel> reuniaoCpaModels = restService.get(resource);
        return reuniaoCpaModels;
    }

}
