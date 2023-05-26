
package model.bo;

public class ItemCompra {
    
    private int id;
    private float qtdproduto;
    private float valorunitario;
    private char status;
    
    private Produto produto;
    private Compra compra;

    public ItemCompra() {
    }

    public ItemCompra(int id, float qtdproduto, float valorunitario, char status, Produto produto, Compra compra) {
        this.id = id;
        this.qtdproduto = qtdproduto;
        this.valorunitario = valorunitario;
        this.status = status;
        this.produto=produto;
        this.compra=compra;
  
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }


    @Override
    public String toString() {
        return "id=" + this.getId() + ", qtdproduto=" + this.getQtdproduto() + ", valorunitario=" + this.getValorunitario() + ", status=" + this.getStatus() + ", compra="+this.getCompra()+", produto="+this.getProduto();
    }
    
    
    
}
