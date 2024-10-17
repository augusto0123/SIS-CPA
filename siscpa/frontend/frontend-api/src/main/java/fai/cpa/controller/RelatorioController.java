package fai.cpa.controller;

import fai.cpa.autoavaliacao.ShowAllEdicoes;
import fai.cpa.entities.EdicaoDeAutoAvaliacaoModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getRelatorioPage(final Model model){
        List<EdicaoDeAutoAvaliacaoModel> edicoes = showAllEdicoes.showAllEdicoes();

        if (edicoes == null)
            edicoes = new ArrayList<>();

        model.addAttribute("edicoes", edicoes);

        return "relatorio/relatorios";
    }

    @GetMapping("/relatorios-edicao")
    public String getRelatoriosEdicaoPage(){
        return "relatorio/relatorios-edicao";
    }

    @GetMapping("/grafico-edicao")
    public String getGraficoEdicaoPage(){
        return "relatorio/grafico-edicao";
    }

    @GetMapping("/grafico-avaliacao")
    public String getGraficoAvaliacaoPage(){
        return "relatorio/grafico-avaliacao";
    }

    @GetMapping("/grafico-questionario")
    public String getGraficoQuestionarioPage(){
        return "relatorio/grafico-questionario";
    }

    @GetMapping("/grafico-grupo")
    public String getGraficoGrupoPage(){
        return "relatorio/grafico-grupo";
    }
}
