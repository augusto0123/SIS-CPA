package endereco;

import fai.cpa.entities.EnderecoModel;
import port.EnderecoRepository;

public class CreateEndereco {

    private final EnderecoRepository enderecoRepository;

    public CreateEndereco(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public int createEndereco(final EnderecoModel enderecoModel){
        if (enderecoModel == null){
            return -1;
        }
        if (enderecoModel.getCep().isEmpty()
        || enderecoModel.getBairro().isEmpty()
        || enderecoModel.getLogradouro().isEmpty()
        || enderecoModel.getNumero().isEmpty()){
            return -1;
        }
        int id = 0;
        try {
            id = enderecoRepository.create(enderecoModel);
            enderecoModel.setId(id);
        }catch (Exception e){
            return -1;
        }
        return id;
    }
}
