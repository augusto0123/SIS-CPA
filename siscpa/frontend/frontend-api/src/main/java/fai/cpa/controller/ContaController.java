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
@RequestMapping("/conta")
public class ContaController {

    private final ShowAllInstituicoes showAllInstituicoes;

    public ContaController(ShowAllInstituicoes showAllInstituicoes) {
        this.showAllInstituicoes = showAllInstituicoes;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "conta/login";
    }

    @GetMapping("/perfil")
    public String getPerfilPage(){
        return "conta/perfil";
    }

    @GetMapping("/registro")
    public String getRegistroPage(){
        return "conta/registro";
    }

    @GetMapping("/autenticacao")
    public String getAutenticacaoPage(){
        return "conta/autenticacao";
    }

    @GetMapping("/verificacao")
    public String getVerificacaoPage(){
        return "conta/verificacao";
    }

    @GetMapping("/vincular-instituicao")
    public String getVincularInstituicaoPage(final Model model){
        List<InstituicaoModel> instituicoes = showAllInstituicoes.showAllInstituicoes();

        if(instituicoes == null)
            instituicoes = new ArrayList<>();

        model.addAttribute("instituicoes", instituicoes);
        return "conta/vincular-instituicao";
    }

    @GetMapping("/vincular-usuario")
    public String getVincularUsuarioPage(){
        return "conta/vincular-usuario";
    }
}
