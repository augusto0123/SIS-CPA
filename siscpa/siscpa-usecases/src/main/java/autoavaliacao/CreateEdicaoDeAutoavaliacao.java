package autoavaliacao;

import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import port.EdicaoDeAutoavaliacaoRepository;

public class CreateEdicaoDeAutoavaliacao {

    private final EdicaoDeAutoavaliacaoRepository edicaoDeAutoavaliacaoRepository;

    public CreateEdicaoDeAutoavaliacao(EdicaoDeAutoavaliacaoRepository edicaoDeAutoavaliacaoRepository) {
        this.edicaoDeAutoavaliacaoRepository = edicaoDeAutoavaliacaoRepository;
    }

    public int createEdicaoDeAutoavaliacao(final EdicaoDeAutoAvaliacaoModel edicaoDeAutoAvaliacaoModel){
        if (edicaoDeAutoAvaliacaoModel == null){
            return -1;
        }
        if(edicaoDeAutoAvaliacaoModel.getDescricao().isEmpty()
                || edicaoDeAutoAvaliacaoModel.getEdicao() < 1
                || edicaoDeAutoAvaliacaoModel.getAnoDaAvaliacao().isEmpty()
                || edicaoDeAutoAvaliacaoModel.getDataFim() == null
                || edicaoDeAutoAvaliacaoModel.getDataInicio() == null){
            return -1;
        }
        return edicaoDeAutoavaliacaoRepository.create(edicaoDeAutoAvaliacaoModel);
    }
}
