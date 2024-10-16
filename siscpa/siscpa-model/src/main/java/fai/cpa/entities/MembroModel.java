package fai.cpa.entities;

public class MembroModel {

    private int id;

    private String cargo;

    private int usuarioId;

    private int instituicaoId;

//    Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(int instituicaoId) {
        this.instituicaoId = instituicaoId;
    }
}
