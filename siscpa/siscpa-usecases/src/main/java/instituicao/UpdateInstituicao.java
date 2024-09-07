package instituicao;

import port.InstituicaoRepository;
import fai.cpa.entities.InstituicaoModel;

public class UpdateInstituicao {

    private final InstituicaoRepository instituicaoRepository;

    public UpdateInstituicao(InstituicaoRepository instituicaoRepository) {
        this.instituicaoRepository = instituicaoRepository;
    }

    public boolean update(final InstituicaoModel instituicaoModel){
        final InstituicaoModel byId =instituicaoRepository.findById(instituicaoModel.getId());
        byId.setCnpj(instituicaoModel.getCnpj());
        byId.setTelefone(instituicaoModel.getTelefone());
        byId.setSituacao(instituicaoModel.getSituacao());
        byId.setResposavelEmail(instituicaoModel.getResposavelEmail());
        byId.setResponsavelTelefone(instituicaoModel.getResponsavelTelefone());
        byId.setResponsavelNome(instituicaoModel.getResponsavelNome());
        byId.setRazao_social(instituicaoModel.getRazao_social());
        byId.setNome_fantasia(instituicaoModel.getNome_fantasia());

        boolean updateInstituicao = false;
        try {
            updateInstituicao =instituicaoRepository.update(byId);
            return updateInstituicao;
        } catch (Exception e){
            return true;
        }
    }
}
