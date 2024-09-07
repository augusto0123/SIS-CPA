package fai.cpa.entities;

import java.time.LocalDate;

public class ReuniaoCpaModel {

    private int id;
    private LocalDate dataReuniao;
    private LocalDate horario;
    private String pauta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataReuniao() {
        return dataReuniao;
    }
    public void setDataReuniao(LocalDate dataReuniao) {
        this.dataReuniao = dataReuniao;
    }

    public LocalDate getHorario() {
        return horario;
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }
}
