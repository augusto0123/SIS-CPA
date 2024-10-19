package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.QuestionarioBackendConfiguration;
import fai.cpa.entities.QuestionarioModel;
import org.springframework.web.bind.annotation.*;
import port.QuestionarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/questionario")
public class QuestionarioRestController {

    private final QuestionarioBackendConfiguration questionarioBackendConfiguration = new QuestionarioBackendConfiguration();

    @GetMapping("/all")
    @CrossOrigin
    public List<QuestionarioModel> getQuestionario(){
        List<QuestionarioModel> questionarios = questionarioBackendConfiguration.findQuestionario().find();
        return questionarios;
    }

    @PostMapping("/add")
    public int getCreateQuestionario(@RequestBody QuestionarioModel questionario){
        return questionarioBackendConfiguration.createQuestionario().createQuestionario(questionario);
    }

    @PutMapping("/vincular-questionario")
    public boolean vincularQuestionario(@RequestBody final QuestionarioModel questionario){
        return questionarioBackendConfiguration.updateQuestionario().vincularQuestionario(questionario);
    }

    @GetMapping("/findByInstituicaoId/{id}")
    public List<QuestionarioModel> getQuestionariosByInstituicaoId(@PathVariable("id") int id){
        List<QuestionarioModel> questionarios = questionarioBackendConfiguration.findQuestionario().findAllByInstituicaoId(id);
        return questionarios;
    }

    @GetMapping("/findByAvaliacaoId/{id}")
    public List<QuestionarioModel> getQuestionariosByEdicaoId(@PathVariable("id") int id){
        List<QuestionarioModel> questionarios = questionarioBackendConfiguration.findQuestionario().findAllByAvaliacaoId(id);
        return questionarios;
    }

}
