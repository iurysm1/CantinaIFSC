
package model.DAO;

import java.util.ArrayList;
import model.bo.Bairro;
import model.bo.Caixa;
import model.bo.Carteirinha;
import model.bo.Cidade;
import model.bo.Cliente;
import model.bo.Compra;
import model.bo.Contas;
import model.bo.Endereco;
import model.bo.Fornecedor;
import model.bo.Funcionario;
import model.bo.ItemCompra;
import model.bo.ItemVenda;
import model.bo.Movimentacaoestoque;
import model.bo.Movimentocaixa;
import model.bo.Produto;
import model.bo.Venda;

public class Persiste {
    private static Persiste uniqueInstance;
    
    private Persiste() {
        Movimentacaoestoque movimentacaoEstoque = new Movimentacaoestoque();
        Caixa caixa = new Caixa();
        Venda venda = new Venda();
        
        
        
    }
    
    public static synchronized Persiste getInstance() {
        if (uniqueInstance==null){
            uniqueInstance=new Persiste();
        }
        
        return uniqueInstance;
    }
    public static ArrayList<Bairro>bairros = new ArrayList<>();
    public static ArrayList<Caixa>caixas = new ArrayList<>();
    public static ArrayList<Carteirinha>carteirinhas = new ArrayList<>();
    public static ArrayList<Cidade>cidades = new ArrayList<>();
    public static ArrayList<Cliente>clientes = new ArrayList<>();
    public static ArrayList<Compra>compras = new ArrayList<>();
    public static ArrayList<Contas> contas = new ArrayList<>();
    public static ArrayList<Endereco> enderecos = new ArrayList<>();
    public static ArrayList<Fornecedor>fornecedores = new ArrayList<>();
    public static ArrayList<Funcionario>funcionarios = new ArrayList<>();
    public static ArrayList<ItemCompra>itemCompra = new ArrayList<>();
    public static ArrayList<ItemVenda>itemVenda = new ArrayList<>();
    public static ArrayList<Movimentacaoestoque>movimentacaoestoque = new ArrayList<>();
    public static ArrayList<Movimentocaixa>movimentocaixa = new ArrayList<>();
    public static ArrayList<Produto>produtos =new ArrayList<>();
    public static ArrayList<Venda>vendas = new ArrayList<>();
    
    

}
