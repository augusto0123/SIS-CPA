package instituicao;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.InstituicaoModel;
import port.InstituicaoRepository;

import java.util.List;

public class FindInstituicao {

    private final InstituicaoRepository instituicaoRepository;


    public FindInstituicao(InstituicaoRepository instituicaoRepository) {
        this.instituicaoRepository = instituicaoRepository;
    }

    public List<InstituicaoModel> find(){
        final List<InstituicaoModel> instituicoes = instituicaoRepository.findAll();
        if (instituicoes == null){
            return null;
        }
        return instituicoes;
    }
    public InstituicaoModel find(final int id){
        if(id < 0){
            throw new InvalidException();
        }
        final InstituicaoModel instituicao =instituicaoRepository.findById(id);
        if (instituicao == null){
            final String message = "O id (" + id + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return instituicao;
    }
}
