package fai.cpa.autoavaliacao;

import fai.cpa.entities.QuestionarioModel;
import fai.cpa.port.RestService;

public class UpdateQuestionario {

    private final RestService<QuestionarioModel> restService;


    public UpdateQuestionario(RestService<QuestionarioModel> restService) {
        this.restService = restService;
    }

    public boolean vincularQuestionario(QuestionarioModel questionario){
        final String resource = "/questionario/vincular-questionario";
        boolean resultado = restService.put(resource, questionario);

        return resultado;
    }
}
