package fai.cpa.controller;

import fai.cpa.autoavaliacao.ShowAllEdicoes;
import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import fai.cpa.entities.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    private final ShowAllEdicoes showAllEdicoes;

    public RelatorioController(ShowAllEdicoes showAllEdicoes) {
        this.showAllEdicoes = showAllEdicoes;
    }


    @GetMapping("/relatorios")
    public String getRelatorioPage(final Model model, HttpSession session){
        List<EdicaoDeAutoAvaliacaoModel> edicoes = showAllEdicoes.showAllEdicoes();
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);

        if (edicoes == null)
            edicoes = new ArrayList<>();

        model.addAttribute("edicoes", edicoes);

        return "relatorio/relatorios";
    }

    @GetMapping("/relatorios-edicao")
    public String getRelatoriosEdicaoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "relatorio/relatorios-edicao";
    }

    @GetMapping("/grafico-edicao")
    public String getGraficoEdicaoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "relatorio/grafico-edicao";
    }

    @GetMapping("/grafico-avaliacao")
    public String getGraficoAvaliacaoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "relatorio/grafico-avaliacao";
    }

    @GetMapping("/grafico-questionario")
    public String getGraficoQuestionarioPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "relatorio/grafico-questionario";
    }

    @GetMapping("/grafico-grupo")
    public String getGraficoGrupoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        model.addAttribute("usuario", usuario);
        return "relatorio/grafico-grupo";
    }
}
