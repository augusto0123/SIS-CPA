package fai.cpa.entities;

public class AvaliacaoModel {

    private int id;
    private int data_inicio;
    private int data_fim;
    private String status;
    private String descricao;
    private String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(int data_inicio) {
        this.data_inicio = data_inicio;
    }

    public int getData_fim() {
        return data_fim;
    }

    public void setData_fim(int data_fim) {
        this.data_fim = data_fim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
