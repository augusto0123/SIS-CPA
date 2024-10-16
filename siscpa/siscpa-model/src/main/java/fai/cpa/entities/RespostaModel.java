package fai.cpa.entities;

public class RespostaModel {

    private int id;
    private int perguntaId;
    private int usuarioId;
    private int avaliacaoQuestionarioId;
    private String respostaObjetiva;
    private String respostaSubjetiva;

    private int instituicaoId;

//    Getters and Setters

    public int getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(int instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getAvaliacaoQuestionarioId() {
        return avaliacaoQuestionarioId;
    }

    public void setAvaliacaoQuestionarioId(int avaliacaoQuestionarioId) {
        this.avaliacaoQuestionarioId = avaliacaoQuestionarioId;
    }

    public String getRespostaObjetiva() {
        return respostaObjetiva;
    }

    public void setRespostaObjetiva(String respostaObjetiva) {
        this.respostaObjetiva = respostaObjetiva;
    }

    public String getRespostaSubjetiva() {
        return respostaSubjetiva;
    }

    public void setRespostaSubjetiva(String respostaSubjetiva) {
        this.respostaSubjetiva = respostaSubjetiva;
    }
}
