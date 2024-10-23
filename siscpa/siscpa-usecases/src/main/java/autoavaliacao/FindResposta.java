package autoavaliacao;

import com.sun.jdi.PrimitiveValue;
import exception.InvalidException;
import exception.NotFoundException;
import fai.cpa.entities.GraficoModel;
import fai.cpa.entities.PerguntaModel;
import fai.cpa.entities.RespostaModel;
import port.GraficoRepository;
import port.PerguntaRepository;
import port.RespostaRepository;

import java.util.ArrayList;
import java.util.List;

public class FindResposta {

    private final RespostaRepository respostaRepository;

    private final GraficoRepository graficoRepository;

    private final PerguntaRepository perguntaRepository;

    public FindResposta(RespostaRepository respostaRepository, GraficoRepository graficoRepository, PerguntaRepository perguntaRepository) {
        this.respostaRepository = respostaRepository;
        this.graficoRepository = graficoRepository;
        this.perguntaRepository = perguntaRepository;
    }

    public List<RespostaModel> find(){
        final List<RespostaModel> respostas = respostaRepository.findAll();
        if (respostas == null){
            return null;
        }
        return respostas;
    }

    public RespostaModel find(final int id){
        if (id < 0){
            throw new InvalidException();
        }
        final RespostaModel resposta = respostaRepository.findById(id);
        if (resposta == null){
            final String message = "O id " + id + " não foi encontrado";
            throw new NotFoundException(message);
        }
        return resposta;
    }

    public List<RespostaModel> findAllByAvaliacaoId(final int avaliacaoId){
        if (avaliacaoId <= 0){
            throw new InvalidException();
        }
        List<RespostaModel> respostas = respostaRepository.findAllByAvaliacaoId(avaliacaoId);
        if (respostas == null){
            final String message = "O id (" + avaliacaoId + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return respostas;
    }

    public List<RespostaModel> findAllByInstituicaoId(final int instituicaoId){
        if (instituicaoId <= 0){
            throw new InvalidException();
        }
        List<RespostaModel> respostas = respostaRepository.findAllByInstituicao(instituicaoId);
        if (respostas == null){
            final String message = "O id (" + instituicaoId + ") não foi encontrado";
            throw new NotFoundException(message);
        }
        return respostas;
    }

    public List<GraficoModel> findObjetivaByAvaliacaoId(final int avaliacaoId){
        if (avaliacaoId <= 0) {
            throw new InvalidException();
        }
        List<GraficoModel> graficos = graficoRepository.findObjetivaByAvaliacaoId(avaliacaoId);
        if (graficos == null || graficos.isEmpty()) {
            final String message = "Nenhum dado encontrado para a avaliação com ID: " + avaliacaoId;
            throw new NotFoundException(message);
        }
        return graficos;
    }

    public List<RespostaModel> findSubjetivaByAvaliacaoId(final int avaliacaoId){
        if (avaliacaoId <= 0){
            throw new InvalidException();
        }
        List<RespostaModel> respostaModels = graficoRepository.findSubjetivaByAvaliacaoId(avaliacaoId);
        if (respostaModels == null || respostaModels.isEmpty()){
            final String message = "Nenhum dado encontrado para a avaliação com ID: " + avaliacaoId;
            System.out.println(message);
            return new ArrayList<>();
        }
        for (RespostaModel respostaModel:respostaModels){
            respostaModel.setPerguntaModel(perguntaRepository.findById(respostaModel.getPerguntaId()));
        }
        return respostaModels;
    }

}
