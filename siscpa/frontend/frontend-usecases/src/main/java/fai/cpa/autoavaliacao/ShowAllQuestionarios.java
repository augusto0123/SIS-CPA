package fai.cpa.autoavaliacao;

import fai.cpa.entities.QuestionarioModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowAllQuestionarios {

    private final RestService<QuestionarioModel> restService;

    public ShowAllQuestionarios(RestService<QuestionarioModel> restService) {
        this.restService = restService;
    }

    public List<QuestionarioModel> showAllQuestionarios(){
        final String resource = "/questionario/all";
        final List<QuestionarioModel> questionarios = restService.get(resource);
        return questionarios;
    }

    public List<QuestionarioModel> shollAllQuestionariosByInstituicaoId(final int id){
        final String resource = "/questionario/findByInstituicaoId/" + id;
        final List<QuestionarioModel> questionarios = restService.get(resource);
        return questionarios;
    }

    public List<QuestionarioModel> showAllQuestionariosByAvaliacaoId(final int id){
        final String resource = "/questionario/findByAvaliacaoId/" + id;
        final List<QuestionarioModel> questionarios = restService.get(resource);
        return questionarios;
    }
}
