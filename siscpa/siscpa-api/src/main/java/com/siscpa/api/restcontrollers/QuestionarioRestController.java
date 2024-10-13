package com.siscpa.api.restcontrollers;

import com.siscpa.api.configuration.QuestionarioBackendConfiguration;
import fai.cpa.entities.QuestionarioModel;
import org.springframework.web.bind.annotation.*;
import port.QuestionarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/questionario")
public class QuestionarioRestController {

    private final QuestionarioBackendConfiguration questionarioBackendConfiguration;

    public QuestionarioRestController(QuestionarioBackendConfiguration questionarioBackendConfiguration) {
        this.questionarioBackendConfiguration = questionarioBackendConfiguration;
    }

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
}
