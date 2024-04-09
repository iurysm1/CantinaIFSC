
package model.bo;


public class Cidade {
    private int id;
    private String descricao;
    private String uf;
    private String status;
    

    public Cidade(int id, String descricao, String uf, String status) {
        this.id = id;
        this.descricao = descricao;
        this.uf = uf;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Cidade() {
    }

    @Override
    public String toString() {
        return  "id=" + this.getId() + ", descricao=" + this.getDescricao() + ", uf=" + this.getUf() ;
    }
    
    
}
