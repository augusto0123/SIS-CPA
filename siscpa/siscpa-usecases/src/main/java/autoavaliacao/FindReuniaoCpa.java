package autoavaliacao;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.ReuniaoCpaModel;
import port.ReuniaoCpaRepository;

public class FindReuniaoCpa {

    private final ReuniaoCpaRepository reuniaoCpaRepository;

    public FindReuniaoCpa(ReuniaoCpaRepository reuniaoCpaRepository) {
        this.reuniaoCpaRepository = reuniaoCpaRepository;
    }

    public ReuniaoCpaModel find(final int id){
        if (id < 0){
            throw new InvalidException();
        }
        final ReuniaoCpaModel reuniaoCpaModel = reuniaoCpaRepository.findById(id);
        if (reuniaoCpaModel == null){
            final String message = "O id " + id + " não foi encontrado";
            throw new NotFoundException(message);
        }
        return reuniaoCpaModel;
    }
}
