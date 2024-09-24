package instituicao;

import exception.InvalidException;
import fai.cpa.entities.InstituicaoModel;
import port.InstituicaoRepository;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class CreateInstituicao {

    private final InstituicaoRepository instituicaoRepository;

    public CreateInstituicao(InstituicaoRepository instituicaoRepository) {
        this.instituicaoRepository = instituicaoRepository;
    }

    public int createInstituicao(final InstituicaoModel instituicaoModel){
        if(instituicaoModel == null){
            return -1;
        }
        String var = instituicaoModel.getSituacao().toLowerCase();
        String normVar = removeAccentsAfterJava7(var);
        instituicaoModel.setSituacao(normVar);
        if(instituicaoModel.getCnpj().isEmpty()
                ||instituicaoModel.getEmail().isEmpty()
                ||instituicaoModel.getNomeFantasia().isEmpty()
                ||instituicaoModel.getRazaoSocial().isEmpty()
                ||instituicaoModel.getResponsavelNome().isEmpty()
                ||instituicaoModel.getResponsavelTelefone().isEmpty()
                ||instituicaoModel.getTelefone().isEmpty()
                ||instituicaoModel.getResposavelEmail().isEmpty()){
            return -1;
        }
        int id = 0;
        try {
            id = instituicaoRepository.create(instituicaoModel);
            instituicaoModel.setId(id);
        } catch (Exception e) {
            return -1;
        }
        return id;
    }

    public static String removeAccentsAfterJava7(String value) {
        String normalizer = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }
}
