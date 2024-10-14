package fai.cpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    @GetMapping("/relatorio")
    public String getRelatorioPage(){
        return "relatorio/relatorio";
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
