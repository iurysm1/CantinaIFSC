
package model.bo;

public class ItemCompra {
    
    private int id;
    private float qtdproduto;
    private float valorunitario;
    private char status;
    private Movimentacaoestoque movimentacaoestoque;

    public ItemCompra() {
    }

    public ItemCompra(int id, float qtdproduto, float valorunitario, char status, Movimentacaoestoque movimentacaoestoque) {
        this.id = id;
        this.qtdproduto = qtdproduto;
        this.valorunitario = valorunitario;
        this.status = status;
        this.movimentacaoestoque = movimentacaoestoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQtdproduto() {
        return qtdproduto;
    }

    public void setQtdproduto(float qtdproduto) {
        this.qtdproduto = qtdproduto;
    }

    public float getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(float valorunitario) {
        this.valorunitario = valorunitario;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Movimentacaoestoque getMovimentacaoestoque() {
        return movimentacaoestoque;
    }

    public void setMovimentacaoestoque(Movimentacaoestoque movimentacaoestoque) {
        this.movimentacaoestoque = movimentacaoestoque;
    }

    @Override
    public String toString() {
        return "id=" + this.getId() + ", qtdproduto=" + this.getQtdproduto() + ", valorunitario=" + this.getValorunitario() + ", status=" + this.getStatus() + ", movimentacaoestoque=" + this.movimentacaoestoque.getId();
    }
    
    
    
}
