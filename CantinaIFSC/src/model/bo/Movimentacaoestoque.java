
package model.bo;


public class Movimentacaoestoque {
    
    private int id;
    private String datahoramovimento;
    private String observacaomovimento;
    private char flagtipomovimento;
    private float qtdmovimentada;
    private char status;

    public Movimentacaoestoque() {
    }

    public Movimentacaoestoque(int id, String datahoramovimento, String observacaomovimento, char flagtipomovimento, float qtdmovimentada, char status) {
        this.id = id;
        this.datahoramovimento = datahoramovimento;
        this.observacaomovimento = observacaomovimento;
        this.flagtipomovimento = flagtipomovimento;
        this.qtdmovimentada = qtdmovimentada;
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

    public String getObservacaomovimento() {
        return observacaomovimento;
    }

    public void setObservacaomovimento(String observacaomovimento) {
        this.observacaomovimento = observacaomovimento;
    }

    public char getFlagtipomovimento() {
        return flagtipomovimento;
    }

    public void setFlagtipomovimento(char flagtipomovimento) {
        this.flagtipomovimento = flagtipomovimento;
    }

    public float getQtdmovimentada() {
        return qtdmovimentada;
    }

    public void setQtdmovimentada(float qtdmovimentada) {
        this.qtdmovimentada = qtdmovimentada;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id=" + this.getId() + ", datahoramovimento=" + this.getDatahoramovimento() + ", observacaomovimento=" + this.getObservacaomovimento() + ", flagtipomovimento=" + this.getFlagtipomovimento() + ", qtdmovimentada=" + this.getQtdmovimentada() + ", status=" + this.getStatus();
    }
    
    
    
}
