package fai.cpa.entities;

public class PerguntasDoGrupoDePerguntasModel {

    private int id;
    private int grupoDePerguntasId;
    private int perguntaId;
    private int ordemDasPerguntas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrupoDePerguntasId() {
        return grupoDePerguntasId;
    }

    public void setGrupoDePerguntasId(int grupoDePerguntasId) {
        this.grupoDePerguntasId = grupoDePerguntasId;
    }

    public int getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }

    public int getOrdemDasPerguntas() {
        return ordemDasPerguntas;
    }

    public void setOrdemDasPerguntas(int ordemDasPerguntas) {
        this.ordemDasPerguntas = ordemDasPerguntas;
    }
}
