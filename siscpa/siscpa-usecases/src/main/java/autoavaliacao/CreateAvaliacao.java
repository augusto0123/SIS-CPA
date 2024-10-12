package autoavaliacao;

import fai.cpa.entities.AvaliacaoModel;
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
        if(avaliacaoModel.getDescricao().isEmpty()
                || avaliacaoModel.getTema().isEmpty()){
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
