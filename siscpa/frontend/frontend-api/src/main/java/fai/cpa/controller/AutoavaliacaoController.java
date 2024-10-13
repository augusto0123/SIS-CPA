package fai.cpa.controller;


import fai.cpa.autoavaliacao.*;
import fai.cpa.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autoavaliacao")
public class AutoavaliacaoController {

    private final CreateReuniao createReuniao;
    private final ShowAllReunioes showAllReunioes;
    private final CreateEdicao createEdicao;
    private final ShowAllEdicoes showAllEdicoes;
    private final CreateAvaliacao createAvaliacao;
    private final ShowAllAvaliacoes showAllAvaliacoes;

    public AutoavaliacaoController(CreateReuniao createReuniao, ShowAllReunioes showAllReunioes, CreateEdicao createEdicao, ShowAllEdicoes showAllEdicoes, CreateAvaliacao createAvaliacao, ShowAllAvaliacoes showAllAvaliacoes) {
        this.createReuniao = createReuniao;
        this.showAllReunioes = showAllReunioes;
        this.createEdicao = createEdicao;
        this.showAllEdicoes = showAllEdicoes;
        this.createAvaliacao = createAvaliacao;
        this.showAllAvaliacoes = showAllAvaliacoes;
    }

//    ==================================================================================================================
//    Container de CADASTROS...

    @GetMapping("/cadastrar-reuniao")
    public String getReuniaoPage(final Model model){

        model.addAttribute("reuniao" , new ReuniaoCpaModel());

        return "autoavaliacao/cadastrar-reuniao";
    }

    @GetMapping("/cadastrar-edicao")
    public String getEdicaoPage(final Model model){

        model.addAttribute("edicao", new EdicaoDeAutoAvaliacaoModel());

        return "autoavaliacao/cadastrar-edicao";
    }

    @GetMapping("/cadastrar-avaliacao")
    public String getautoavaliacaoPage(final Model model){

        model.addAttribute("avaliacao", new AvaliacaoModel());

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

    @GetMapping("/listar-reunioes")
    public String getListarReunioesPage(final Model model){
        List<ReuniaoCpaModel> reunioes = showAllReunioes.showAllReunioes();

        if (reunioes == null)
            reunioes = new ArrayList<>();

        model.addAttribute("reunioes", reunioes);
        return "instituicao/inicio";
    }

    @GetMapping("/listar-edicoes")
    public String getListarEdicoesPage(final Model model){
        List<EdicaoDeAutoAvaliacaoModel> edicoes = showAllEdicoes.showAllEdicoes();

        if (edicoes == null)
            edicoes = new ArrayList<>();

        model.addAttribute("edicoes", edicoes);
        return "autoavaliacao/listar-edicoes";
    }

    @GetMapping("listar-avaliacoes")
    public String getListarAvaliacoesPage(final Model model){
        List<AvaliacaoModel> avaliacoes = showAllAvaliacoes.showAllAvaliacoes();

        if (avaliacoes == null)
            avaliacoes = new ArrayList<>();

        model.addAttribute("avaliacoes", avaliacoes);
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

//    ==================================================================================================================
//    Container de POSTMAPING

    @PostMapping("/criar-reuniao")
    public String criarReuniao(final ReuniaoCpaModel reuniao, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        reuniao.setMembroCpaId(usuario.getInstituicaoId());
        final int id = createReuniao.createReuniao(reuniao);
        if (id > 0){
            return "redirect:/instituicao/inicio";
        }
        return "redirect:/not-found";
    }

    @PostMapping("/criar-edicao")
    public String criarEdicao(final EdicaoDeAutoAvaliacaoModel edicao, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        edicao.setInstituicaoId(usuario.getInstituicaoId());
        final int id = createEdicao.createEdicao(edicao);
        if (id > 0){
            return "redirect:/autoavaliacao/listar-edicoes";
        }
        return "redirect:/not-found";
    }

    @PostMapping("/criar-avaliacao")
    public String criarAvaliacao(final AvaliacaoModel avaliacao,HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        avaliacao.setEdicaoId(usuario.getInstituicaoId());
        final int id = createAvaliacao.createAvaliacao(avaliacao);
        if (id > 0){
            return "redirect:/autoavaliacao/listar-avalicoes";
        }
        return "redirect:/not-found";
    }
}
