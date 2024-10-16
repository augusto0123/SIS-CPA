package fai.cpa.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class EdicaoDeAutoAvaliacaoModel {

    private int id;
    private int edicao;
    private String anoDaAvaliacao;
    private String descricao;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFim;

    private String situacao;

    private int instituicaoId;


//    Getters and Setters

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(int instituicaoId) {
        this.instituicaoId = instituicaoId;
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



