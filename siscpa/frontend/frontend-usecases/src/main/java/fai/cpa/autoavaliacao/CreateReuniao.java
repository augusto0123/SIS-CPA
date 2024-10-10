package fai.cpa.autoavaliacao;


import fai.cpa.entities.ReuniaoCpaModel;
import fai.cpa.port.RestService;

public class CreateReuniao {

    private final RestService<ReuniaoCpaModel> restService;

    public CreateReuniao(RestService<ReuniaoCpaModel> restService) {
        this.restService = restService;
    }

    public int createReuniao(ReuniaoCpaModel reuniao){
        final String resource = "/reuniao/add";
        final int id = restService.post(resource, reuniao);
        return id;
    }
}
