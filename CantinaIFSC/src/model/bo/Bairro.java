

package model.bo;


public class Bairro {
    private String descricao;
    private int id;
    private char status;

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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "descricao=" + this.getDescricao() + ", id=" + this.getId()+", status="+this.getStatus() ;
    }
    
    
}
