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

    @GetMapping("/grafico")
    public String getGraficoPage(){
        return "relatorio/grafico";
    }
}
