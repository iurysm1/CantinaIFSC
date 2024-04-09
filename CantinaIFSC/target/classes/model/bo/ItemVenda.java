package model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private int qtdproduto;
 
    @Column
    private String status;
    
    @JoinColumn
    @ManyToOne
    private Produto produto;
    
    @JoinColumn
    @ManyToOne
    private Venda venda;
    

    public ItemVenda() {
    }

    public ItemVenda(int id, int qtdproduto, float valorunitario, String status, Produto produto, Venda venda) {
        this.id = id;
        this.qtdproduto = qtdproduto;
   
        this.status = status;
       this.produto = produto;
       this.venda=venda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdproduto() {
        return qtdproduto;
    }

    public void setQtdproduto(int qtdproduto) {
        this.qtdproduto = qtdproduto;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
   


    @Override
    public String toString() {
        return "id=" + this.getId() + ", qtdproduto=" + this.getQtdproduto() +", status=" + this.getStatus() + ", Produto=" + this.getProduto()+", venda="+this.getVenda();
    }
    
    
}
