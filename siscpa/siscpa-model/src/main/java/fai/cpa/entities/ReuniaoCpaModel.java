package fai.cpa.entities;

public class ReuniaoCpaModel {

    private int id;
    private int dataReuniao;
    private int horario;
    private String pauta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(int dataReuniao) {
        this.dataReuniao = dataReuniao;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }
}
