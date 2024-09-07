package instituicao;

import exception.InvalidException;
import port.InstituicaoRepository;
import fai.cpa.entities.InstituicaoModel;

public class DeleteInstituicao {

    private final InstituicaoRepository instituicaoRepository;

    public DeleteInstituicao(InstituicaoRepository instituicaoRepository) {
        this.instituicaoRepository = instituicaoRepository;
    }

    public boolean delete(final int id){
        if(id <= 0){
            return false;
        }
        boolean response = instituicaoRepository.deleteById(id);
        return response;
    }
}
