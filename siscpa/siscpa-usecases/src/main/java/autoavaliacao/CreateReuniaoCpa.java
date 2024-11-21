package autoavaliacao;

import fai.cpa.entities.ReuniaoCpaModel;
import port.ReuniaoCpaRepository;

public class CreateReuniaoCpa {

    private final ReuniaoCpaRepository reuniaoCpaRepository;

    public CreateReuniaoCpa(ReuniaoCpaRepository reuniaoCpaRepository) {
        this.reuniaoCpaRepository = reuniaoCpaRepository;
    }

    public int createReuniaoCpa(final ReuniaoCpaModel reuniaoCpaModel){
        if(reuniaoCpaModel == null){
            return -1;
        }
        if(reuniaoCpaModel.getDataReuniao() == null
                || reuniaoCpaModel.getHorario() == null
                || reuniaoCpaModel.getPauta().isEmpty()){
            return -1;
        }
        int id = 0;
        try {
            id = reuniaoCpaRepository.create(reuniaoCpaModel);
            reuniaoCpaModel.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return id;
    }

}
