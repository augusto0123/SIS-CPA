package fai.cpa.autoavaliacao;

import fai.cpa.entities.ReuniaoCpaModel;
import fai.cpa.port.RestService;

import java.util.List;

public class ShowLastReuniao {

    private final RestService<ReuniaoCpaModel> restService;

    public ShowLastReuniao(RestService<ReuniaoCpaModel> restService) {
        this.restService = restService;
    }

    public ReuniaoCpaModel showLastReuniao() {
        final String resource = "/reuniao/last";
        List<ReuniaoCpaModel> reunioes = restService.get(resource);

        return (reunioes != null && !reunioes.isEmpty()) ? reunioes.get(0) : null;
    }
}
