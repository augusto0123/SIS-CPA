package autoavaliacao;

import fai.cpa.entities.PerguntaModel;
import port.PerguntaRepository;

public class CreatePergunta {

    private final PerguntaRepository perguntaRepository;

    public CreatePergunta(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public int createPergunta(final PerguntaModel perguntaModel){
        if (perguntaModel == null){
            return -1;
        }
        if (perguntaModel.getDescricao().isEmpty()
                || perguntaModel.getTipo().isEmpty()){
            return -1;
        }
        int id = 0;

        try {
            id = perguntaRepository.create(perguntaModel);
            perguntaModel.setId(id);
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return id;
    }
}
