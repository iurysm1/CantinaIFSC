
package model.bo;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Venda implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private Timestamp datahoravenda;
    
    @Column
    private String observacao;
    
    @Column
    private float valordesconto;
    
    @Column
    private String flagtipodesconto;
    
    @Column
    private String status;
    
    
    @JoinColumn
    @ManyToOne
    private Funcionario funcionario;
    
    @JoinColumn
    @ManyToOne
    private Carteirinha carteirinha;

    public Venda() {
    }

    public Venda(int id, Timestamp datahoravenda, String obeservacao, float valordesconto, String flagtipodesconto, String status, Funcionario funcionario, Carteirinha carteirinha) {
        this.id = id;
        this.datahoravenda = datahoravenda;
        this.observacao = obeservacao;
        this.valordesconto = valordesconto;
        this.flagtipodesconto = flagtipodesconto;
        this.status = status;
        this.funcionario = funcionario;
        this.carteirinha=carteirinha;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDatahoravenda() {
        return datahoravenda;
    }

    public void setDatahoravenda(Timestamp datahoravenda) {
        this.datahoravenda = datahoravenda;
    }

    public String getObeservacao() {
        return observacao;
    }

    public void setObeservacao(String obeservacao) {
        this.observacao = obeservacao;
    }

    public float getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(float valordesconto) {
        this.valordesconto = valordesconto;
    }

    public String getFlagtipodesconto() {
        return flagtipodesconto;
    }

    public void setFlagtipodesconto(String flagtipodesconto) {
        this.flagtipodesconto = flagtipodesconto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Carteirinha getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(Carteirinha carteirinha) {
        this.carteirinha = carteirinha;
    }

    

    @Override
    public String toString() {
        return "id=" + this.getId() + ", datahoravenda=" + this.getDatahoravenda() + ", obeservacao=" + this.getObeservacao() + ", valordesconto=" + this.getValordesconto() + ", flagtipodesconto=" + this.getFlagtipodesconto() + ", status=" + this.getStatus() + ", funcionário=" + this.getFuncionario()+", carteirinha="+this.getCarteirinha();
    }
    
     
}
