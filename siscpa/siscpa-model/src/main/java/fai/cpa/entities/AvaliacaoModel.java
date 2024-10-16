package fai.cpa.entities;

import java.time.LocalDate;

public class AvaliacaoModel {

    private int id;

    private String descricao;
    private String tema;

    private int edicaoId;

    private int instituicaoId;

//    Getters and Setters

    public int getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(int instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public int getEdicaoId() {
        return edicaoId;
    }

    public void setEdicaoId(int edicaoId) {
        this.edicaoId = edicaoId;
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
