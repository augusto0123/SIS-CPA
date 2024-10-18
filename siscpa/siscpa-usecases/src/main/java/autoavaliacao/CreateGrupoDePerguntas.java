package autoavaliacao;

import fai.cpa.entities.GrupoDePerguntasModel;
import port.GrupoDePerguntasRepository;
import port.InstituicaoRepository;

public class CreateGrupoDePerguntas {
    private final GrupoDePerguntasRepository grupoDePerguntasRepository;

    private final InstituicaoRepository instituicaoRepository;

    public CreateGrupoDePerguntas(GrupoDePerguntasRepository grupoDePerguntasRepository, InstituicaoRepository instituicaoRepository) {
        this.grupoDePerguntasRepository = grupoDePerguntasRepository;
        this.instituicaoRepository = instituicaoRepository;
    }

    public int createGrupoDePerguntas(final GrupoDePerguntasModel grupoDePerguntasModel){
        if(grupoDePerguntasModel == null){
            return -1;
        }
        if (grupoDePerguntasModel.getDescricao().isEmpty() || grupoDePerguntasModel.getTipo().isEmpty()){
            return -1;
        }
        int id = 0;

        try {
            id = grupoDePerguntasRepository.create(grupoDePerguntasModel);
            grupoDePerguntasModel.setId(id);
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return id;
    }
}
