package fai.cpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documentos")
public class DocumentosController {

    @GetMapping("/legislacao")
    public String getDocumentosPage(){
        return "documentos/legislacao";
    }

    @GetMapping("/cronograma")
    public String getCronogramaPage(){
        return "documentos/cronograma";
    }

    @GetMapping("/comunicacao")
    public String getComunicacaoPage(){
        return "documentos/comunicacao";
    }

    @GetMapping("/regulamentacao")
    public String getRegulamentacaoPage(){
        return "documentos/regulamentacao";
    }

    @GetMapping("/legislacao-membro")
    public String getLegislacaoMembroPage(){
        return "documentos/legislacao-membro";
    }

    @GetMapping("/regulamentacao-membro")
    public String getRegulamentacaoMembroPage(){
        return "documentos/regulamentacao-membro";
    }

    @GetMapping("/cronograma-membro")
    public String getCronogramaMembroPage(){
        return "documentos/cronograma-membro";
    }

    @GetMapping("/comunicacao-membro")
    public String getComunicacaoMembroPage(){
        return "documentos/comunicacao-membro";
    }
}
