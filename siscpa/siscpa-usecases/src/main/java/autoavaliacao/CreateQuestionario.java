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
                || questionarioModel.getCategoria().isEmpty()){
            return -1;
        }
        int id = 0;

        try {
            id = questionarioRepository.create(questionarioModel);
            questionarioModel.setId(id);
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return id;
    }
}
