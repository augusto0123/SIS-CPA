package fai.cpa.controller;

import fai.cpa.autoavaliacao.*;
import fai.cpa.entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    private final ShowAllEdicoes showAllEdicoes;
    private final ShowAllAvaliacoes showAllAvaliacoes;
    private final ShowAllGraficos showAllGraficos;

    private final ShowAllRespostas showAllRespostas;

    private final ShowAllPerguntas showAllPerguntas;

    public RelatorioController(ShowAllEdicoes showAllEdicoes, ShowAllAvaliacoes showAllAvaliacoes, ShowAllGraficos showAllGraficos, ShowAllRespostas showAllRespostas, ShowAllPerguntas showAllPerguntas) {
        this.showAllEdicoes = showAllEdicoes;
        this.showAllAvaliacoes = showAllAvaliacoes;
        this.showAllGraficos = showAllGraficos;
        this.showAllRespostas = showAllRespostas;
        this.showAllPerguntas = showAllPerguntas;
    }

//    Relatórios

    @GetMapping("/relatorios")
    public String getRelatorioPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        List<EdicaoDeAutoAvaliacaoModel> edicoes = showAllEdicoes.showAllEdicoesByInstituicaoId(usuario.getInstituicaoId());
        model.addAttribute("usuario", usuario);

        if (edicoes == null)
            edicoes = new ArrayList<>();

        model.addAttribute("edicoes", edicoes);

        return "relatorio/relatorios";
    }

    @GetMapping("/relatorios-edicao/{id}")
    public String getRelatoriosEdicaoPage(@PathVariable int id, final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        List<AvaliacaoModel> avaliacoes = showAllAvaliacoes.showAllAvaliacoesByEdicaoId(id);

        model.addAttribute("usuario", usuario);
        model.addAttribute("avaliacoes", avaliacoes);
        return "relatorio/relatorios-edicao";
    }

    @GetMapping("/relatorios-avaliacao/{id}")
    public String getRelatoriosAvaliacaoPage(@PathVariable int id, final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        List<RespostaModel> respostas = showAllRespostas.showSubjetivaByAvaliacaoId(id);

        model.addAttribute("avaliacaoId", id);
        model.addAttribute("respostas", respostas);
        model.addAttribute("usuario", usuario);
        return "relatorio/relatorios-avaliacao";
    }

//    Gráficos

    @GetMapping("/grafico-edicao")
    public String getGraficoEdicaoPage(final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        List<EdicaoDeAutoAvaliacaoModel> edicoes = showAllEdicoes.showAllEdicoesByInstituicaoId(usuario.getInstituicaoId());

        if (edicoes == null)
            edicoes = new ArrayList<>();

        model.addAttribute("usuario", usuario);
        model.addAttribute("edicoes", edicoes);

        return "relatorio/grafico-edicao";
    }

    @GetMapping("/grafico-avaliacao/{id}")
    public String getGraficoAvaliacaoPage(@PathVariable int id, final Model model, HttpSession session){
        UsuarioModel usuario = (UsuarioModel) session.getAttribute("usuarioAtual");
        List<AvaliacaoModel> avaliacoes = showAllAvaliacoes.showAllAvaliacoesByEdicaoId(id);

        model.addAttribute("edicaoId", id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("avaliacoes", avaliacoes);

        return "relatorio/grafico-avaliacao";
    }

}
