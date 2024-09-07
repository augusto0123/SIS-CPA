package membroCpa;

import port.InstituicaoRepository;
import port.MembroCpaRepository;

public class DeleteMembroCpa {

    private final MembroCpaRepository membroCpaRepository;

    public DeleteMembroCpa(MembroCpaRepository membroCpaRepository) {
        this.membroCpaRepository = membroCpaRepository;
    }

    public boolean delete(final int id){
        if(id <= 0){
            return false;
        }
        boolean response = membroCpaRepository.deleteById(id);
        return response;
    }
}
