
package model.bo;


public class Produto {
    
    private int id;
    private String descricao;
    private String codigobarra;
    private char status;
    private float preco;
    


    public Produto() {
    }

    public Produto(int id, String descricao, String codigobarra, char status, float preco) {
        this.id = id;
        this.descricao = descricao;
        this.codigobarra = codigobarra;
        this.status = status;
        this.preco=preco;
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

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }



    @Override
    public String toString() {
        return "id=" + this.getId() + ", descricao=" + this.getDescricao() + ", codigobarra=" + this.getCodigobarra() + ", status=" + this.getStatus()+", preço="+this.getPreco();
    }
    
    
}
