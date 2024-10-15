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
}
