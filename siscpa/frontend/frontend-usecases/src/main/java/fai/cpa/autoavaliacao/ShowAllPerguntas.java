package fai.cpa.autoavaliacao;

import fai.cpa.entities.PerguntaModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowAllPerguntas {

    private final RestService<PerguntaModel> restService;

    public ShowAllPerguntas(RestService<PerguntaModel> restService) {
        this.restService = restService;
    }

    public List<PerguntaModel> showAllPerguntas(){
        final String resource = "/pergunta/all";
        final List<PerguntaModel> perguntas = restService.get(resource);
        return perguntas;
    }

    public List<PerguntaModel> showAllPerguntasByInstituicao(final int id){
        final String resource = "/pergunta/findByInstituicaoId/" + id;
        final List<PerguntaModel> perguntas = restService.get(resource);
        return perguntas;
    }
}
