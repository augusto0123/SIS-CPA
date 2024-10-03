package fai.cpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("galeria")
public class GaleriaController {

    @GetMapping("galeria")
    public String getGaleriaPage(){
        return "galeria/galeria";
    }
}
