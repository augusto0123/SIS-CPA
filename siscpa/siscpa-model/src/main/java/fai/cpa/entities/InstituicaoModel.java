package fai.cpa.entities;

public class InstituicaoModel {

    private int id;
    private String email;
    private String cnpj;
    private String razao_social;
    private String nome_fantasia;
    private int telefone;
    private String responsavelNome;
    private String resposavelEmail;
    private int responsavelTelefone;
    private String situacao;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getResponsavelNome() {
        return responsavelNome;
    }

    public void setResponsavelNome(String responsavelNome) {
        this.responsavelNome = responsavelNome;
    }

    public String getResposavelEmail() {
        return resposavelEmail;
    }

    public void setResposavelEmail(String resposavelEmail) {
        this.resposavelEmail = resposavelEmail;
    }

    public int getResponsavelTelefone() {
        return responsavelTelefone;
    }

    public void setResponsavelTelefone(int responsavelTelefone) {
        this.responsavelTelefone = responsavelTelefone;
    }
}
