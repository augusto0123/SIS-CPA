package fai.cpa.entities;

public class EdicaoDeAutoAvaliacaoModel {

    private int id;
    private int edicao;
    private int anoDaAvaliacao;
    private String descicao;
    private int dataInicio;
    private int dataFim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAnoDaAvaliacao() {
        return anoDaAvaliacao;
    }

    public void setAnoDaAvaliacao(int anoDaAvaliacao) {
        this.anoDaAvaliacao = anoDaAvaliacao;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public int getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(int dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDataFim() {
        return dataFim;
    }

    public void setDataFim(int dataFim) {
        this.dataFim = dataFim;
    }
}
