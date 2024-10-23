package autoavaliacao;

import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import fai.cpa.entities.GrupoDePerguntasModel;
import port.EdicaoDeAutoavaliacaoRepository;

public class UpdateEdicao {

    private final EdicaoDeAutoavaliacaoRepository edicaoDeAutoavaliacaoRepository;

    public UpdateEdicao(EdicaoDeAutoavaliacaoRepository edicaoDeAutoavaliacaoRepository) {
        this.edicaoDeAutoavaliacaoRepository = edicaoDeAutoavaliacaoRepository;
    }

    public boolean atualizarEdicao(final EdicaoDeAutoAvaliacaoModel edicao){

        final EdicaoDeAutoAvaliacaoModel byId = edicaoDeAutoavaliacaoRepository.findById(edicao.getId());
        byId.setSituacao(edicao.getSituacao());

        boolean updateEdicao = false;

        try {
            updateEdicao = edicaoDeAutoavaliacaoRepository.update(byId);
            return updateEdicao;
        }catch (Exception e){
            return true;
        }
    }
}
