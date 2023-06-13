 
package model.bo;

public class Carteirinha {
    private int id;
    private String codigobarra;
    private String datageracao;
    private String datacancelamento;
    private Cliente cliente;

    public Carteirinha() {
    }

    public Carteirinha(int id, String codigobarra, String datageracao, String datacancelamento, Cliente cliente) {
        this.id = id;
        this.codigobarra = codigobarra;
        this.datageracao = datageracao;
        this.datacancelamento = datacancelamento;
        this.cliente=cliente;
    }
    

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public String getDatageracao() {
        return datageracao;
    }

    public void setDatageracao(String datageracao) {
        this.datageracao = datageracao;
    }

    public String getDatacancelamento() {
        return datacancelamento;
    }

    public void setDatacancelamento(String datacancelamento) {
        this.datacancelamento = datacancelamento;
    }
    
    public int getIdCliente(){
        return cliente.getId();
    }
    
    public String getNomeCliente(){
        return cliente.getNome();
                
    }

    @Override
    public String toString() {
        return "id=" + this.getId() + ", codigobarra=" + this.getCodigobarra() + ", datageracao=" + this.getDatageracao() + ", datacancelamento=" + this.getDatacancelamento();
    }
    
    
}
