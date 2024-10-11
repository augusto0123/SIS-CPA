package fai.cpa.controller;

import fai.cpa.conta.ShowAllUsuarios;
import fai.cpa.entities.InstituicaoModel;
import fai.cpa.entities.UsuarioModel;
import fai.cpa.instituicao.CreateInstituicao;
import fai.cpa.instituicao.ShowAllInstituicoes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/instituicao")
public class InstituicaoController {
    private final ShowAllInstituicoes showAllInstituicoes;
    private final CreateInstituicao createInstituicao;

    private final ShowAllUsuarios showAllUsuarios;

    public InstituicaoController(ShowAllInstituicoes showAllInstituicoes, CreateInstituicao createInstituicao, ShowAllUsuarios showAllUsuarios) {
        this.showAllInstituicoes = showAllInstituicoes;
        this.createInstituicao = createInstituicao;
        this.showAllUsuarios = showAllUsuarios;
    }

    @GetMapping("/inicio")
    public String getInicioPage(){
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
        return "instituicao/adicionar-membro";
    }

    @GetMapping("/listar-membro")
    public String getListarMembroPage(final Model model){
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

    @PostMapping("/criar-instituicao")
    public String criarInstituicao(final InstituicaoModel instituicao){
        final int id = createInstituicao.createInstituicao(instituicao);
        if (id > 0){
            return "redirect:/instituicao/listar-instituicao";
        }
        return "redirect:/not-found";
    }

}
