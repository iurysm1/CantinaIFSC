
package model.bo;


public class Movimentacaoestoque {
    
    private int id;
    private String datahoramovimento;
    private String observacaomovimento;
    private char flagtipomovimento;
    private float qtdmovimentada;
    private String status;
    
    private ItemVenda itemVenda;
    private Produto produto;
    private ItemCompra compra;
    private Funcionario funcionario;

    public Movimentacaoestoque() {
    }

    public Movimentacaoestoque(int id, String datahoramovimento, String observacaomovimento, char flagtipomovimento, float qtdmovimentada, String status, ItemVenda itemVenda, Produto produto, ItemCompra compra, Funcionario funcionario) {
        this.id = id;
        this.datahoramovimento = datahoramovimento;
        this.observacaomovimento = observacaomovimento;
        this.flagtipomovimento = flagtipomovimento;
        this.qtdmovimentada = qtdmovimentada;
        this.status = status;
        
        this.itemVenda = itemVenda;
        this.produto = produto;
        this.compra = compra;
        this.funcionario = funcionario;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatahoramovimento() {
        return datahoramovimento;
    }

    public void setDatahoramovimento(String datahoramovimento) {
        this.datahoramovimento = datahoramovimento;
    }

    public String getObservacaomovimento() {
        return observacaomovimento;
    }

    public void setObservacaomovimento(String observacaomovimento) {
        this.observacaomovimento = observacaomovimento;
    }

    public char getFlagtipomovimento() {
        return flagtipomovimento;
    }

    public void setFlagtipomovimento(char flagtipomovimento) {
        this.flagtipomovimento = flagtipomovimento;
    }

    public float getQtdmovimentada() {
        return qtdmovimentada;
    }

    public void setQtdmovimentada(float qtdmovimentada) {
        this.qtdmovimentada = qtdmovimentada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ItemCompra getCompra() {
        return compra;
    }

    public void setCompra(ItemCompra compra) {
        this.compra = compra;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    @Override
    public String toString() {
        return "id=" + this.getId() + ", datahoramovimento=" + this.getDatahoramovimento() + ", observacaomovimento=" + this.getObservacaomovimento() + ", flagtipomovimento=" + this.getFlagtipomovimento() + ", qtdmovimentada=" + this.getQtdmovimentada() + ", status=" + this.getStatus()+", ItemCompra= "+this.getCompra()+", ItemVenda="+this.getItemVenda()+", Produto"+this.getProduto()+", Funcionario"+this.getFuncionario();
    }
    
    
    
}
