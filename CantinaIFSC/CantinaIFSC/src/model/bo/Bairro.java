

package model.bo;


public class Bairro {
    private String descricao;
    private int id;

    public Bairro() {
    }

    public Bairro(String descricao, int id) {
        this.descricao = descricao;
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "descricao=" + this.getDescricao() + ", id=" + this.getId() ;
    }
    
    
}
