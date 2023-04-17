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
public class Venda {
    private int id;
    private String datahoravenda;
    private String obeservacao;
    private float valordesconto;
    private char flagtipodesconto;
    private char status;
    
    private Contas contas;
    private ItemVenda itemVenda;

    public Venda() {
    }

    public Venda(int id, String datahoravenda, String obeservacao, float valordesconto, char flagtipodesconto, char status, Contas contas, ItemVenda itemVenda) {
        this.id = id;
        this.datahoravenda = datahoravenda;
        this.obeservacao = obeservacao;
        this.valordesconto = valordesconto;
        this.flagtipodesconto = flagtipodesconto;
        this.status = status;
        this.contas = contas;
        this.itemVenda = itemVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatahoravenda() {
        return datahoravenda;
    }

    public void setDatahoravenda(String datahoravenda) {
        this.datahoravenda = datahoravenda;
    }

    public String getObeservacao() {
        return obeservacao;
    }

    public void setObeservacao(String obeservacao) {
        this.obeservacao = obeservacao;
    }

    public float getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(float valordesconto) {
        this.valordesconto = valordesconto;
    }

    public char getFlagtipodesconto() {
        return flagtipodesconto;
    }

    public void setFlagtipodesconto(char flagtipodesconto) {
        this.flagtipodesconto = flagtipodesconto;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Contas getContas() {
        return contas;
    }

    public void setContas(Contas contas) {
        this.contas = contas;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    @Override
    public String toString() {
        return "id=" + this.getId() + ", datahoravenda=" + this.getDatahoravenda() + ", obeservacao=" + this.getObeservacao() + ", valordesconto=" + this.getValordesconto() + ", flagtipodesconto=" + this.getFlagtipodesconto() + ", status=" + this.getStatus() + ", contas=" + this.contas.getId() + ", itemVenda=" + this.itemVenda.getId() + '}';
    }
    
     
}
