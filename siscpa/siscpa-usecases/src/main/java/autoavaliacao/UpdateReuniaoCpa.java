package autoavaliacao;

import fai.cpa.entities.ReuniaoCpaModel;
import port.ReuniaoCpaRepository;

public class UpdateReuniaoCpa {

    private final ReuniaoCpaRepository reuniaoCpaRepository;

    public UpdateReuniaoCpa(ReuniaoCpaRepository reuniaoCpaRepository) {
        this.reuniaoCpaRepository = reuniaoCpaRepository;
    }

    public boolean update(final ReuniaoCpaModel reuniaoCpaModel){

        final ReuniaoCpaModel byId = reuniaoCpaRepository.findById(reuniaoCpaModel.getId());
        byId.setDataReuniao(reuniaoCpaModel.getDataReuniao());
        byId.setHorario(reuniaoCpaModel.getHorario());
        byId.setPauta(reuniaoCpaModel.getPauta());

        boolean updateReuniao = false;
        try {
            updateReuniao = reuniaoCpaRepository.update(byId);
            return updateReuniao;
        } catch (Exception e){
            return true;
        }
    }
}
