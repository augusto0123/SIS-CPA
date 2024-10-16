package fai.cpa.autoavaliacao;

import fai.cpa.entities.PerguntaModel;
import fai.cpa.port.RestService;

public class CreatePergunta {

    private final RestService<PerguntaModel> restService;

    public CreatePergunta(RestService<PerguntaModel> restService) {
        this.restService = restService;
    }

    public int createPergunta(PerguntaModel pergunta){
        final String resource = "/pergunta/add";
        final int id = restService.post(resource, pergunta);
        return id;
    }
}
