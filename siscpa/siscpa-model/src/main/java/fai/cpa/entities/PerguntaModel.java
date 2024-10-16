package fai.cpa.entities;

public class PerguntaModel {

    private int id;
    private String descricao;
    private String tipo;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
