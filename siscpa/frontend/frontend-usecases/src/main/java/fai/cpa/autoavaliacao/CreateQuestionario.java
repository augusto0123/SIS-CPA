package fai.cpa.autoavaliacao;

import fai.cpa.entities.QuestionarioModel;
import fai.cpa.port.RestService;

public class CreateQuestionario {

    private final RestService<QuestionarioModel> restService;

    public CreateQuestionario(RestService<QuestionarioModel> restService) {
        this.restService = restService;
    }

    public int createQuestionario(QuestionarioModel questionario){
        final String resource = "/questionario/add";
        final int id = restService.post(resource, questionario);
        return id;
    }
}
