package fai.cpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documentos")
public class DocumentosController {

    @GetMapping("/documentos")
    public String getDocumentosPage(){
        return "documentos/documentos";
    }

    @GetMapping("/cronograma")
    public String getCronogramaPage(){
        return "documentos/cronograma";
    }

    @GetMapping("/comunicacao")
    public String getComunicacaoPage(){
        return "documentos/comunicacao";
    }
}
