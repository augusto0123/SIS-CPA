package fai.cpa.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReuniaoCpaModel {

    private int id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataReuniao;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horario;
    private String pauta;
    private int membroCpaId;

    private int instituicaoId;

    public int getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(int instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

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
