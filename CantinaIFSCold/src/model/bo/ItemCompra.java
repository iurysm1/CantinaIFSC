
package model.bo;

public class ItemCompra {
    
    private int id;
    private float qtdproduto;
    private String status;
    
    private Produto produto;
    private Compra compra;

    public ItemCompra() {
    }

    public ItemCompra(int id, float qtdproduto, String status, Produto produto, Compra compra) {
        this.id = id;
        this.qtdproduto = qtdproduto;
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



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        return "id=" + this.getId() + ", qtdproduto=" + this.getQtdproduto()+ ", status=" + this.getStatus() + ", compra="+this.getCompra()+", produto="+this.getProduto();
    }
    
    
    
}
