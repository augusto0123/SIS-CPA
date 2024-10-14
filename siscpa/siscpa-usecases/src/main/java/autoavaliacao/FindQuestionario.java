package autoavaliacao;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.QuestionarioModel;
import port.QuestionarioRepository;

import java.util.List;

public class FindQuestionario {

    private final QuestionarioRepository questionarioRepository;

    public FindQuestionario(QuestionarioRepository questionarioRepository) {
        this.questionarioRepository = questionarioRepository;
    }

    public List<QuestionarioModel> find(){
        final List<QuestionarioModel> questionarios = questionarioRepository.findAll();
        if (questionarios == null){
            return null;
        }
        return questionarios;
    }

    public QuestionarioModel find(final int id){
        if (id < 0){
            throw new InvalidException();
        }
        QuestionarioModel questionario = questionarioRepository.findById(id);
        if (questionario == null){
            final String message = "O id (" + id + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return questionario;
    }
}
