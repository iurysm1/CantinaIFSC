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
public class Contas {
    private int id;
    private String datahoraemissao;
    private String datavencimento;
    private String dataquitacao;
    private float valoremitido;
    private float valordesconto;
    private float valoracrescimo;
    private float valorquitado;
    private String observacao;
    private char flagtipoconta;
    private char status;
    
    private Venda venda;
    private Compra compra;
    private Movimentocaixa movimentacaocaixa;

    public Contas(int id, String datahoraemissao, String datavencimento, String dataquitacao, float valoremitido, float valordesconto, float valoracrescimo, float valorquitado, String observacao, char flagtipoconta, char status, Venda venda, Compra compra, Movimentocaixa movimentacaocaixa) {
        this.id = id;
        this.datahoraemissao = datahoraemissao;
        this.datavencimento = datavencimento;
        this.dataquitacao = dataquitacao;
        this.valoremitido = valoremitido;
        this.valordesconto = valordesconto;
        this.valoracrescimo = valoracrescimo;
        this.valorquitado = valorquitado;
        this.observacao = observacao;
        this.flagtipoconta = flagtipoconta;
        this.status = status;
        this.movimentacaocaixa = movimentacaocaixa;
        this.venda = venda;
        this.compra=compra;
        
    }

    public Contas() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatahoraemissao() {
        return datahoraemissao;
    }

    public void setDatahoraemissao(String datahoraemissao) {
        this.datahoraemissao = datahoraemissao;
    }

    public String getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(String datavencimento) {
        this.datavencimento = datavencimento;
    }

    public String getDataquitacao() {
        return dataquitacao;
    }

    public void setDataquitacao(String dataquitacao) {
        this.dataquitacao = dataquitacao;
    }

    public float getValoremitido() {
        return valoremitido;
    }

    public void setValoremitido(float valoremitido) {
        this.valoremitido = valoremitido;
    }

    public float getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(float valordesconto) {
        this.valordesconto = valordesconto;
    }

    public float getValoracrescimo() {
        return valoracrescimo;
    }

    public void setValoracrescimo(float valoracrescimo) {
        this.valoracrescimo = valoracrescimo;
    }

    public float getValorquitado() {
        return valorquitado;
    }

    public void setValorquitado(float valorquitado) {
        this.valorquitado = valorquitado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public char getFlagtipoconta() {
        return flagtipoconta;
    }

    public void setFlagtipoconta(char flagtipoconta) {
        this.flagtipoconta = flagtipoconta;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Movimentocaixa getMovimentacaocaixa() {
        return movimentacaocaixa;
    }

    public void setMovimentacaocaixa(Movimentocaixa movimentacaocaixa) {
        this.movimentacaocaixa = movimentacaocaixa;
    }
    

    @Override
    public String toString() {
        return "id=" + this.getId() + ", datahoraemissao=" + this.getDatahoraemissao() + ", datavencimento=" + this.getDatavencimento() + ", dataquitacao=" + this.getDataquitacao() + ", valoremitido=" + this.getValoremitido() + ", valordesconto=" + this.getValordesconto() + ", valoracrescimo=" + this.getValoracrescimo() + ", valorquitado=" + this.getValorquitado() + ", observacao=" + this.getObservacao() + ", flagtipoconta=" + this.getFlagtipoconta() + ", status=" + this.getStatus()+ ", idCompra: "+this.getCompra()+", idVenda: "+this.getVenda();
    }
    
    
}
