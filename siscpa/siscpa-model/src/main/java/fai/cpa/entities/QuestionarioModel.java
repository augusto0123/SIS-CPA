package fai.cpa.entities;

public class QuestionarioModel {

    private int id;
    private String descricao;
    private Categoria categoria;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public enum Categoria {
        ALUNO,
        PROFESSOR,
        COLABORADOR,
        COMUNIDADE_EXTERNA
    }


}
