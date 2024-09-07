package fai.cpa.entities;

public class PerguntaModel {

    private int id;
    private String descricao;
    private String categoria;
    private String tipo;
    private int tipoEscala;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTipoEscala() {
        return tipoEscala;
    }

    public void setTipoEscala(int tipoEscala) {
        this.tipoEscala = tipoEscala;
    }
}
