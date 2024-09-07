package membroCpa;

import exception.InvalidException;
import fai.cpa.entities.MembroCpaModel;
import port.MembroCpaRepository;

public class CreateMembroCpa {

    private final MembroCpaRepository membroCpaRepository;

    public CreateMembroCpa(MembroCpaRepository membroCpaRepository) {
        this.membroCpaRepository = membroCpaRepository;
    }

    public int create(MembroCpaModel membroCpaModel) {
        if (membroCpaModel == null){
            return -1;
        }
        if(membroCpaModel.getCargo().isEmpty()){
            return -1;
        }
        return membroCpaRepository.create(membroCpaModel);
    }
}
