package autoavaliacao;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.InstituicaoModel;
import fai.cpa.entities.PerguntaModel;
import fai.cpa.entities.ReuniaoCpaModel;
import port.PerguntaRepository;

import java.util.List;

public class FindPergunta {

    private final PerguntaRepository perguntaRepository;

    public FindPergunta(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public List<PerguntaModel> find(){
        final List<PerguntaModel> perguntas = perguntaRepository.findAll();
        if (perguntas == null){
            return null;
        }
        return perguntas;
    }

    public PerguntaModel find(final int id){
        if (id < 0){
            throw new InvalidException();
        }
        final PerguntaModel perguntaModel = perguntaRepository.findById(id);
        if (perguntaModel == null){
            final String message = "O id " + id + " não foi encontrado";
            throw new NotFoundException(message);
        }
        return perguntaModel;
    }

    public List<PerguntaModel> findAllByInstituicaoId(final int instituicaoId){
        if (instituicaoId <= 0){
            throw new InvalidException();
        }
        List<PerguntaModel> perguntas = perguntaRepository.findAllByInstituicaoId(instituicaoId);
        if (perguntas == null){
            final String message = "O id (" + instituicaoId + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return perguntas;
    }
}
