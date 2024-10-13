package fai.cpa.autoavaliacao;

import fai.cpa.entities.GrupoDePerguntasModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowAllGrupos {

    private final RestService<GrupoDePerguntasModel> restService;

    public ShowAllGrupos(RestService<GrupoDePerguntasModel> restService) {
        this.restService = restService;
    }

    public List<GrupoDePerguntasModel> showAllGrupos(){
        final String resource = "/grupo/all";
        final List<GrupoDePerguntasModel> grupos = restService.get(resource);
        return grupos;
    }
}
