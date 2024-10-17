package fai.cpa.controller;

import fai.cpa.autoavaliacao.ShowAllEdicoes;
import fai.cpa.autoavaliacao.ShowAllReunioes;
import fai.cpa.autoavaliacao.ShowLastReuniao;
import fai.cpa.conta.ShowAllUsuarios;
import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import fai.cpa.entities.InstituicaoModel;
import fai.cpa.entities.ReuniaoCpaModel;
import fai.cpa.entities.UsuarioModel;
import fai.cpa.instituicao.CreateInstituicao;
import fai.cpa.instituicao.ShowAllInstituicoes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/instituicao")
public class InstituicaoController {
    private final ShowAllInstituicoes showAllInstituicoes;
    private final CreateInstituicao createInstituicao;
    private final ShowAllUsuarios showAllUsuarios;

    private final ShowAllEdicoes showAllEdicoes;

    private final ShowAllReunioes showAllReunioes;

    private final ShowLastReuniao showLastReuniao;


    public InstituicaoController(ShowAllInstituicoes showAllInstituicoes, CreateInstituicao createInstituicao, ShowAllUsuarios showAllUsuarios, ShowAllEdicoes showAllEdicoes, ShowAllReunioes showAllReunioes, ShowLastReuniao showLastReuniao) {
        this.showAllInstituicoes = showAllInstituicoes;
        this.createInstituicao = createInstituicao;
        this.showAllUsuarios = showAllUsuarios;
        this.showAllEdicoes = showAllEdicoes;
        this.showAllReunioes = showAllReunioes;
        this.showLastReuniao = showLastReuniao;
    }

    @GetMapping("/inicio")
    public String getInicioPage(final Model model, final HttpSession session){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");

        List<EdicaoDeAutoAvaliacaoModel> edicoes = showAllEdicoes.showAllEdicoesByInstituicaoId(usuario.getInstituicaoId());
        List<ReuniaoCpaModel> reunioes = showAllReunioes.showAllReunioesByInstituicaoId(usuario.getInstituicaoId());
//        ReuniaoCpaModel ultimaReuniao = showLastReuniao.showLastReuniao();

        if(edicoes == null
        || reunioes == null){
            edicoes = new ArrayList<>();
            reunioes = new ArrayList<>();
        }

//        model.addAttribute("instituicaoId", instituicaoId);
        model.addAttribute("edicoes", edicoes);
        model.addAttribute("reunioes", reunioes);
//        model.addAttribute("ultimaReuniao", ultimaReuniao);

        return "instituicao/inicio";
    }

    @GetMapping("/listar-instituicao")
    public String getListarInstituicaoesPage(final Model model){
        List<InstituicaoModel> instituicoes = showAllInstituicoes.showAllInstituicoes();

        if(instituicoes == null)
            instituicoes = new ArrayList<>();

        model.addAttribute("instituicoes", instituicoes);

        return "instituicao/listar-instituicao";
    }

    @GetMapping("/adicionar-instituicao")
    public String getAdicionarInstituicaoPage(final Model model){

        model.addAttribute("instituicao", new InstituicaoModel());

        return "instituicao/adicionar-instituicao";
    }

    @GetMapping("/adicionar-membro")
    public String getAdicioarMembroPage(final Model model){

        List<UsuarioModel> usuarios = showAllUsuarios.findByTipo("Professor");

        if (usuarios == null){
            usuarios = new ArrayList<>();
        }

        model.addAttribute("usuarios", usuarios);

        return "instituicao/adicionar-membro";
    }

    @GetMapping("/listar-membro")
    public String getListarMembroPage(final Model model){

        List<UsuarioModel> usuariosMembros = showAllUsuarios.findByTipo("Membro CPA");

        if (usuariosMembros == null){
            usuariosMembros = new ArrayList<>();
        }

        model.addAttribute("usuarios", usuariosMembros);

        return "instituicao/listar-membro";
    }

    @GetMapping ("/listar-usuarios")
    public String getListarUsuarioPage(final Model model){
        List<UsuarioModel> usuarios = showAllUsuarios.showAllUsuarios();

        if (usuarios == null)
            usuarios = new ArrayList<>();

        model.addAttribute("usuarios",usuarios);

        return "instituicao/listar-usuarios";
    }

    @GetMapping("/menu-instituicao")
    public String getMenuInstituicaoPage(){
        return "instituicao/menu-instituicao";
    }

    @GetMapping("/instituicoes")
    public String getInstituicoesPage(final Model model){
        List<InstituicaoModel> instituicoes = showAllInstituicoes.showAllInstituicoes();

        if(instituicoes == null)
            instituicoes = new ArrayList<>();

        model.addAttribute("instituicoes", instituicoes);

        return "instituicao/instituicoes";
    }

    @PostMapping("/criar-instituicao")
    public String criarInstituicao(final InstituicaoModel instituicao){
        final int id = createInstituicao.createInstituicao(instituicao);
        if (id > 0){
            return "redirect:/instituicao/listar-instituicao";
        }
        return "redirect:/not-found";
    }

    @PostMapping("/criar-membro")
    public String criarMembro(final Model model){



        return "redirect:/instituicao/listar-membro";
    }

}
