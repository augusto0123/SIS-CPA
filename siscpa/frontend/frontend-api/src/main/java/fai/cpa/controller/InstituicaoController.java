package fai.cpa.controller;

import fai.cpa.entities.InstituicaoModel;
import fai.cpa.instituicao.ShowAllInstituicoes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/instituicao")
public class InstituicaoController {
    private final ShowAllInstituicoes showAllInstituicoes;

    public InstituicaoController(ShowAllInstituicoes showAllInstituicoes) {
        this.showAllInstituicoes = showAllInstituicoes;
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
        return "instituicao/listar-usuarios";
    }
}
