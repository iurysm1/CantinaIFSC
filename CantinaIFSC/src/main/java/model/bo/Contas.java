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
public class Contas implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String datahoraemissao;
    
    @Column
    private String datavencimento;
    
    @Column
    private String dataquitacao;
    
    @Column
    private float valoremitido;
    
    @Column
    private float valordesconto;
    
    @Column
    private float valoracrescimo;
    
    @Column
    private float valorquitado;
    
    @Column
    private String observacao;
    
    @Column
    private char flagtipoconta;
    
    @Column
    private String status;
    
    
    @JoinColumn
    @ManyToOne
    private Venda venda;
    
    @JoinColumn
    @ManyToOne
    private Compra compra;
    
    @JoinColumn
    @ManyToOne
    private Movimentocaixa movimentacaocaixa;

    public Contas(int id, String datahoraemissao, String datavencimento, String dataquitacao, float valoremitido, float valordesconto, float valoracrescimo, float valorquitado, String observacao, char flagtipoconta, String status, Venda venda, Compra compra, Movimentocaixa movimentacaocaixa) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
