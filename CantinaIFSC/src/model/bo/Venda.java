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
    
    private Funcionario funcionario;
    private Carteirinha carteirinha;

    public Venda() {
    }

    public Venda(int id, String datahoravenda, String obeservacao, float valordesconto, char flagtipodesconto, char status, Funcionario funcionario, Carteirinha carteirinha) {
        this.id = id;
        this.datahoravenda = datahoravenda;
        this.obeservacao = obeservacao;
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
