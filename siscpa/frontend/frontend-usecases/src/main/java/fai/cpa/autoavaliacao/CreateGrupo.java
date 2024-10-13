package fai.cpa.autoavaliacao;

import fai.cpa.entities.GrupoDePerguntasModel;
import fai.cpa.port.RestService;

public class CreateGrupo {

    private final RestService<GrupoDePerguntasModel> restService;

    public CreateGrupo(RestService<GrupoDePerguntasModel> restService) {
        this.restService = restService;
    }

    public int createGrupo(GrupoDePerguntasModel grupo){
        final String resource = "/grupo/add";
        final int id = restService.post(resource, grupo);
        return id;
    }
}
