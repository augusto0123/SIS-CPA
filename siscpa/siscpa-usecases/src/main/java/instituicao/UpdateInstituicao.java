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
        byId.setResponsavelEmail(instituicaoModel.getResponsavelEmail());
        byId.setResponsavelTelefone(instituicaoModel.getResponsavelTelefone());
        byId.setResponsavelNome(instituicaoModel.getResponsavelNome());
        byId.setRazaoSocial(instituicaoModel.getRazaoSocial());
        byId.setNomeFantasia(instituicaoModel.getNomeFantasia());

        boolean updateInstituicao = false;
        try {
            updateInstituicao =instituicaoRepository.update(byId);
            return updateInstituicao;
        } catch (Exception e){
            return true;
        }
    }

    public boolean updateFoto(int id, String foto){

        boolean updateInstituicao = false;
        try {
            updateInstituicao =instituicaoRepository.updateFoto(id, foto);
            return updateInstituicao;
        } catch (Exception e){
            return true;
        }
    }
}
