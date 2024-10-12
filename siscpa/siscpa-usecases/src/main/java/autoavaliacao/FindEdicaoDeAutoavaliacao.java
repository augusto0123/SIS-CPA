package autoavaliacao;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import fai.cpa.entities.InstituicaoModel;
import port.EdicaoDeAutoavaliacaoRepository;

import java.util.List;

public class FindEdicaoDeAutoavaliacao {

    private final EdicaoDeAutoavaliacaoRepository edicaoDeAutoavaliacaoRepository;

    public FindEdicaoDeAutoavaliacao(EdicaoDeAutoavaliacaoRepository edicaoDeAutoavaliacaoRepository) {
        this.edicaoDeAutoavaliacaoRepository = edicaoDeAutoavaliacaoRepository;
    }

    public List<EdicaoDeAutoAvaliacaoModel> find(){
        final List<EdicaoDeAutoAvaliacaoModel> edicoes = edicaoDeAutoavaliacaoRepository.findAll();
        if (edicoes == null){
            return null;
        }
        return edicoes;
    }

    public EdicaoDeAutoAvaliacaoModel find(final int id){
        if(id < 0){
            throw new InvalidException();
        }
        EdicaoDeAutoAvaliacaoModel edicao =edicaoDeAutoavaliacaoRepository.findById(id);
        if (edicao == null){
            final String message = "O id (" + id + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return edicao;
    }
    
}
