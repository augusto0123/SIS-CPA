package autoavaliacao;

import fai.cpa.entities.AvaliacaoModel;
import port.AvaliacaoRepository;
import port.InstituicaoRepository;

public class CreateAvaliacao {

    private final AvaliacaoRepository avaliacaoRepository;
    private final InstituicaoRepository instituicaoRepository;

    public CreateAvaliacao(AvaliacaoRepository avaliacaoRepository, InstituicaoRepository instituicaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.instituicaoRepository = instituicaoRepository;
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
            e.printStackTrace();
            return -1;
        }
        return id;
    }
}
