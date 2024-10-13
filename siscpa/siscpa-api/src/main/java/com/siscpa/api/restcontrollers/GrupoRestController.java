package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.GrupoBackendConfiguration;
import fai.cpa.entities.GrupoDePerguntasModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo")
public class GrupoRestController {

    private final GrupoBackendConfiguration grupoBackendConfiguration = new GrupoBackendConfiguration();

    @GetMapping("/all")
    @CrossOrigin
    public List<GrupoDePerguntasModel> getGrupos(){
        List<GrupoDePerguntasModel> grupos = grupoBackendConfiguration.findGrupoDePerguntas().find();
        return grupos;
    }

    @GetMapping("/add")
    public int getCreateGrupo(@RequestBody GrupoDePerguntasModel grupo){
        return grupoBackendConfiguration.createGrupoDePerguntas().createGrupoDePerguntas(grupo);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<GrupoDePerguntasModel> findById(@PathVariable("id") final int id){
        return ResponseEntity.ok(grupoBackendConfiguration.findGrupoDePerguntas().find(id));
    }
}
