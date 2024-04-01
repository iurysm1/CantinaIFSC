 
package model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Carteirinha {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String codigobarra;
    
    @Column
    private String datageracao;
    
    @Column
    private String datacancelamento;
    
    @Column
    private Cliente cliente;
    
    @Column
    private String status;
   

    public Carteirinha() {
    }

    public Carteirinha(int id, String codigobarra, String datageracao, String datacancelamento, Cliente cliente, String status) {
        this.id = id;
        this.codigobarra = codigobarra;
        this.datageracao = datageracao;
        this.datacancelamento = datacancelamento;
        this.status=status;
        this.cliente=cliente;
    }
    

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public String getDatageracao() {
        return datageracao;
    }

    public void setDatageracao(String datageracao) {
        this.datageracao = datageracao;
    }

    public String getDatacancelamento() {
        return datacancelamento;
    }

    public void setDatacancelamento(String datacancelamento) {
        this.datacancelamento = datacancelamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
 

    @Override
    public String toString() {
        return "id=" + this.getId() + ", codigobarra=" + this.getCodigobarra() + ", datageracao=" + this.getDatageracao() + ", datacancelamento=" + this.getDatacancelamento();
    }
    
    
}
