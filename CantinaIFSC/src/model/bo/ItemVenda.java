/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

/**
 *
 * @author aluno
 */
public class ItemVenda {
    private int id;
    private float qtdproduto;
 
    private String status;
    
    private Produto produto;
    private Venda venda;

    public ItemVenda() {
    }

    public ItemVenda(int id, float qtdproduto, float valorunitario, String status, Produto produto, Venda venda) {
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

    public float getQtdproduto() {
        return qtdproduto;
    }

    public void setQtdproduto(float qtdproduto) {
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
    
   


    @Override
    public String toString() {
        return "id=" + this.getId() + ", qtdproduto=" + this.getQtdproduto() +", status=" + this.getStatus() + ", Produto=" + this.getProduto()+", venda="+this.getVenda();
    }
    
    
}
