package fai.cpa.controller;

import fai.cpa.conta.CreateUsuario;
import fai.cpa.conta.ShowAllUsuarios;
import fai.cpa.conta.UpdateUsuario;
import fai.cpa.entities.InstituicaoModel;
import fai.cpa.entities.UsuarioModel;
import fai.cpa.instituicao.ShowAllInstituicoes;
import fai.cpa.port.impl.AutenticationProvider;
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
@RequestMapping("/conta")
public class ContaController {

    private final ShowAllInstituicoes showAllInstituicoes;
    private final CreateUsuario createUsuario;

    private final ShowAllUsuarios showAllUsuarios;

    private final AutenticationProvider autenticationProvider;

    private final UpdateUsuario updateUsuario;

    public ContaController(ShowAllInstituicoes showAllInstituicoes, CreateUsuario createUsuario, ShowAllUsuarios showAllUsuarios, AutenticationProvider autenticationProvider, UpdateUsuario updateUsuario) {
        this.showAllInstituicoes = showAllInstituicoes;
        this.createUsuario = createUsuario;
        this.showAllUsuarios = showAllUsuarios;
        this.autenticationProvider = autenticationProvider;
        this.updateUsuario = updateUsuario;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "conta/login";
    }

    @GetMapping("/perfil")
    public String getPerfilPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        InstituicaoModel instituicao = showAllInstituicoes.findById(usuario.getInstituicaoId());

        model.addAttribute("instituicao", instituicao);
        model.addAttribute("usuario", usuario);
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
    public String getVincularInstituicaoPage(final Model model, HttpSession session){
        List<InstituicaoModel> instituicoes = showAllInstituicoes.showAllInstituicoes();

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        if(instituicoes == null)
            instituicoes = new ArrayList<>();

        model.addAttribute("instituicoes", instituicoes);
        return "conta/vincular-instituicao";
    }

    @GetMapping("/vincular-usuario/{id}")
    public String getVincularUsuarioPage(@PathVariable final int id, final Model model, HttpSession session){

        model.addAttribute("instituicaoId", id);

        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

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

            if (usuario.getInstituicaoId() == null || usuario.getTipo() == null) {
                return "redirect:/not-found";
            }

            if ("Administrador".equals(usuario.getTipo())) {
                return "redirect:/instituicao/listar-instituicao";
            }
            return "redirect:/instituicao/inicio";
        }
        return "redirect:/not-found";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/vincular-usuario")
    public String vincularUsuario(final HttpSession session, final int instituicaoId, final String tipo) {
        final UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");

        usuario.setInstituicaoId(instituicaoId);
        usuario.setTipo(tipo);

        final boolean updateUsuario = this.updateUsuario.updateUsuario(usuario);

        if (updateUsuario) {
            session.setAttribute("usuarioAtual", usuario);
            return "redirect:/instituicao/inicio";
        }
        return "redirect:/not-found";
    }
}
