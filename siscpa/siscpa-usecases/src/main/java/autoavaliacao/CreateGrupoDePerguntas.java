package autoavaliacao;

import fai.cpa.entities.GrupoDePerguntasModel;
import port.GrupoDePerguntasRepository;

public class CreateGrupoDePerguntas {
    private final GrupoDePerguntasRepository grupoDePerguntasRepository;

    public CreateGrupoDePerguntas(GrupoDePerguntasRepository grupoDePerguntasRepository) {
        this.grupoDePerguntasRepository = grupoDePerguntasRepository;
    }

    public int createGrupoDePerguntas(final GrupoDePerguntasModel grupoDePerguntasModel){
        if(grupoDePerguntasModel == null){
            return -1;
        }
        if (grupoDePerguntasModel.getDescricao().isEmpty() || grupoDePerguntasModel.getTipo().isEmpty()){
            return -1;
        }
        return grupoDePerguntasRepository.create(grupoDePerguntasModel);
    }
}
