package autoavaliacao;

import fai.cpa.entities.RespostaModel;
import port.RespostaRepository;

import java.util.List;

public class CreateResposta {

    private final RespostaRepository respostaRepository;

    public CreateResposta(RespostaRepository respostaRepository) {
        this.respostaRepository = respostaRepository;
    }

    public int createResposta(final RespostaModel respostaModel){
        if (respostaModel == null){
            return -1;
        }
        if (respostaModel.getRespostaObjetiva().isEmpty() && respostaModel.getRespostaSubjetiva().isEmpty()){
            return -1;
        }

        String[] respostas = null;

        if (!respostaModel.getRespostaObjetiva().isEmpty()){
            respostas = respostaModel.getRespostaObjetiva().split(";");

            for (String resposta:respostas){
                String[] valor = resposta.split("-");
                RespostaModel resposta1 = new RespostaModel();
                resposta1.setRespostaObjetiva(valor[1]);
                resposta1.setPerguntaId(Integer.parseInt(valor[0]));
                resposta1.setInstituicaoId(respostaModel.getInstituicaoId());
                resposta1.setUsuarioId(respostaModel.getUsuarioId());
                int id =  respostaRepository.create(resposta1);

                if (id == 0){
                    return -1;
                }
            }
        }


        if (!respostaModel.getRespostaSubjetiva().isEmpty()){
            respostas = respostaModel.getRespostaSubjetiva().split(";");

            for (String resposta : respostas) {
                if (resposta == null || resposta.trim().isEmpty()) {
                    System.out.println("Resposta vazia ou nula ignorada.");
                    continue;
                }

                String[] valor = resposta.split("-");
                if (valor.length < 2) {
                    System.err.println("Formato inválido para resposta: " + resposta);
                    continue;
                }

                RespostaModel resposta1 = new RespostaModel();
                resposta1.setRespostaSubjetiva(valor[1]);
                resposta1.setPerguntaId(Integer.parseInt(valor[0]));
                resposta1.setInstituicaoId(respostaModel.getInstituicaoId());
                resposta1.setUsuarioId(respostaModel.getUsuarioId());

                int id = respostaRepository.create(resposta1);

                if (id == 0) {
                    return -1;
                }
            }
        }

        return 1;
    }
}
