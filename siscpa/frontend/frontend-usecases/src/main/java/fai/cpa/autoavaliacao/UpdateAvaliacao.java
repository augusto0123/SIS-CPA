package fai.cpa.autoavaliacao;

import fai.cpa.entities.AvaliacaoModel;
import fai.cpa.entities.ReuniaoCpaModel;
import fai.cpa.port.RestService;

import java.util.List;

public class UpdateAvaliacao {

    private final RestService<AvaliacaoModel> restService;

    public UpdateAvaliacao(RestService<AvaliacaoModel> restService) {
        this.restService = restService;
    }

    public boolean vincularAvaliacao(AvaliacaoModel avaliacao) {
        final String resource = "/avaliacao/vincular-avaliacao";
        boolean resultado = restService.put(resource, avaliacao);

        return resultado;
    }
}
