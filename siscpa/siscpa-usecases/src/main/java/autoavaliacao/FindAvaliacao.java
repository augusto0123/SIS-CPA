package autoavaliacao;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.AvaliacaoModel;
import port.AvaliacaoRepository;

import java.util.List;

public class FindAvaliacao {

    private final AvaliacaoRepository avaliacaoRepository;

    public FindAvaliacao(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<AvaliacaoModel> find(){
        final List<AvaliacaoModel> avaliacoes = avaliacaoRepository.findAll();
        if (avaliacoes == null){
            return null;
        }
        return avaliacoes;
    }

    public AvaliacaoModel find(final int id){
        if(id < 0){
            throw new InvalidException();
        }
        AvaliacaoModel avaliacao = avaliacaoRepository.findById(id);
        if (avaliacao == null){
            final String message = "O id (" + id + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return avaliacao;
    }
}
