package membroCpa;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.InstituicaoModel;
import fai.cpa.entities.MembroCpaModel;
import port.InstituicaoRepository;
import port.MembroCpaRepository;

import java.util.List;

public class FindMembroCpa {

    private final MembroCpaRepository membroCpaRepository;

    public FindMembroCpa(MembroCpaRepository membroCpaRepository) {
        this.membroCpaRepository = membroCpaRepository;
    }

    public List<MembroCpaModel> find(){
        final List<MembroCpaModel> membrosCpa = membroCpaRepository.findAll();
        if (membrosCpa == null){
            return null;
        }
        return membrosCpa;
    }
    public MembroCpaModel find(final int id){
        if(id < 0){
            throw new InvalidException();
        }
        final MembroCpaModel membrosCpa =membroCpaRepository.findById(id);
        if (membrosCpa == null){
            final String message = "O id (" + id + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return membrosCpa;
    }
}
