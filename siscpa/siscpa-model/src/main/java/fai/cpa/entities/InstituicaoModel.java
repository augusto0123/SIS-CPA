package fai.cpa.entities;

public class InstituicaoModel {

    private int id;
    private String email;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String telefone;
    private String responsavelNome;
    private String resposavelEmail;
    private String responsavelTelefone;
    private String situacao;
    private int usuarioId;
    private int endereco_id;


    public int getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(int endereco_id) {
        this.endereco_id = endereco_id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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

    public String getResponsavelTelefone() {
        return responsavelTelefone;
    }

    public void setResponsavelTelefone(String responsavelTelefone) {
        this.responsavelTelefone = responsavelTelefone;
    }
}
