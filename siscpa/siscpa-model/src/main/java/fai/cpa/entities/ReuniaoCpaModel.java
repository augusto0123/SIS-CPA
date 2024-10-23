package fai.cpa.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReuniaoCpaModel {

    private int id;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dataReuniao;

//    @DateTimeFormat(pattern = "HH:mm")
    private String horario;
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

    public String getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(String dataReuniao) {
        this.dataReuniao = dataReuniao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }
}
