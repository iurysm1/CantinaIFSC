

package model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bairro implements Serializable{
    
    @Column
    private String descricao;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String status;

    public Bairro() {
    }

    public Bairro(int id, String descricao, String status) {
        this.descricao = descricao;
        this.id = id;
        this.status=status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "descricao=" + this.getDescricao() + ", id=" + this.getId()+", status="+this.getStatus() ;
    }
    
    
}
