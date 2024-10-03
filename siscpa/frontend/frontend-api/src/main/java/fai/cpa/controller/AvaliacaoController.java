package fai.cpa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @GetMapping("/reuniao")
    public String getReuniaoPage(){
        return "avaliacao/reuniao";
    }

    @GetMapping("/edicao")
    public String getEdicaoPage(){
        return "avaliacao/edicao";
    }

    @GetMapping("/pergunta")
    public String getPerguntaPage(){
        return "avaliacao/pergunta";
    }

    @GetMapping("/grupo")
    public String getGrupoPage(){
        return "avaliacao/grupo";
    }

    @GetMapping("/questionario")
    public String getQuestionarioPage(){
        return "avaliacao/questionario";
    }

    @GetMapping("/listar-perguntas")
    public String getListarPerguntasPage(){
        return "avaliacao/listar-perguntas";
    }

    @GetMapping("/listar-questionarios")
    public String getListarQuestionariosPage(){
        return "avaliacao/listar-questionarios";
    }

    @GetMapping("/listar-grupos")
    public String getListarGruposPage(){
        return "avaliacao/listar-grupos";
    }

    @GetMapping("/participar-questionario")
    public String getParticiparQuestionarioPage(){
        return "avaliacao/participar-questionario";
    }

    @GetMapping("/responder-questionario")
    public String getResponderQuestionarioPage(){
        return "avaliacao/responder-questionario";
    }

}
