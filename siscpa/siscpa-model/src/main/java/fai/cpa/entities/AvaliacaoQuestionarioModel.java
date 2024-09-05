package fai.cpa.entities;

import java.time.LocalDate;

public class AvaliacaoQuestionarioModel {
    private int id;
    private int edicao;
    private int anoDaAvaliacao;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public int getId() {
        return id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
