package autoavaliacao;

import fai.cpa.entities.GrupoDePerguntasDoQuestionarioModel;
import port.GrupoDoQuestionarioRepository;

public class CreateGrupoDoQuestionario {

    private final GrupoDoQuestionarioRepository grupoDoQuestionarioRepository;

    public CreateGrupoDoQuestionario(GrupoDoQuestionarioRepository grupoDoQuestionarioRepository) {
        this.grupoDoQuestionarioRepository = grupoDoQuestionarioRepository;
    }

    public int createGrupoDoQuestionario(final GrupoDePerguntasDoQuestionarioModel grupoDePerguntasDoQuestionarioModel){
        if (grupoDePerguntasDoQuestionarioModel == null){
            return -1;
        }
        if(grupoDePerguntasDoQuestionarioModel.getOrdemDosGrupos() < 1){
            return -1;
        }
        return grupoDoQuestionarioRepository.create(grupoDePerguntasDoQuestionarioModel);
    }
}
