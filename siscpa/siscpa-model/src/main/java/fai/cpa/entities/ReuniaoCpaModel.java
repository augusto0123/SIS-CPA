package fai.cpa.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReuniaoCpaModel {

    private int id;
        private LocalDate dataReuniao;
        private LocalTime horario;
    private String pauta;

    private int membroCpaId;

    public int getMembroCpaId() {
        return membroCpaId;
    }

    public void setMembroCpaId(int membroCpaId) {
        this.membroCpaId = membroCpaId;
    }

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

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }
}
