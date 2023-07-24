
package DAO;

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
        
        
        Bairro bairro = new Bairro(1, "Divineia");
        Bairro bairro2= new Bairro(2, "Aguada");
        Bairro bairro3 = new Bairro(3, "Centro");
        bairros.add(bairro);
        bairros.add(bairro2);
        bairros.add(bairro3);
        
        Cidade cidade= new Cidade(1, "Imbituba", "SC");
        Cidade cidade2= new Cidade(2, "Garopaba", "SC");
        Cidade cidade3= new Cidade(3, "Porto Alegre", "RS");
        cidades.add(cidade);
        cidades.add(cidade2);
        cidades.add(cidade3);
        
        Endereco endereco = new Endereco(1, "88780000", "Rua João de Oliveira", 's', bairro, cidade);
        Endereco endereco2 = new Endereco(2, "88780002", "Rua da Palhocinha", 's', bairro2, cidade2);
        Endereco endereco3 = new Endereco(3, "88780003", "Avenida Presidente Vargas", 's', bairro3, cidade3);
        enderecos.add(endereco);
        enderecos.add(endereco2);
        enderecos.add(endereco3);
        
        
        Cliente cliente = new Cliente("08821150909", "6567895", "1", "22022002", 1, "Iury Silveira Marques", "999999", "299999", "iury@gmail.com", 's', "Presidio imbituba", endereco);
        clientes.add(cliente);
        Cliente cliente2 = new Cliente("19921150909", "646546", "2", "22022002", 2, "Joao Gomes", "999999", "299999", "joao@gmail.com", 's', "Presidio imbituba", endereco3);
        clientes.add(cliente2);
        
    Carteirinha carteirinha = new Carteirinha(1, "123", "01/01/2023", "10/10/2025", cliente);
        carteirinhas.add(carteirinha);
        
      
        Funcionario funcionario = new Funcionario("09921150909", "111", "iury.marques", "2202", movimentacaoEstoque, venda, caixa, 1, "IuryFuncionario", "999999", "299999999", "funcionario@gmail.com", 's', "FuncionarioComplemento", endereco, "22022002");
        funcionarios.add(funcionario);
         Funcionario funcionario2 = new Funcionario("08831150909", "222", "joao.gomes", "123", movimentacaoEstoque, venda, caixa, 2, "Joao Gomes", "8888888", "888888888", "funcionario2@gmail.com", 's', "FuncionarioComplemento2", endereco3, "15062000");
        funcionarios.add(funcionario2);
        
        Fornecedor fornecedor = new Fornecedor("13347016000017", "1234567", 1, "IuryFornecedor", "9999", "9992", "fornecedor@gmail.com", 's', "FornecedorEnd", endereco);
        Fornecedor fornecedor2 = new Fornecedor("12237016000017", "123321", 2, "Jhonnie Walker", "999999", "9992", "fornecedor2@gmail.com", 's', "FornecedorEnd2", endereco2);
        fornecedores.add(fornecedor);
        fornecedores.add(fornecedor2);
        
        
        Produto produto = new Produto(1, "Salsicha", "111", 's', 2, "D:/Documents/fotosProduto/salsicha360px.png");
         Produto produto2 = new Produto(2, "Pastel", "222", 's', 3, "D:/Documents/fotosProduto/pastel360.png");
        produtos.add(produto);
        produtos.add(produto2);
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
