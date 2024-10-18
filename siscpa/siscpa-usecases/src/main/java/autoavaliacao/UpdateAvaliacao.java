package autoavaliacao;

import fai.cpa.entities.AvaliacaoModel;
import fai.cpa.entities.ReuniaoCpaModel;
import port.AvaliacaoRepository;

public class UpdateAvaliacao {

    private final AvaliacaoRepository avaliacaoRepository;

    public UpdateAvaliacao(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public boolean vincularAvaliacao(final AvaliacaoModel avaliacao) {

        final AvaliacaoModel byId = avaliacaoRepository.findById(avaliacao.getId());
        byId.setEdicaoId(avaliacao.getEdicaoId());

        boolean updateAvaliacao = false;

        try {
            updateAvaliacao = avaliacaoRepository.update(byId);
            return updateAvaliacao;
        } catch (Exception e) {
            return true;
        }
    }
}
