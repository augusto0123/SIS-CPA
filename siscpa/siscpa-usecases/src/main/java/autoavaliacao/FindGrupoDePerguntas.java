package autoavaliacao;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.GrupoDePerguntasModel;
import port.GrupoDePerguntasRepository;

import java.util.List;

public class FindGrupoDePerguntas {

    private final GrupoDePerguntasRepository grupoDePerguntasRepository;

    public FindGrupoDePerguntas(GrupoDePerguntasRepository grupoDePerguntasRepository) {
        this.grupoDePerguntasRepository = grupoDePerguntasRepository;
    }

    public List<GrupoDePerguntasModel> find(){
        final List<GrupoDePerguntasModel> grupos = grupoDePerguntasRepository.findAll();
        if (grupos == null){
            return null;
        }
        return grupos;
    }

    public GrupoDePerguntasModel find(final int id){
        if(id < 0){
            throw new InvalidException();
        }

        GrupoDePerguntasModel grupo = grupoDePerguntasRepository.findById(id);
        if (grupo == null){
            final String message = "O id (" + id + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return grupo;
    }

    public List<GrupoDePerguntasModel> findAllByInstituicaoId(final int instituicaoId){
        if (instituicaoId <= 0){
            throw new InvalidException();
        }
        List<GrupoDePerguntasModel> grupos = grupoDePerguntasRepository.findAllByInstituicaoId(instituicaoId);
        if (grupos == null){
            final String message = "O id (" + instituicaoId + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return grupos;
    }
}
