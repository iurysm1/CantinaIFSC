
package model.bo;


public class Produto {
    
    private int id;
    private String descricao;
    private String codigobarra;
    private char status;
    
    private ItemCompra itemCompra;
    private ItemVenda itemVenda;
    private Movimentacaoestoque movimentacaoestoque;

    public Produto() {
    }

    public Produto(int id, String descricao, String codigobarra, char status, ItemCompra itemCompra, ItemVenda itemVenda, Movimentacaoestoque movimentacaoestoque) {
        this.id = id;
        this.descricao = descricao;
        this.codigobarra = codigobarra;
        this.status = status;
        this.itemCompra = itemCompra;
        this.itemVenda = itemVenda;
        this.movimentacaoestoque = movimentacaoestoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public ItemCompra getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(ItemCompra itemCompra) {
        this.itemCompra = itemCompra;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    public Movimentacaoestoque getMovimentacaoestoque() {
        return movimentacaoestoque;
    }

    public void setMovimentacaoestoque(Movimentacaoestoque movimentacaoestoque) {
        this.movimentacaoestoque = movimentacaoestoque;
    }

    @Override
    public String toString() {
        return "id=" + this.getId() + ", descricao=" + this.getDescricao() + ", codigobarra=" + this.getCodigobarra() + ", status=" + this.getStatus() + ", itemCompra=" + this.itemCompra.getId() + ", itemVenda=" + this.itemVenda.getId() + ", movimentacaoestoque=" + this.movimentacaoestoque.getId();
    }
    
    
}
