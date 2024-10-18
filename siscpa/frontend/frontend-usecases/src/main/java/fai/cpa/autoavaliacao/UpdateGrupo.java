package fai.cpa.autoavaliacao;

import fai.cpa.entities.GrupoDePerguntasModel;
import fai.cpa.port.RestService;

public class UpdateGrupo {

    private final RestService<GrupoDePerguntasModel> restService;
    public UpdateGrupo(RestService<GrupoDePerguntasModel> restService) {
        this.restService = restService;
    }

    public boolean vincularGrupo(GrupoDePerguntasModel grupo){
        final String resource = "/grupo/vincular-grupo";
        boolean resultado = restService.put(resource, grupo);

        return resultado;
    }
}
