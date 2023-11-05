
package model.bo;


public class Produto {
    
    private int id;
    private String descricao;
    private String codigobarra;
    private String status;
    private float preco;
    private String CaminhoFotoProduto;
    


    public Produto() {
    }

    public Produto(int id, String descricao, String codigobarra, String status, float preco, String CaminhoFotoProduto) {
        this.id = id;
        this.descricao = descricao;
        this.codigobarra = codigobarra;
        this.status = status;
        this.preco=preco;
        this.CaminhoFotoProduto=CaminhoFotoProduto;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public String getCaminhoFotoProduto() {
        return CaminhoFotoProduto;
    }

    public void setCaminhoFotoProduto(String CaminhoFotoProduto) {
        this.CaminhoFotoProduto = CaminhoFotoProduto;
    }
    
    


    @Override
    public String toString() {
        return "id=" + this.getId() + ", descricao=" + this.getDescricao() + ", codigobarra=" + this.getCodigobarra() + ", status=" + this.getStatus()+", preço="+this.getPreco();
    }
    
    
}
