
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
public class Caixa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String datahoraabertura;
    
    @Column
    private String datahorafechamento;
    
    @Column
    private float valorabertura;
    
    @Column
    private float valorfechamento;
    
    @Column
    private String observacao;
    
    @Column
    private String status;
    
    @JoinColumn
    @ManyToOne
    private Funcionario funcionario;

    public Caixa() {
    }

    public Caixa(int id, String datahoraabertura, String datahorafechamento, float valorabertura, float valorfechamento, String observacao, String status, Funcionario funcionario) {
        this.id = id;
        this.datahoraabertura = datahoraabertura;
        this.datahorafechamento = datahorafechamento;
        this.valorabertura = valorabertura;
        this.valorfechamento = valorfechamento;
        this.observacao = observacao;
        this.status = status;
        this.funcionario=funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatahoraabertura() {
        return datahoraabertura;
    }

    public void setDatahoraabertura(String datahoraabertura) {
        this.datahoraabertura = datahoraabertura;
    }

    public String getDatahorafechamento() {
        return datahorafechamento;
    }

    public void setDatahorafechamento(String datahorafechamento) {
        this.datahorafechamento = datahorafechamento;
    }

    public float getValorabertura() {
        return valorabertura;
    }

    public void setValorabertura(float valorabertura) {
        this.valorabertura = valorabertura;
    }

    public float getValorfechamento() {
        return valorfechamento;
    }

    public void setValorfechamento(float valorfechamento) {
        this.valorfechamento = valorfechamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
    @Override
    public String toString() {
        return "Caixa{" + "id=" + this.getId() + ", datahoraabertura=" + this.getDatahoraabertura() + ", datahorafechamento=" + this.getDatahorafechamento() + ", valorabertura=" + this.getValorabertura() + ", valorfechamento=" + this.getValorfechamento() + ", observacao=" + this.getObservacao() + ", status=" + this.getStatus() + ", funcionario=" + this.getFuncionario();
    }
    
    
    
}
