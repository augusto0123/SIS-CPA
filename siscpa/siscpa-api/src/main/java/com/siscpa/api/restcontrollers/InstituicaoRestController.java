package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.InstituicaoBackendConfiguration;
import fai.cpa.entities.InstituicaoModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituicao")
public class InstituicaoRestController {

    private final InstituicaoBackendConfiguration instituicaoBackendConfiguration = new InstituicaoBackendConfiguration();

    @GetMapping("/all")
    public List<InstituicaoModel> getInstituicoes(){
        List<InstituicaoModel> instituicoes = instituicaoBackendConfiguration.findInstituicao().find();
        return instituicoes;
    }

    @PostMapping("/add")
    public int getCreateInstituicao(@RequestBody InstituicaoModel instituicaoModel){
        return instituicaoBackendConfiguration.createInstituicao().createInstituicao(instituicaoModel);
    }

    @PutMapping("/update")
    public boolean getUpdateInstituicao(@RequestBody InstituicaoModel instituicaoModel){
        return instituicaoBackendConfiguration.updateInstituicao().update(instituicaoModel);
    }

    @DeleteMapping("/delete")
    public boolean delete(@PathVariable("id") final int id){
        return instituicaoBackendConfiguration.deleteInstituicao().delete(id);
    }
}
