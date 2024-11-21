package fai.cpa.instituicao;

import fai.cpa.entities.InstituicaoModel;
import fai.cpa.port.RestService;

public class UpdateFoto {

    private final RestService<InstituicaoModel> restService;

    public UpdateFoto(RestService<InstituicaoModel> restService) {
        this.restService = restService;
    }

    public boolean updateFoto(final int id, final String foto){
        final String resource = "/instituicao/updateFoto/" + id;
        InstituicaoModel instituicaoModel = new InstituicaoModel();
        instituicaoModel.setFoto(foto);
        boolean resultado = restService.put(resource, instituicaoModel);
        return resultado;
    }
}
