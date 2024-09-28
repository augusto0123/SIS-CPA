package autoavaliacao;

import fai.cpa.entities.AvaliacaoModel;
import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import port.AvaliacaoRepository;

public class CreateAvaliacao {

    private final AvaliacaoRepository avaliacaoRepository;

    public CreateAvaliacao(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }
    public int createAvaliacao(final AvaliacaoModel avaliacaoModel){
        if (avaliacaoModel == null){
            return -1;
        }
        if(avaliacaoModel.getData_inicio() == null
                || avaliacaoModel.getData_fim() == null
                || avaliacaoModel.getSituacao().isEmpty()
                || avaliacaoModel.getDescricao().isEmpty()
                || avaliacaoModel.getObservacao().isEmpty()){
            return -1;
        }
        int id = 0;
        try {
            id = avaliacaoRepository.create(avaliacaoModel);
            avaliacaoModel.setId(id);
        } catch (Exception e) {
            return -1;
        }
        return id;
    }
}
