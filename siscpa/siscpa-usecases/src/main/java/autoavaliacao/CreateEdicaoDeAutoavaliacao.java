package autoavaliacao;

import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import port.EdicaoDeAutoavaliacaoRepository;
import port.InstituicaoRepository;

public class CreateEdicaoDeAutoavaliacao {

    private final EdicaoDeAutoavaliacaoRepository edicaoDeAutoavaliacaoRepository;

    private final InstituicaoRepository instituicaoRepository;

    public CreateEdicaoDeAutoavaliacao(EdicaoDeAutoavaliacaoRepository edicaoDeAutoavaliacaoRepository, InstituicaoRepository instituicaoRepository) {
        this.edicaoDeAutoavaliacaoRepository = edicaoDeAutoavaliacaoRepository;
        this.instituicaoRepository = instituicaoRepository;
    }

    public int createEdicaoDeAutoavaliacao(final EdicaoDeAutoAvaliacaoModel edicaoDeAutoAvaliacaoModel){
        if (edicaoDeAutoAvaliacaoModel == null){
            return -1;
        }
        if(edicaoDeAutoAvaliacaoModel.getDescricao().isEmpty()
                || edicaoDeAutoAvaliacaoModel.getEdicao() < 1
                || edicaoDeAutoAvaliacaoModel.getAnoDaAvaliacao().isEmpty()
                || edicaoDeAutoAvaliacaoModel.getDataInicio() == null
                || edicaoDeAutoAvaliacaoModel.getDataFim() == null
                || edicaoDeAutoAvaliacaoModel.getSituacao().isEmpty()){
            return -1;
        }
        int id = 0;
        try {
            edicaoDeAutoAvaliacaoModel.setInstituicaoId(instituicaoRepository.findById(edicaoDeAutoAvaliacaoModel.getInstituicaoId()).getId());
            id = edicaoDeAutoavaliacaoRepository.create(edicaoDeAutoAvaliacaoModel);
            edicaoDeAutoAvaliacaoModel.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return id;
    }
}
