package fai.cpa.controller;

import fai.cpa.entities.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/documentos")
public class DocumentosController {

    @GetMapping("/legislacao")
    public String getDocumentosPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        return "documentos/legislacao";
    }

    @GetMapping("/cronograma")
    public String getCronogramaPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "documentos/cronograma";
    }

    @GetMapping("/comunicacao")
    public String getComunicacaoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "documentos/comunicacao";
    }

    @GetMapping("/regulamentacao")
    public String getRegulamentacaoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "documentos/regulamentacao";
    }

    @GetMapping("/legislacao-membro")
    public String getLegislacaoMembroPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "documentos/legislacao-membro";
    }

    @GetMapping("/regulamentacao-membro")
    public String getRegulamentacaoMembroPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "documentos/regulamentacao-membro";
    }

    @GetMapping("/cronograma-membro")
    public String getCronogramaMembroPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "documentos/cronograma-membro";
    }

    @GetMapping("/comunicacao-membro")
    public String getComunicacaoMembroPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "documentos/comunicacao-membro";
    }
}
