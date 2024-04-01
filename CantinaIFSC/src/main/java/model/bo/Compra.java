
package model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compra {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private int numeronf;
    
    @Column
    private String datahoracompra;
    
    @Column
    private float valordesconto;
    
    @Column
    private char flagtipodesconto;
    
    @Column
    private String status;
    
    @Column
    private String observacao;
    
    @JoinColumn
    @ManyToOne
    private Fornecedor fornecedor;

    public Compra() {
    }

    public Compra(int id, int numeronf, String datahoracompra, float valordesconto, char flagtipodesconto, String status, String observacao, Fornecedor fornecedor) {
        this.id = id;
        this.numeronf = numeronf;
        this.datahoracompra = datahoracompra;
        this.valordesconto = valordesconto;
        this.flagtipodesconto = flagtipodesconto;
        this.status = status;
        this.observacao = observacao;
        this.fornecedor=fornecedor;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeronf() {
        return numeronf;
    }

    public void setNumeronf(int numeronf) {
        this.numeronf = numeronf;
    }

    public String getDatahoracompra() {
        return datahoracompra;
    }

    public void setDatahoracompra(String datahoracompra) {
        this.datahoracompra = datahoracompra;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    

    @Override
    public String toString() {
        return "id=" + this.getId() + ", numeronf=" + this.getNumeronf() + ", datahoracompra=" + this.getDatahoracompra() + ", valordesconto=" + this.getValordesconto() + ", flagtipodesconto=" + this.getFlagtipodesconto() + ", status=" + this.getStatus() + ", observacao=" + this.getObservacao()+", fornecedor"+this.getFornecedor();
    }
    
    
}
