
package model.bo;


public class Movimentocaixa {
    
    private int id;
    private String datahoramovimento;
    private float valormovimento;
    private String observacao;
    private char flagtipomovimento;
    private char status;

    public Movimentocaixa() {
    }

    public Movimentocaixa(int id, String datahoramovimento, float valormovimento, String observacao, char flagtipomovimento, char status) {
        this.id = id;
        this.datahoramovimento = datahoramovimento;
        this.valormovimento = valormovimento;
        this.observacao = observacao;
        this.flagtipomovimento = flagtipomovimento;
        this.status = status;
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

    @Override
    public String toString() {
        return "id=" + this.getId() + ", datahoramovimento=" + this.getDatahoramovimento() + ", valormovimento=" + this.getValormovimento() + ", observacao=" + this.getObservacao() + ", flagtipomovimento=" + this.getFlagtipomovimento() + ", status=" + this.getStatus();
    }
    
    
    
}
