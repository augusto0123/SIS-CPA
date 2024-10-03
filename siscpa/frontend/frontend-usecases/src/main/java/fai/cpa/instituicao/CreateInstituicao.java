package fai.cpa.instituicao;

import fai.cpa.entities.InstituicaoModel;
import fai.cpa.port.RestService;

public class CreateInstituicao {

    private final RestService<InstituicaoModel> restService;

    public CreateInstituicao(RestService<InstituicaoModel> restService) {
        this.restService = restService;
    }

    public int createInstituicao(InstituicaoModel instituicao){
        final String resource = "/instituicao/add";
        final int id = restService.post(resource, instituicao);
        return id;
    }

}
