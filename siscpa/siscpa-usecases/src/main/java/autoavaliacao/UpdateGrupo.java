package autoavaliacao;

import fai.cpa.entities.GrupoDePerguntasModel;
import port.GrupoDePerguntasRepository;

public class UpdateGrupo {

    private final GrupoDePerguntasRepository grupoDePerguntasRepository;

    public UpdateGrupo(GrupoDePerguntasRepository grupoDePerguntasRepository) {
        this.grupoDePerguntasRepository = grupoDePerguntasRepository;
    }

    public boolean vincularGrupo(final GrupoDePerguntasModel grupo){

        final GrupoDePerguntasModel byId = grupoDePerguntasRepository.findById(grupo.getId());
        byId.setQuestionarioId(grupo.getQuestionarioId());

        boolean updateGrupo = false;

        try {
            updateGrupo = grupoDePerguntasRepository.update(byId);
            return updateGrupo;
        }catch (Exception e){
            return true;
        }
    }
}
