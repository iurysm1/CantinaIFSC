
package model.bo;

public class Fornecedor extends Pessoa{
    
    private String cnpj;
    private String inscricaoestadual;
    private String razaosocial;
    private Compra compra;

    public Fornecedor(String cnpj, String inscricaoestadual, String razaosocial, Compra compra, int id, String nome, String fone1, String fone2, String email, char status, String complementoEndereco, Endereco endereco) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco, endereco);
        this.cnpj = cnpj;
        this.inscricaoestadual = inscricaoestadual;
        this.razaosocial = razaosocial;
        this.compra = compra;
    }

 
    

    public Fornecedor() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }
       public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    @Override
    public String toString() {
        return "cnpj=" + this.getCnpj() + ", inscricaoestadual=" + this.getInscricaoestadual() + ", razaosocial=" + this.getRazaosocial()+", endereco="+this.getEndereco()+", IdCompra:"+this.compra.getId();
    }
    
    
    
    
    
}
