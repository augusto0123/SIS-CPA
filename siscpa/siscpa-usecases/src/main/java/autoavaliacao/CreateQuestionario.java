package autoavaliacao;

import fai.cpa.entities.QuestionarioModel;
import port.QuestionarioRepository;

public class CreateQuestionario {

    private final QuestionarioRepository questionarioRepository;

    public CreateQuestionario(QuestionarioRepository questionarioRepository) {
        this.questionarioRepository = questionarioRepository;
    }

    public int createQuestionario(final QuestionarioModel questionarioModel){
        if(questionarioModel == null){
            return -1;
        }
        if (questionarioModel.getDescricao().isEmpty()
                || questionarioModel.getTipo().isEmpty()){
            return -1;
        }
        return questionarioRepository.create(questionarioModel);
    }
}
