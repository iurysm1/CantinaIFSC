
package model.bo;


public class Compra {
    
    private int id;
    private int numeronf;
    private String datahoracompra;
    private float valordesconto;
    private char flagtipodesconto;
    private char status;
    private String observacao;
    
    private ItemCompra itemCompra;
    private Contas contas;

    public Compra() {
    }

    public Compra(int id, int numeronf, String datahoracompra, float valordesconto, char flagtipodesconto, char status, String observacao, ItemCompra itemCompra, Contas contas) {
        this.id = id;
        this.numeronf = numeronf;
        this.datahoracompra = datahoracompra;
        this.valordesconto = valordesconto;
        this.flagtipodesconto = flagtipodesconto;
        this.status = status;
        this.observacao = observacao;
        this.itemCompra = itemCompra;
        this.contas = contas;
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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public ItemCompra getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }

    public Contas getContas() {
        return contas;
    }

    public void setContas(Contas contas) {
        this.contas = contas;
    }

    @Override
    public String toString() {
        return "id=" + this.getId() + ", numeronf=" + this.getNumeronf() + ", datahoracompra=" + this.getDatahoracompra() + ", valordesconto=" + this.getValordesconto() + ", flagtipodesconto=" + this.getFlagtipodesconto() + ", status=" + this.getStatus() + ", observacao=" + this.getObservacao() + ", itemCompra=" + this.itemCompra.getId() + ", contas=" + this.contas.getId() + '}';
    }
    
    
}
