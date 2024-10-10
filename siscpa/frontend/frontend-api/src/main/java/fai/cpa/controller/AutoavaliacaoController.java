package fai.cpa.controller;


import fai.cpa.autoavaliacao.CreateReuniao;
import fai.cpa.autoavaliacao.ShowAllReunioes;
import fai.cpa.entities.ReuniaoCpaModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autoavaliacao")
public class AutoavaliacaoController {

    private final CreateReuniao createReuniao;
    private final ShowAllReunioes showAllReunioes;

    public AutoavaliacaoController(CreateReuniao createReuniao, ShowAllReunioes showAllReunioes) {
        this.createReuniao = createReuniao;
        this.showAllReunioes = showAllReunioes;
    }

//    ==================================================================================================================
//    Container de CADASTROS...

    @GetMapping("/cadastrar-reuniao")
    public String getReuniaoPage(){
        return "autoavaliacao/cadastrar-reuniao";
    }
    @GetMapping("/cadastrar-edicao")
    public String getEdicaoPage(){
        return "autoavaliacao/cadastrar-edicao";
    }

    @GetMapping("/cadastrar-avaliacao")
    public String getautoavaliacaoPage(){
        return "autoavaliacao/cadastrar-avaliacao";
    }

    @GetMapping("/cadastrar-questionario")
    public String getQuestionarioPage(){
        return "autoavaliacao/cadastrar-questionario";
    }


    @GetMapping("/cadastrar-grupo")
    public String getGrupoPage(){
        return "autoavaliacao/cadastrar-grupo";
    }

    @GetMapping("/cadastrar-pergunta")
    public String getPerguntaPage(){
        return "autoavaliacao/cadastrar-pergunta";
    }


    //    ==================================================================================================================
    //    Container de LISTAGENS...

    @GetMapping("/listar-edicoes")
    public String getListarEdicoesPage(){
        return "autoavaliacao/listar-edicoes";
    }

    @GetMapping("listar-avaliacoes")
    public String getListarAvaliacoesPage(){
        return "autoavaliacao/listar-avaliacoes";
    }

    @GetMapping("/listar-questionarios")
    public String getListarQuestionariosPage(){
        return "autoavaliacao/listar-questionarios";
    }

    @GetMapping("/listar-grupos")
    public String getListarGruposPage(){
        return "autoavaliacao/listar-grupos";
    }

    @GetMapping("/listar-perguntas")
    public String getListarPerguntasPage(){
        return "autoavaliacao/listar-perguntas";
    }

//    ==================================================================================================================
//    Container de RESPOSTAS

    @GetMapping("/responder-edicao")
    public String getResponderEdicaoPage(){
        return "autoavaliacao/responder-edicao";
    }

    @GetMapping("/responder-avaliacao")
    public String getResponderautoavaliacaoPage(){
        return "autoavaliacao/responder-avaliacao";
    }

    @GetMapping("/responder-questionario")
    public String getResponderQuestionarioPage(){
        return "autoavaliacao/responder-questionario";
    }

    @GetMapping("/responder-grupos")
    public String getResponderGrupos(){
        return "autoavaliacao/responder-grupos";
    }

    @GetMapping("/responder-perguntas")
    public String getResponderPerguntas(){
        return "autoavaliacao/responder-perguntas";
    }

//    ==================================================================================================================
//    Container de VINCULAÇÕES

    @GetMapping("vincular-avaliacao")
    public String getVincularautoavaliacaoPage(){
        return "autoavaliacao/vincular-avaliacao";
    }

    @GetMapping("vincular-questionario")
    public String getVincularQuestionarioPage(){
        return "autoavaliacao/vincular-questionario";
    }

    @GetMapping("/vincular-grupo")
    public String getVincularGrupoPage() {
        return "autoavaliacao/vincular-grupo";
    }

    @GetMapping("/vincular-pergunta")
    public String getVincularPerguntaPage(){
        return "autoavaliacao/vincular-pergunta";
    }

}
