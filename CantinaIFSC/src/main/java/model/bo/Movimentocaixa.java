
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
public class Movimentocaixa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String datahoramovimento;
    
    @Column
    private float valormovimento;
    
    @Column
    private String observacao;
    
    @Column
    private char flagtipomovimento;
    
    @Column
    private String status;
    
    @JoinColumn
    @ManyToOne
    private Caixa caixa;

    
    public Movimentocaixa() {
    }

    public Movimentocaixa(int id, String datahoramovimento, float valormovimento, String observacao, char flagtipomovimento, String status, Caixa caixa) {
        this.id = id;
        this.datahoramovimento = datahoramovimento;
        this.valormovimento = valormovimento;
        this.observacao = observacao;
        this.flagtipomovimento = flagtipomovimento;
        this.status = status;
        this.caixa=caixa;
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatahoramovimento() {
        return datahoramovimento;
    }

    public void setDatahoramovimento(String datahoramovimento) {
        this.datahoramovimento = datahoramovimento;
    }

    public float getValormovimento() {
        return valormovimento;
    }

    public void setValormovimento(float valormovimento) {
        this.valormovimento = valormovimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public char getFlagtipomovimento() {
        return flagtipomovimento;
    }

    public void setFlagtipomovimento(char flagtipomovimento) {
        this.flagtipomovimento = flagtipomovimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

   
    

    @Override
    public String toString() {
        return "id=" + this.getId() + ", datahoramovimento=" + this.getDatahoramovimento() + ", valormovimento=" + this.getValormovimento() + ", observacao=" + this.getObservacao() + ", flagtipomovimento=" + this.getFlagtipomovimento() + ", status=" + this.getStatus()+", caixa="+this.getCaixa();
    }
    
    
    
}
