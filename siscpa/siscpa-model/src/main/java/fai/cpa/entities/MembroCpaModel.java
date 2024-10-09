package fai.cpa.entities;

public class MembroCpaModel {

    private int id;

    private String nomeMembro;

    private String cargo;

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

    public String getNomeMembro() {
        return nomeMembro;
    }

    public void setNomeMembro(String nomeMembro) {
        this.nomeMembro = nomeMembro;
    }
}
