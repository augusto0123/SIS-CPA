package instituicao;

import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.EnderecoModel;
import fai.cpa.entities.InstituicaoModel;
import port.EnderecoRepository;
import port.InstituicaoRepository;

import java.util.List;

public class FindInstituicao {

    private final EnderecoRepository enderecoRepository;

    private final InstituicaoRepository instituicaoRepository;


    public FindInstituicao(EnderecoRepository enderecoRepository, InstituicaoRepository instituicaoRepository) {
        this.enderecoRepository = enderecoRepository;
        this.instituicaoRepository = instituicaoRepository;
    }

    public List<InstituicaoModel> find(){
        final List<InstituicaoModel> instituicoes = instituicaoRepository.findAll();
        if (instituicoes == null){
            return null;
        }
        for (InstituicaoModel instituicao:instituicoes){
            instituicao.setEndereco(enderecoRepository.findById(instituicao.getEndereco_id()));
        }
        return instituicoes;
    }

    public InstituicaoModel find(final int id){
        if(id < 0){
            throw new InvalidException();
        }
        InstituicaoModel instituicao =instituicaoRepository.findById(id);
        if (instituicao == null){
            final String message = "O id (" + id + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        instituicao.setEndereco(enderecoRepository.findById(instituicao.getEndereco_id()));
        return instituicao;
    }
}
