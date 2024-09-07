package membroCpa;

import fai.cpa.entities.MembroCpaModel;
import port.MembroCpaRepository;

public class UpdateMembroCpa {

    private final MembroCpaRepository membroCpaRepository;

    public UpdateMembroCpa(MembroCpaRepository membroCpaRepository) {
        this.membroCpaRepository = membroCpaRepository;
    }

    public boolean update(final MembroCpaModel membroCpaModel){
        final MembroCpaModel byId   = membroCpaRepository.findById(membroCpaModel.getId());
        byId.setCargo(membroCpaModel.getCargo());

        boolean updateMembroCpa = false;
        try {
            updateMembroCpa = membroCpaRepository.update(byId);
            return updateMembroCpa;
        } catch (Exception e){
            return true;
        }
    }
}
