package fai.cpa.autoavaliacao;

import fai.cpa.entities.PerguntaModel;
import fai.cpa.port.RestService;

public class UpdatePergunta {

    private final RestService<PerguntaModel> restService;

    public UpdatePergunta(RestService<PerguntaModel> restService) {
        this.restService = restService;
    }

    public boolean vincularPergunta(PerguntaModel pergunta){
        final String resource = "/pergunta/vincular-pergunta";
        boolean resultado = restService.put(resource, pergunta);
        return resultado;
    }
}
