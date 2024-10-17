package fai.cpa.controller;

import fai.cpa.entities.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("galeria")
public class GaleriaController {

    @GetMapping("galeria")
    public String getGaleriaPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "galeria/galeria";
    }
}
