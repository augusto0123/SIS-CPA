package fai.cpa.entities;

public class QuestionarioModel {

    private int id;
    private String descricao;
    private String categoria;

    private String avaliacaoId;

    private int instituicaoId;

//    Getters and Setters

    public int getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(int instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public String getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(String avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
