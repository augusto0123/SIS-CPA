package fai.cpa.autoavaliacao;

import fai.cpa.entities.PerguntaModel;
import fai.cpa.entities.RespostaModel;
import fai.cpa.port.RestService;

public class CreateResposta {

    private final RestService<RespostaModel> restService;

    public CreateResposta(RestService<RespostaModel> restService) {
        this.restService = restService;
    }

    public int createResposta(RespostaModel resposta){
        final String resource = "/resposta/add";
        final int id = restService.post(resource, resposta);
        return id;
    }
}
