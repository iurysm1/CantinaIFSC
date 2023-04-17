
package model.bo;

public class Funcionario extends Pessoa{
    
    private String cpf;
    private String rg;
    private String usuario;
    private String senha;
    private Movimentacaoestoque movimentacaoEstoque;
    private Venda venda;
    private Caixa caixa;

    public Funcionario(String cpf, String rg, String usuario, String senha, Movimentacaoestoque movimentacaoEstoque, Venda venda, Caixa caixa, int id, String nome, String fone1, String fone2, String email, char status, String complementoEndereco, Endereco endereco) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.usuario = usuario;
        this.senha = senha;
        this.movimentacaoEstoque = movimentacaoEstoque;
        this.venda = venda;
        this.caixa = caixa;
    }

    public Funcionario() {
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Movimentacaoestoque getMovimentacaoEstoque() {
        return movimentacaoEstoque;
    }

    public void setMovimentacaoEstoque(Movimentacaoestoque movimentacaoEstoque) {
        this.movimentacaoEstoque = movimentacaoEstoque;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public String toString() {
        return "cpf=" + this.getCpf() + ", rg=" + this.getRg() + ", usuario=" + this.getUsuario() + ", senha=" + this.getSenha() + ", movimentacaoEstoque=" + this.movimentacaoEstoque.getId() + ", venda=" + this.venda.getId() + ", caixa=" + this.caixa.getId() + '}';
    }
    
    
}
