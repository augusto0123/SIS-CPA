package autoavaliacao;

import fai.cpa.entities.QuestionarioModel;
import port.QuestionarioRepository;

public class UpdateQuestionario {

    private final QuestionarioRepository questionarioRepository;

    public UpdateQuestionario(QuestionarioRepository questionarioRepository) {
        this.questionarioRepository = questionarioRepository;
    }

    public boolean vincularQuestionario(final QuestionarioModel questionario){

        final QuestionarioModel byId = questionarioRepository.findById(questionario.getId());
        byId.setAvaliacaoId(questionario.getAvaliacaoId());

        boolean updateQuestionario = false;

        try {
            updateQuestionario = questionarioRepository.update(byId);
            return updateQuestionario;
        } catch (Exception e){
            return true;
        }
    }
}
