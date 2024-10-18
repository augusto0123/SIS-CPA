package fai.cpa.controller;


import fai.cpa.autoavaliacao.*;
import fai.cpa.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
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
    private final CreateQuestionario createQuestionario;
    private final ShowAllQuestionarios showAllQuestionarios;
    private final CreateGrupo createGrupo;
    private final ShowAllGrupos showAllGrupos;
    private final ShowLastReuniao showLastReuniao;
    private final CreatePergunta createPergunta;
    private final ShowAllPerguntas showAllPerguntas;
    private final UpdateAvaliacao updateAvaliacao;

    public AutoavaliacaoController(CreateReuniao createReuniao, ShowAllReunioes showAllReunioes, CreateEdicao createEdicao, ShowAllEdicoes showAllEdicoes, CreateAvaliacao createAvaliacao, ShowAllAvaliacoes showAllAvaliacoes, CreateQuestionario createQuestionario, ShowAllQuestionarios showAllQuestionarios, CreateGrupo createGrupo, ShowAllGrupos showAllGrupos, ShowLastReuniao showLastReuniao, CreatePergunta createPergunta, ShowAllPerguntas showAllPerguntas, UpdateAvaliacao updateAvaliacao) {
        this.createReuniao = createReuniao;
        this.showAllReunioes = showAllReunioes;
        this.createEdicao = createEdicao;
        this.showAllEdicoes = showAllEdicoes;
        this.createAvaliacao = createAvaliacao;
        this.showAllAvaliacoes = showAllAvaliacoes;
        this.createQuestionario = createQuestionario;
        this.showAllQuestionarios = showAllQuestionarios;
        this.createGrupo = createGrupo;
        this.showAllGrupos = showAllGrupos;
        this.showLastReuniao = showLastReuniao;
        this.createPergunta = createPergunta;
        this.showAllPerguntas = showAllPerguntas;
        this.updateAvaliacao = updateAvaliacao;
    }

//    ==================================================================================================================
//    Container de CADASTROS...

    @GetMapping("/cadastros")
    public String getCadastrosPage(HttpSession session, final Model model){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "autoavaliacao/cadastros";
    }

    @GetMapping("/cadastrar-reuniao")
    public String getReuniaoPage(final Model model, HttpSession session){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        model.addAttribute("reuniao" , new ReuniaoCpaModel());

        return "autoavaliacao/cadastrar-reuniao";
    }

    @GetMapping("/cadastrar-edicao")
    public String getEdicaoPage(final Model model, HttpSession session){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        model.addAttribute("edicao", new EdicaoDeAutoAvaliacaoModel());

        return "autoavaliacao/cadastrar-edicao";
    }

    @GetMapping("/cadastrar-avaliacao")
    public String getautoavaliacaoPage(final Model model, HttpSession session){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        model.addAttribute("avaliacao", new AvaliacaoModel());

        return "autoavaliacao/cadastrar-avaliacao";
    }

    @GetMapping("/cadastrar-questionario")
    public String getQuestionarioPage(final Model model, HttpSession session){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        model.addAttribute("questionario", new QuestionarioModel());

        return "autoavaliacao/cadastrar-questionario";
    }


    @GetMapping("/cadastrar-grupo")
    public String getGrupoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        model.addAttribute("grupo", new GrupoDePerguntasModel());

        return "autoavaliacao/cadastrar-grupo";
    }

    @GetMapping("/cadastrar-pergunta")
    public String getPerguntaPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        model.addAttribute("pergunta", new PerguntaModel());

        return "autoavaliacao/cadastrar-pergunta";
    }


    //    ==================================================================================================================
    //    Container de LISTAGENS...

    @GetMapping("/registros")
    public String getRegistrosPage(final Model model, HttpSession session){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "autoavaliacao/registros";
    }

    @GetMapping("/listar-reunioes")
    public String getListarReunioesPage(final Model model, HttpSession session){
        List<ReuniaoCpaModel> reunioes = showAllReunioes.showAllReunioes();

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (reunioes == null || reunioes.isEmpty())
            reunioes = new ArrayList<>();

        model.addAttribute("reunioes", reunioes);
        return "instituicao/inicio";
    }

    @GetMapping("/listar-ultima-reuniao")
    public String getLastReuniaoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);


        ReuniaoCpaModel ultimaReuniao = showLastReuniao.showLastReuniao();

        model.addAttribute("ultimaReuniao", ultimaReuniao);

        return "instituicao/inicio";

    }

    @GetMapping("/listar-edicoes")
    public String getListarEdicoesPage(final Model model, HttpSession session){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<EdicaoDeAutoAvaliacaoModel> edicoes = showAllEdicoes.showAllEdicoesByInstituicaoId(usuario.getInstituicaoId());

        if (edicoes == null)
            edicoes = new ArrayList<>();

        model.addAttribute("edicoes", edicoes);
        return "autoavaliacao/listar-edicoes";
    }

    @GetMapping("/listar-edicoes-inicio")
    public String getListarEdicoesInicioPage(final Model model, HttpSession session) {

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<EdicaoDeAutoAvaliacaoModel> edicoes = showAllEdicoes.showAllEdicoesByInstituicaoId(usuario.getInstituicaoId());

        if (edicoes == null) {
            edicoes = new ArrayList<>();
        }

        model.addAttribute("edicoes", edicoes);
        return "instituicao/inicio";
    }

    @GetMapping("/listar-avaliacoes")
    public String getListarAvaliacoesPage(final Model model, HttpSession session){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<AvaliacaoModel> avaliacoes = showAllAvaliacoes.showAllAvaliacoesByInstituicaoId(usuario.getInstituicaoId());

        if (avaliacoes == null)
            avaliacoes = new ArrayList<>();

        model.addAttribute("avaliacoes", avaliacoes);
        return "autoavaliacao/listar-avaliacoes";
    }

    @GetMapping("/listar-questionarios")
    public String getListarQuestionariosPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<QuestionarioModel> questionarios = showAllQuestionarios.shollAllQuestionariosByInstituicaoId(usuario.getInstituicaoId());

        if (questionarios == null)
            questionarios = new ArrayList<>();

        model.addAttribute("questionarios", questionarios);

        return "autoavaliacao/listar-questionarios";
    }

    @GetMapping("/listar-grupos")
    public String getListarGruposPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<GrupoDePerguntasModel> grupos = showAllGrupos.showAllGrupos();

        if (grupos == null)
            grupos = new ArrayList<>();

        model.addAttribute("grupos", grupos);

        return "autoavaliacao/listar-grupos";
    }

    @GetMapping("/listar-perguntas")
    public String getListarPerguntasPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<PerguntaModel> perguntas = showAllPerguntas.showAllPerguntas();

        if (perguntas == null)
            perguntas = new ArrayList<>();

        model.addAttribute("perguntas", perguntas);

        return "autoavaliacao/listar-perguntas";
    }

//    ==================================================================================================================
//    Container de RESPOSTAS

    @GetMapping("/responder-edicao")
    public String getResponderEdicaoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<EdicaoDeAutoAvaliacaoModel> edicoes = showAllEdicoes.showAllEdicoesByInstituicaoId(usuario.getInstituicaoId());

        if (edicoes == null)
            edicoes = new ArrayList<>();

        model.addAttribute("edicoes", edicoes);

        return "autoavaliacao/responder-edicao";
    }

    @GetMapping("/responder-avaliacao")
    public String getResponderautoavaliacaoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<AvaliacaoModel> avaliacoes = showAllAvaliacoes.showAllAvaliacoes();

        if (avaliacoes == null)
            avaliacoes = new ArrayList<>();

        model.addAttribute("avaliacoes", avaliacoes);

        return "autoavaliacao/responder-avaliacao";
    }

    @GetMapping("/responder-questionario")
    public String getResponderQuestionarioPage(final Model model, HttpSession session){
        List<QuestionarioModel> questionarios = showAllQuestionarios.showAllQuestionarios();
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        if (questionarios == null)
            questionarios = new ArrayList<>();

        model.addAttribute("questionarios", questionarios);

        return "autoavaliacao/responder-questionario";
    }

    @GetMapping("/responder-grupos")
    public String getResponderGrupos(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<GrupoDePerguntasModel> grupos = showAllGrupos.showAllGrupos();

        if (grupos == null)
            grupos = new ArrayList<>();

        model.addAttribute("grupos", grupos);

        return "autoavaliacao/responder-grupos";
    }

    @GetMapping("/responder-perguntas")
    public String getResponderPerguntas(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<PerguntaModel> perguntas = showAllPerguntas.showAllPerguntas();

        if (perguntas == null)
            perguntas = new ArrayList<>();

        model.addAttribute("perguntas", perguntas);

        return "autoavaliacao/responder-perguntas";
    }

//    ==================================================================================================================
//    Container de VINCULAÇÕES

    @GetMapping("/vincular-avaliacao/{id}")
    public String getVincularautoavaliacaoPage(@PathVariable final int id, final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        List<AvaliacaoModel> avaliacoes = showAllAvaliacoes.showAllAvaliacoes();

        if (avaliacoes == null)
            avaliacoes = new ArrayList<>();

        model.addAttribute("edicaoId", id);
        model.addAttribute("avaliacoes", avaliacoes);
        return "autoavaliacao/vincular-avaliacao";
    }

    @GetMapping("vincular-questionario")
    public String getVincularQuestionarioPage(final Model model, HttpSession session){
        List<QuestionarioModel> questionarios = showAllQuestionarios.showAllQuestionarios();
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        if (questionarios ==  null)
            questionarios = new ArrayList<>();

        model.addAttribute("questionarios", questionarios);
        return "autoavaliacao/vincular-questionario";
    }

    @GetMapping("/vincular-grupo")
    public String getVincularGrupoPage(final Model model, HttpSession session) {
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        List<GrupoDePerguntasModel> grupos = showAllGrupos.showAllGrupos();

        if (grupos == null)
            grupos = new ArrayList<>();

        model.addAttribute("grupos", grupos);
        return "autoavaliacao/vincular-grupo";
    }

    @GetMapping("/vincular-pergunta")
    public String getVincularPerguntaPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        List<PerguntaModel> perguntas = showAllPerguntas.showAllPerguntas();

        if (perguntas == null)
            perguntas = new ArrayList<>();

        model.addAttribute("perguntas", perguntas);
        return "autoavaliacao/vincular-pergunta";
    }

//    ==================================================================================================================
//    Container de POSTMAPING

    @PostMapping("/criar-reuniao")
    public String criarReuniao(final ReuniaoCpaModel reuniao, HttpSession session, final Model model){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        reuniao.setInstituicaoId(usuario.getInstituicaoId());

        final int id = createReuniao.createReuniao(reuniao);
        if (id > 0){
            return "redirect:/instituicao/inicio";
        }
        return "redirect:/not-found";
    }

    @PostMapping("/criar-edicao")
    public String criarEdicao(final EdicaoDeAutoAvaliacaoModel edicao, HttpSession session, final Model model){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        edicao.setInstituicaoId(usuario.getInstituicaoId());

        final int id = createEdicao.createEdicao(edicao);
        if (id > 0){
            return "redirect:/autoavaliacao/listar-edicoes";
        }
        return "redirect:/not-found";
    }

    @PostMapping("/criar-avaliacao")
    public String criarAvaliacao(final AvaliacaoModel avaliacao,HttpSession session, final Model model){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        avaliacao.setInstituicaoId(usuario.getInstituicaoId());

        final int id = createAvaliacao.createAvaliacao(avaliacao);
        if (id > 0){
            return "redirect:/autoavaliacao/listar-avaliacoes";
        }
        return "redirect:/not-found";
    }

    @PostMapping("/criar-questionario")
    public String criarQuestionario(final QuestionarioModel questionario, HttpSession session, final Model model){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        questionario.setInstituicaoId(usuario.getInstituicaoId());

        final int id = createQuestionario.createQuestionario(questionario);
        if (id >= 0){
            return "redirect:/autoavaliacao/listar-questionarios";
        }
        return "redirect:/not-found";
    }

    @PostMapping("/criar-grupo")
    public String criarGrupo(final GrupoDePerguntasModel grupo, HttpSession session, final Model model){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        final int id = createGrupo.createGrupo(grupo);
        if (id > 0){
            return "redirect:/autoavaliacao/listar-grupos";
        }
        return "redirect:/not-found";
    }

    @PostMapping("/criar-pergunta")
    public String criarPergunta(final PerguntaModel pergunta, HttpSession session, final Model model){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        final int id = createPergunta.createPergunta(pergunta);
        if (id > 0){
            return "redirect:/autoavaliacao/listar-perguntas";
        }
        return "redirect:/not-found";
    }

    @PostMapping("vincular-avaliacao")
    public String vincularAvaliacao(final int edicaoId, final int avaliacaoId){
        AvaliacaoModel avaliacao =  new AvaliacaoModel();
        avaliacao.setEdicaoId(edicaoId);
        avaliacao.setId(avaliacaoId);
        final boolean resultado = updateAvaliacao.vincularAvaliacao(avaliacao);
        if (!resultado){
            return "redirect:/autoavaliacao/vincular-avaliacao/" + edicaoId;
        }
        return "redirect:/not-found";
    }
}
