package autoavaliacao;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.ReuniaoCpaModel;
import port.ReuniaoCpaRepository;

import java.util.List;

public class FindReuniaoCpa {

    private final ReuniaoCpaRepository reuniaoCpaRepository;

    public FindReuniaoCpa(ReuniaoCpaRepository reuniaoCpaRepository) {
        this.reuniaoCpaRepository = reuniaoCpaRepository;
    }

    public List<ReuniaoCpaModel> find(){
        final List<ReuniaoCpaModel> reunioes = reuniaoCpaRepository.findAll();
        if (reunioes == null){
            return null;
        }
        return reunioes;
    }

    public ReuniaoCpaModel find(final int id){
        if (id < 0){
            throw new InvalidException();
        }
        ReuniaoCpaModel reuniaoCpaModel = reuniaoCpaRepository.findById(id);
        if (reuniaoCpaModel == null){
            final String message = "O id " + id + " não foi encontrado";
            throw new NotFoundException(message);
        }
        return reuniaoCpaModel;
    }

    public ReuniaoCpaModel findLastReuniao() {
        List<ReuniaoCpaModel> reunioes = reuniaoCpaRepository.findAll();

        if (reunioes == null || reunioes.isEmpty()) {
            return null;
        }

        return reunioes.get(reunioes.size() - 1);
    }

    public List<ReuniaoCpaModel> findByInstituicaoId(int instituicaoId){
        if (instituicaoId < 0){
            throw new InvalidException();
        }

        List<ReuniaoCpaModel> reunioesInstituicao = reuniaoCpaRepository.findAllByInstituicaoId(instituicaoId);
        if (reunioesInstituicao == null || reunioesInstituicao.isEmpty()) {
            final String message = "Nenhuma reunião encontrada para o id da instituição " + instituicaoId;
            throw new NotFoundException(message);
        }
        return reunioesInstituicao;
    }
}
