package fai.cpa.controller;

import fai.cpa.conta.CreateUsuario;
import fai.cpa.conta.ShowAllUsuarios;
import fai.cpa.entities.InstituicaoModel;
import fai.cpa.entities.UsuarioModel;
import fai.cpa.instituicao.ShowAllInstituicoes;
import fai.cpa.port.impl.AutenticationProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/conta")
public class ContaController {

    private final ShowAllInstituicoes showAllInstituicoes;
    private final CreateUsuario createUsuario;

    private final ShowAllUsuarios showAllUsuarios;

    private final AutenticationProvider autenticationProvider;

    public ContaController(ShowAllInstituicoes showAllInstituicoes, CreateUsuario createUsuario, ShowAllUsuarios showAllUsuarios, AutenticationProvider autenticationProvider) {
        this.showAllInstituicoes = showAllInstituicoes;
        this.createUsuario = createUsuario;
        this.showAllUsuarios = showAllUsuarios;
        this.autenticationProvider = autenticationProvider;
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

    @PostMapping("/criar-usuario")
    public String criarUsuario(final UsuarioModel usuario, HttpSession session){
        final int id = createUsuario.createUsuario(usuario);
        UsuarioModel usuarioModel = showAllUsuarios.findById(id);
        if (id > 0){
            session.setAttribute("usuarioAtual",usuarioModel);
            return "redirect:/conta/vincular-instituicao";
        }
        return "redirect:/not-found";
    }

    @PostMapping("/login")
    public String login(final String email, final String senha, HttpSession session){
        final UsuarioModel usuario = createUsuario.login(email, senha);
        if (usuario != null){
            session.setAttribute("usuarioAtual",usuario);
            return "redirect:/instituicao/inicio";
        }
        return "redirect:/not-found";
    }
}
