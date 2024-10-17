package fai.cpa.controller;

import fai.cpa.entities.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommonController {

    @GetMapping("/")
    public String getHomePage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "index";
    }

    @GetMapping("/not-found")
    public String getNotFound(){
        return "/conta/not-found";
    }
}
