package fai.cpa.controller;


import fai.cpa.avaliacao.CreateReuniao;
import fai.cpa.avaliacao.ShowAllReunioes;
import fai.cpa.entities.ReuniaoCpaModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    private final CreateReuniao createReuniao;
    private final ShowAllReunioes showAllReunioes;

    public AvaliacaoController(CreateReuniao createReuniao, ShowAllReunioes showAllReunioes) {
        this.createReuniao = createReuniao;
        this.showAllReunioes = showAllReunioes;
    }

    @GetMapping("/cadastrar-reuniao")
    public String getReuniaoPage(final Model model){
        model.addAttribute("reuniao", new ReuniaoCpaModel());
        return "avaliacao/cadastrar-reuniao";
    }
    @GetMapping("/cadastrar-edicao")
    public String getEdicaoPage(){
        return "avaliacao/cadastrar-edicao";
    }

    @GetMapping("/cadastrar-pergunta")
    public String getPerguntaPage(){
        return "avaliacao/cadastrar-pergunta";
    }

    @GetMapping("/cadastrar-grupo")
    public String getGrupoPage(){
        return "avaliacao/cadastrar-grupo";
    }

    @GetMapping("/cadastrar-questionario")
    public String getQuestionarioPage(){
        return "avaliacao/cadastrar-questionario";
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

    @GetMapping("/responder-edicao")
    public String getResponderEdicaoPage(){
        return "avaliacao/responder-edicao";
    }

    @GetMapping("/responder-questionario")
    public String getResponderQuestionarioPage(){
        return "avaliacao/responder-questionario";
    }

    @GetMapping("/responder-grupos")
    public String getResponderGrupos(){
        return "avaliacao/responder-grupos";
    }

    @GetMapping("/responder-perguntas")
    public String getResponderPerguntas(){ return "avaliacao/responder-perguntas";}

    @GetMapping("/listar-edicoes")
    public String getListarEdicoesPage(){
        return "avaliacao/listar-edicoes";
    }

    @GetMapping("/vincular-pergunta")
    public String getVincularPerguntaPage(){
        return "avaliacao/vincular-pergunta";
    }

    @GetMapping("/vincular-grupo")
    public String getVincularGrupoPage() {
        return "avaliacao/vincular-grupo";
    }

    @GetMapping("vincular-questionario")
    public String getVincularQuestionarioPage(){
        return "avaliacao/vincular-questionario";
    }

}
