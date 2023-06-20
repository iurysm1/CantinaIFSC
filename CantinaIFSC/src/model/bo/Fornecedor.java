
package model.bo;

public class Fornecedor extends Pessoa{
    
    private String cnpj;
    private String inscricaoestadual;
    


    public Fornecedor(String cnpj, String inscricaoestadual, int id, String nome, String fone1, String fone2, String email, char status, String complementoEndereco, Endereco endereco) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco, endereco);
        this.cnpj = cnpj;
        this.inscricaoestadual = inscricaoestadual;
        
 
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

    
    @Override
    public String toString() {
        return "cnpj=" + this.getCnpj() + ", inscricaoestadual=" + this.getInscricaoestadual() +", endereco="+this.getEndereco();
    }
    
    
    
    
    
}
