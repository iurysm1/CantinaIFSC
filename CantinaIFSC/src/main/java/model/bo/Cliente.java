
package model.bo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa implements Serializable{
    
    @Column
    private String cpf;
    
    @Column
    private String rg;
    
    @Column
    private String matricula;
    
    @Column
    private Date dataNascimento;
    
    

    public Cliente() {
    }

    public Cliente(String cpf, String rg, String matricula, Date dataNascimento, int id, String nome, String fone1, String fone2, String email, String status, String complementoEndereco, Endereco endereco) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
   
        
    }



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

 
    


    @Override
    public String toString() {
        return "cpf=" + this.getCpf() + ", rg=" + this.getRg() + ", matricula=" + this.getMatricula() + ", dataNascimento=" + this.getDataNascimento()+", Endereco="+this.getEndereco();
    }
    
    
}
