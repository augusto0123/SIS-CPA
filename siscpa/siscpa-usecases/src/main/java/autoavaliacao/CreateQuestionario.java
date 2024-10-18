package autoavaliacao;

import fai.cpa.entities.QuestionarioModel;
import port.InstituicaoRepository;
import port.QuestionarioRepository;

public class CreateQuestionario {

    private final QuestionarioRepository questionarioRepository;

    private final InstituicaoRepository instituicaoRepository;

    public CreateQuestionario(QuestionarioRepository questionarioRepository, InstituicaoRepository instituicaoRepository) {
        this.questionarioRepository = questionarioRepository;
        this.instituicaoRepository = instituicaoRepository;
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
