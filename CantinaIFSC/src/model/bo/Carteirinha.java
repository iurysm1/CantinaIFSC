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
public class Carteirinha {
    private int id;
    private String codigobarra;
    private String datageracao;
    private String datacancelamento;
    
    private Cliente cliente;
    private Venda venda;

    public Carteirinha() {
    }

    public Carteirinha(int id, String codigobarra, String datageracao, String datacancelamento, Cliente cliente, Venda venda) {
        this.id = id;
        this.codigobarra = codigobarra;
        this.datageracao = datageracao;
        this.datacancelamento = datacancelamento;
        this.cliente = cliente;
        this.venda = venda;
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

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "id=" + this.getId() + ", codigobarra=" + this.getCodigobarra() + ", datageracao=" + this.getDatageracao() + ", datacancelamento=" + this.getDatacancelamento() + ", cliente=" + this.getCliente() + ", venda=" + this.getVenda();
    }
    
    
}
