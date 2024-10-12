package fai.cpa.entities;

public class GrupoDePerguntasDoQuestionarioModel {

    private int id;
    private int questionarioId;
    private int grupoDePerguntaId;

    private int ordemDosGrupos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionarioId() {
        return questionarioId;
    }

    public void setQuestionarioId(int questionarioId) {
        this.questionarioId = questionarioId;
    }

    public int getGrupoDePerguntaId() {
        return grupoDePerguntaId;
    }

    public void setGrupoDePerguntaId(int grupoDePerguntaId) {
        this.grupoDePerguntaId = grupoDePerguntaId;
    }


    public int getOrdemDosGrupos() {
        return ordemDosGrupos;
    }

    public void setOrdemDosGrupos(int ordemDosGrupos) {
        this.ordemDosGrupos = ordemDosGrupos;
    }
}
