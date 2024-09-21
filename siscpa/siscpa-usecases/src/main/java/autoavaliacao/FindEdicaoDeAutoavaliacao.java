package autoavaliacao;

import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
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
    
}
