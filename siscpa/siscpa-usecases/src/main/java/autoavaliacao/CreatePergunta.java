package autoavaliacao;

import fai.cpa.entities.PerguntaModel;
import port.PerguntaRepository;

public class CreatePergunta {

    private final PerguntaRepository perguntaRepository;

    public CreatePergunta(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public int createPergunta(PerguntaModel perguntaModel){
        if (perguntaModel == null){
            return -1;
        }
        if (perguntaModel.getCategoria().isEmpty()
                || perguntaModel.getDescricao().isEmpty()
                || perguntaModel.getTipo().isEmpty()
                || perguntaModel.getTipoEscala() < 1){
            return -1;
        }
        return perguntaRepository.create(perguntaModel);
    }
}
