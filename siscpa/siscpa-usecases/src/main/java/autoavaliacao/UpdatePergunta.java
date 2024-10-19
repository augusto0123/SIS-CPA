package autoavaliacao;

import fai.cpa.entities.PerguntaModel;
import port.PerguntaRepository;

public class UpdatePergunta {

    private final PerguntaRepository perguntaRepository;

    public UpdatePergunta(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public boolean vincularPergunta(final PerguntaModel pergunta){

        final PerguntaModel byId = perguntaRepository.findById(pergunta.getId());
        byId.setGrupoId(pergunta.getGrupoId());

        boolean updatePergunta = false;

        try {
            updatePergunta = perguntaRepository.update(byId);
            return updatePergunta;
        }catch (Exception e){
            return true;
        }
    }
}
