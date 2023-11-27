
package controller;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Funcionario;
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;
import view.Vendas;

public class VendaController{

    Vendas vendas;
    Venda faturacao;
    Funcionario funcionario = service.FuncionarioService.carregar(1);
    List<ItemVenda> itensDaTabela = new ArrayList<>();
    
    private KeyEventDispatcher atalhos = new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        adicionarItemVenda();
                        break;
                    case KeyEvent.VK_F1:
                        vendas.getCodigoBarras().setEnabled(true);
                        break;
                    case KeyEvent.VK_F12:
                        vendas.getCodigoBarras().setEnabled(false);
                        break;
                     case KeyEvent.VK_ESCAPE:
                        vendas.dispose();
                        break;
                    default:
                        break;
                }
                

            }
            return false;
        }
    };
    
    
    
    public VendaController(Vendas vendas) {
        
        this.vendas=vendas;
        this.vendas.getIdFuncionario().setText(this.funcionario.getId()+"");
        this.vendas.getNomeFuncionario().setText(this.funcionario.getNome());
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(atalhos);
    }
    
    public Venda novaFaturacao(){
        Venda venda = new Venda();
        venda.setStatus("A");
        venda.setObeservacao("");
        venda.setFlagtipodesconto('S');
        venda.setValordesconto(10);
        
        
        return null;
    }
    
    public ItemVenda itemVenda(){
       int quantidade=0;
       ItemVenda itemVenda=new ItemVenda();
       Produto produtoAtual = adicionarProduto();
       itemVenda.setVenda(faturacao);
       itemVenda.setProduto(produtoAtual);
       
       if(this.vendas.getCodigoBarras().getText().contains("X")||this.vendas.getCodigoBarras().getText().contains("x")){
            int parametroQuantidade=this.vendas.getCodigoBarras().getText().toUpperCase().indexOf("X");
            System.out.println(parametroQuantidade);
            quantidade= Integer.parseInt(this.vendas.getCodigoBarras().getText().substring(0, parametroQuantidade));
       }
       
       itemVenda.setQtdproduto(quantidade);
       itemVenda.setStatus("A");
       
       
       
        
       return itemVenda; 
    }
    
    public Produto adicionarProduto(){
       
        Produto produtoAtual = new Produto();
        if(this.vendas.getCodigoBarras().getText().contains("X")||this.vendas.getCodigoBarras().getText().contains("x")){
            int parametroQuantidade=this.vendas.getCodigoBarras().getText().toUpperCase().indexOf("X");
            
            String codigodebarras=this.vendas.getCodigoBarras().getText().substring(parametroQuantidade+1);
            produtoAtual=service.ProdutoService.carregarCodigoBarra(codigodebarras);
            
        }else{
            String codigodebarras=this.vendas.getCodigoBarras().getText();
            produtoAtual=service.ProdutoService.carregarCodigoBarra(codigodebarras);
        }
        
        
        return produtoAtual;
    }
    
    public void adicionarItemVenda(){
        
        DefaultTableModel tabelaItens = (DefaultTableModel) vendas.getItens().getModel();
        
        this.vendas.getNomeDoProduto().setText(itemVenda().getProduto().getDescricao());
        this.vendas.setLabelValorUnitarioItem(itemVenda().getProduto().getPreco()+"");
        this.vendas.setLabelValorTotalItem(itemVenda().getProduto().getPreco()*itemVenda().getQtdproduto()+"");
        
        tabelaItens.addRow(new Object[]{tabelaItens.getRowCount()+1,itemVenda().getProduto().getId(),itemVenda().getProduto().getDescricao(),itemVenda().getQtdproduto(),itemVenda().getProduto().getPreco(),itemVenda().getProduto().getPreco()*itemVenda().getQtdproduto()});
        
        itensDaTabela.add(itemVenda());
        
        
    }
    
    public void computarVenda(){
        
    }
    
    
    

    
}
