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
import fai.cpa.instituicao.UpdateFoto;
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

    private final UpdateFoto updateFoto;


    public InstituicaoController(ShowAllInstituicoes showAllInstituicoes, CreateInstituicao createInstituicao, ShowAllUsuarios showAllUsuarios, ShowAllEdicoes showAllEdicoes, ShowAllReunioes showAllReunioes, ShowLastReuniao showLastReuniao, UpdateFoto updateFoto) {
        this.showAllInstituicoes = showAllInstituicoes;
        this.createInstituicao = createInstituicao;
        this.showAllUsuarios = showAllUsuarios;
        this.showAllEdicoes = showAllEdicoes;
        this.showAllReunioes = showAllReunioes;
        this.showLastReuniao = showLastReuniao;
        this.updateFoto = updateFoto;
    }

    @GetMapping("/inicio")
    public String getInicioPage(final Model model, final HttpSession session){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");

        List<EdicaoDeAutoAvaliacaoModel> edicoes = showAllEdicoes.showAllEdicoesByInstituicaoId(usuario.getInstituicaoId());
        List<ReuniaoCpaModel> reunioes = showAllReunioes.showAllReunioesByInstituicaoId(usuario.getInstituicaoId());
        InstituicaoModel instituicao = showAllInstituicoes.findById(usuario.getInstituicaoId());
        ReuniaoCpaModel ultimaReuniao = showAllReunioes.showReuniaoComMaiorId();

        if(edicoes == null){
            edicoes = new ArrayList<>();
        }

        if (reunioes == null){
            reunioes = new ArrayList<>();
        }

        if (ultimaReuniao == null){
            ultimaReuniao = new ReuniaoCpaModel();
        }

//        model.addAttribute("instituicaoId", instituicaoId);
        model.addAttribute("edicoes", edicoes);
        model.addAttribute("reunioes", reunioes);
        model.addAttribute("usuario", usuario);
        model.addAttribute("instituicao", instituicao);
        model.addAttribute("ultimaReuniao", ultimaReuniao);

        return "instituicao/inicio";
    }

    @GetMapping("/listar-instituicao")
    public String getListarInstituicaoesPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        List<InstituicaoModel> instituicoes = showAllInstituicoes.showAllInstituicoes();

        if(instituicoes == null)
            instituicoes = new ArrayList<>();

        model.addAttribute("usuario", usuario);
        model.addAttribute("instituicoes", instituicoes);

        return "instituicao/listar-instituicao";
    }

    @GetMapping("/adicionar-instituicao")
    public String getAdicionarInstituicaoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");

        model.addAttribute("usuario", usuario);
        model.addAttribute("instituicao", new InstituicaoModel());

        return "instituicao/adicionar-instituicao";
    }

    @GetMapping("/adicionar-membro/{id}")
    public String getAdicioarMembroPage(@PathVariable int id, final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");

        List<UsuarioModel> usuarios = showAllUsuarios.findByTipoAndInstituicaoId("Professor", id);

        if (usuarios == null){
            usuarios = new ArrayList<>();
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("usuarios", usuarios);

        return "instituicao/adicionar-membro";
    }

    @GetMapping("/listar-membro/{id}")
    public String getListarMembroPage(@PathVariable int id, final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");

        List<UsuarioModel> usuariosMembros = showAllUsuarios.findByTipoAndInstituicaoId("Membro CPA", id);

        if (usuariosMembros == null){
            usuariosMembros = new ArrayList<>();
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("usuarios", usuariosMembros);

        return "instituicao/listar-membro";
    }

    @GetMapping ("/listar-usuarios/{id}")
    public String getListarUsuarioPage(@PathVariable final int id, final Model model, HttpSession session){

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        List<UsuarioModel> usuarios = showAllUsuarios.findAllByInstituicaoId(id);

        if (usuarios == null)
            usuarios = new ArrayList<>();

        model.addAttribute("instituicaoId", id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("usuarios",usuarios);

        return "instituicao/listar-usuarios";
    }

    @GetMapping("/menu-instituicao/{id}")
    public String getMenuInstituicaoPage(@PathVariable int id, final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");

        model.addAttribute("instituicaoId", id);
        model.addAttribute("usuario", usuario);
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
    public String criarInstituicao(final InstituicaoModel instituicao,final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        final int id = createInstituicao.createInstituicao(instituicao);
        if (id > 0){
            return "redirect:/instituicao/listar-instituicao";
        }
        model.addAttribute("usuario", usuario);
        return "redirect:/not-found";
    }

    @PostMapping("/criar-membro")
    public String criarMembro(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");

        model.addAttribute("usuario", usuario);
        return "redirect:/instituicao/listar-membro";
    }

    @PostMapping("/update-foto")
    public String updateFoto(final String base64Output, HttpSession session, final Model model){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        final boolean update = updateFoto.updateFoto(usuario.getInstituicaoId(), base64Output);

        if (!update){
            return "redirect:/instituicao/inicio";
        }

        return "redirect:/not-found";
    }
}
