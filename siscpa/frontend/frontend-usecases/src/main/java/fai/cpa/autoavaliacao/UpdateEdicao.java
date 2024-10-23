package fai.cpa.autoavaliacao;

import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import fai.cpa.entities.GrupoDePerguntasModel;
import fai.cpa.port.RestService;

public class UpdateEdicao {

    private final RestService<EdicaoDeAutoAvaliacaoModel> restService;

    public UpdateEdicao(RestService<EdicaoDeAutoAvaliacaoModel> restService) {
        this.restService = restService;
    }

    public boolean atualizarEdicao(EdicaoDeAutoAvaliacaoModel edicao){
        final String resource = "/edicoes/atualizar-edicao/" + edicao.getId();
        boolean resultado = restService.put(resource, edicao);

        return resultado;
    }
}
