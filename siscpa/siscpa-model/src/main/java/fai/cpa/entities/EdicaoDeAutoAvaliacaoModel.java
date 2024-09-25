package fai.cpa.entities;

import java.time.LocalDate;

public class EdicaoDeAutoAvaliacaoModel {

    private int id;
    private int edicao;
    private String anoDaAvaliacao;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int instituicao_id;

    public int getInstituicao_id() {
        return instituicao_id;
    }

    public void setInstituicao_id(int instituicao_id) {
        this.instituicao_id = instituicao_id;
    }

    public String getAnoDaAvaliacao() {
        return anoDaAvaliacao;
    }

    public void setAnoDaAvaliacao(String anoDaAvaliacao) {
        this.anoDaAvaliacao = anoDaAvaliacao;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}


