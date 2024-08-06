package fai.cpa.entities;

public class InstituicaoModel {

    private int id;
    private String email;
    private String documento;
    private String razao_social;
    private String nome_fantasia;
    private int telefone;
    private String tipo;
    private String instituicaoLogradouro;
    private int instituicaoNumero;
    private String instituicaoBairro;
    private int instituicaoCep;
    private String responsavelNome;
    private String resposavelEmail;
    private int responsavelTelefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInstituicaoLogradouro() {
        return instituicaoLogradouro;
    }

    public void setInstituicaoLogradouro(String instituicaoLogradouro) {
        this.instituicaoLogradouro = instituicaoLogradouro;
    }

    public int getInstituicaoNumero() {
        return instituicaoNumero;
    }

    public void setInstituicaoNumero(int instituicaoNumero) {
        this.instituicaoNumero = instituicaoNumero;
    }

    public String getInstituicaoBairro() {
        return instituicaoBairro;
    }

    public void setInstituicaoBairro(String instituicaoBairro) {
        this.instituicaoBairro = instituicaoBairro;
    }

    public int getInstituicaoCep() {
        return instituicaoCep;
    }

    public void setInstituicaoCep(int instituicaoCep) {
        this.instituicaoCep = instituicaoCep;
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
