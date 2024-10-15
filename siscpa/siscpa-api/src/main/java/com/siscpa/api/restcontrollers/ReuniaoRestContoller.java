package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.ReuniaoBackendConfiguration;
import fai.cpa.entities.ReuniaoCpaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reuniao")
public class ReuniaoRestContoller {

    private final ReuniaoBackendConfiguration reuniaoBackendConfiguration = new ReuniaoBackendConfiguration();

    @GetMapping("/all")
    @CrossOrigin
    public List<ReuniaoCpaModel> getReunioes(){
        List<ReuniaoCpaModel> reunioes = reuniaoBackendConfiguration.findReuniaoCpa().find();
        return reunioes;
    }

    @PostMapping("/add")
    public int getCreateReuniao(@RequestBody ReuniaoCpaModel reuniaoCpaModel){
        return reuniaoBackendConfiguration.createReuniaoCpa().createReuniaoCpa(reuniaoCpaModel);
    }

    @PutMapping("/update")
    public boolean getUpdateReuniao(@RequestBody ReuniaoCpaModel reuniaoCpaModel){
        return reuniaoBackendConfiguration.updateReuniaoCpa().update(reuniaoCpaModel);
    }

    @GetMapping("/find/{id}")
    public ReuniaoCpaModel getReuniaoById(@PathVariable("id") final int id){
        ReuniaoCpaModel reuniaoCpaModel = reuniaoBackendConfiguration.findReuniaoCpa().find(id);
        return reuniaoCpaModel;
    }

    @GetMapping("/last")
    @CrossOrigin
    public ReuniaoCpaModel getLastReuniao(){
        return reuniaoBackendConfiguration.findReuniaoCpa().findLastReuniao();
    }
}
