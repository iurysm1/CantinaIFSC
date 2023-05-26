
package model.bo;


public class Movimentocaixa {
    
    private int id;
    private String datahoramovimento;
    private float valormovimento;
    private String observacao;
    private char flagtipomovimento;
    private char status;
    
    private Caixa caixa;
    private Contas contas;
    
    public Movimentocaixa() {
    }

    public Movimentocaixa(int id, String datahoramovimento, float valormovimento, String observacao, char flagtipomovimento, char status, Caixa caixa, Contas contas) {
        this.id = id;
        this.datahoramovimento = datahoramovimento;
        this.valormovimento = valormovimento;
        this.observacao = observacao;
        this.flagtipomovimento = flagtipomovimento;
        this.status = status;
        this.caixa=caixa;
        this.contas=contas;
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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Contas getContas() {
        return contas;
    }

    public void setContas(Contas contas) {
        this.contas = contas;
    }
    

    @Override
    public String toString() {
        return "id=" + this.getId() + ", datahoramovimento=" + this.getDatahoramovimento() + ", valormovimento=" + this.getValormovimento() + ", observacao=" + this.getObservacao() + ", flagtipomovimento=" + this.getFlagtipomovimento() + ", status=" + this.getStatus()+", caixa="+this.getCaixa()+", contas"+this.getContas();
    }
    
    
    
}
