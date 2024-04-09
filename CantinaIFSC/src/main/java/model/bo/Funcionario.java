
package model.bo;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Funcionario extends Pessoa implements Serializable{
    
    
    @Column
    private String cpf;
    
    @Column
    private String rg;
    
    @Column
    private String usuario;
    
    @Column
    private String senha;
    
    @Column
    private Date dataNascimento;


    public Funcionario(String cpf, String rg, String usuario, String senha, Movimentacaoestoque movimentacaoEstoque, Venda venda, Caixa caixa, int id, String nome, String fone1, String fone2, String email, String status, String complementoEndereco, Endereco endereco, Date dataNascimento) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.usuario = usuario;
        this.senha = senha;
        this.dataNascimento=dataNascimento;
    }

    public Funcionario() {
        
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }



    @Override
    public String toString() {
        return "cpf=" + this.getCpf() + ", rg=" + this.getRg() + ", usuario=" + this.getUsuario() + ", senha=" + this.getSenha() +'}';
    }
    
    
}
