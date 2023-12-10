
package controller;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import model.bo.Carteirinha;
import model.bo.Funcionario;
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;
import utilities.Utilities;
import view.CarteirinhaTelaVendas;
import view.Feedback;
import view.FormaDePagamento;
import view.ValorPagamentoDialog;
import view.Vendas;

public class VendaController{

    public static int idCarteirinha=0, valorEmCedulas=0;
    public static String tipopagamento="";
    float valorTotalVenda=0;
    
    Vendas vendas;
    
    private Venda faturacao;
    
    Funcionario funcionario = new Funcionario();
    List<ItemVenda> itensDaTabela = new ArrayList<>();
   
    
    KeyAdapter atalhos = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    if(statusCaixa()){
                        adicionarItemVenda();
                    }
                    vendas.getCodigoBarras().requestFocus();
                    break;
                case KeyEvent.VK_F12:
                    vendas.getCodigoBarras().setEnabled(false);
                    abrirFechar(false);
                    vendas.getCodigoBarras().requestFocus();
                    break;
                 case KeyEvent.VK_ESCAPE:
                    vendas.dispose();
                    vendas.getCodigoBarras().requestFocus();
                    break;
                 case KeyEvent.VK_END:
                     if(statusCaixa()){
                        formaPagamento();
                     }
                     vendas.getCodigoBarras().requestFocus();
                     break;
                default:
                    break;
            }
        }
    };
    
    private KeyEventDispatcher iniciarFaturacao = new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_F1:
                         novaFaturacao();
                         vendas.getCodigoBarras().requestFocus();
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
        this.vendas.getCodigoBarras().addKeyListener(atalhos);
        this.funcionario=service.FuncionarioService.carregar(1);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(iniciarFaturacao);
    }

    
    public void novaFaturacao(){
        abrirFechar(true);
        Venda venda = new Venda();
        
        venda.setStatus("A");
        venda.setObeservacao("");
        venda.setFuncionario(funcionario);
        
        CarteirinhaTelaVendas carteirinha = new CarteirinhaTelaVendas(vendas, true);
        CarteirinhaTelaVendasController carteirinhaController = new CarteirinhaTelaVendasController(carteirinha);
        carteirinha.setVisible(true);
        venda.setCarteirinha(service.CarteirinhaService.carregar(idCarteirinha));
        
        vendas.getCodigoBarras().setEnabled(true);
        venda.setFlagtipodesconto("S");
        venda.setValordesconto(0);
        this.vendas.getCodigoBarras().requestFocus();
        this.faturacao=venda;
        }
    
    public ItemVenda itemVenda(){
       int quantidade=1;
       ItemVenda itemVenda=new ItemVenda();
       Produto produtoAtual = adicionarProduto();
       itemVenda.setVenda(faturacao);
       itemVenda.setProduto(produtoAtual);
       
       if(this.vendas.getCodigoBarras().getText().contains("X")||this.vendas.getCodigoBarras().getText().contains("x")){
            int parametroQuantidade=this.vendas.getCodigoBarras().getText().toUpperCase().indexOf("X");
            quantidade= Integer.parseInt(this.vendas.getCodigoBarras().getText().substring(0, parametroQuantidade));
           
       }
       
       itemVenda.setQtdproduto(quantidade);
       itemVenda.setStatus("A");
       
       
       
        
       return itemVenda; 
    }
    
    public Produto adicionarProduto(){
       
        Produto produtoAtual = new Produto();
        if(this.vendas.getCodigoBarras().getText().toUpperCase().contains("X")){
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
        
        
        if(this.vendas.getCodigoBarras().getText().equalsIgnoreCase("")){
            utilities.Utilities.feedbackErros(7);
        }else if(itemVenda().getProduto().getDescricao()==null){
            Utilities.feedbackErros(8);
        }else{
            DefaultTableModel tabelaItens = (DefaultTableModel) vendas.getItens().getModel();
        
            this.vendas.getNomeDoProduto().setText(itemVenda().getProduto().getDescricao());
            this.vendas.setLabelValorUnitarioItem(itemVenda().getProduto().getPreco()+"");
            this.vendas.setLabelValorTotalItem(itemVenda().getProduto().getPreco()*itemVenda().getQtdproduto()+"");

            tabelaItens.addRow(new Object[]{tabelaItens.getRowCount()+1,itemVenda().getProduto().getId(),itemVenda().getProduto().getDescricao(),itemVenda().getQtdproduto(),itemVenda().getProduto().getPreco(),itemVenda().getProduto().getPreco()*itemVenda().getQtdproduto()});

            itensDaTabela.add(itemVenda());
            
            this.vendas.getCodigoBarras().setText("");
            float valorTotal=0;
            for (ItemVenda itemVenda : itensDaTabela) {
                
                    valorTotal+=itemVenda.getQtdproduto()*itemVenda.getProduto().getPreco();
            }
            this.valorTotalVenda=valorTotal;
            this.vendas.getValorTotalVenda().setText("R$ "+valorTotal);
        }
        
        
        
    }
    
    public void computarVenda(){
        DefaultTableModel tabelaItens = (DefaultTableModel) vendas.getItens().getModel();
        
        if(tabelaItens.getRowCount()==0){
            Utilities.feedbackErros(6);
        }else{
            int faturacaoID = service.VendaService.createReturnID(this.faturacao);
            System.out.println(faturacaoID);
            for (ItemVenda itemVendaAtual : itensDaTabela) {

                faturacao.setId(faturacaoID);
                itemVendaAtual.setVenda(this.faturacao);

                service.ItemVendaService.adicionar(itemVendaAtual);
            }



            tabelaItens.setRowCount(0);

            abrirFechar(false);
            
            Feedback feedback=new Feedback();
            FeedbackController feedbackController= new FeedbackController(feedback);
            feedbackController.cadastroClasse(9);
            feedback.setVisible(true);
            
            ControllerCaixa.listaVendas.add(this.faturacao);
            
        }
    }
    
    public void formaPagamento(){
        FormaDePagamento pagamento = new FormaDePagamento(vendas, true);
        pagamento.setVisible(true);
        this.faturacao.setObeservacao(this.tipopagamento);
        
        if(this.faturacao.getObeservacao().equalsIgnoreCase("")){
            Utilities.feedbackErros(10);
        }else if(this.faturacao.getObeservacao().equalsIgnoreCase("cedula")){
            ValorPagamentoDialog valorPagamento = new ValorPagamentoDialog(vendas, true);
            valorPagamento.setVisible(true);
            
            this.vendas.getValorRecebido().setText("R$ "+valorEmCedulas);
            float troco=valorEmCedulas-valorTotalVenda;
            this.vendas.getTroco().setText("R$ "+troco);
        }
        
        computarVenda();
    }
    
    public void abrirFechar(boolean condicao){
        if(condicao==true){
            this.vendas.setLabelStatusCaixa("Aberto");
            this.vendas.getPainelStatusVenda().setBackground(new Color(40,150,90));
        }else{
            this.vendas.setLabelStatusCaixa("Fechado");
            this.vendas.getPainelStatusVenda().setBackground(new Color(219,58,52));
            this.vendas.getCodigoBarras().setEnabled(false);
            this.faturacao = null;
            this.itensDaTabela.clear();
            idCarteirinha=0;
            tipopagamento="";
            valorEmCedulas=0;
            valorTotalVenda=0;
            this.vendas.getValorTotalVenda().setText("R$ 0.00");
            this.vendas.getValorRecebido().setText("R$ 0.00");
            this.vendas.setLabelValorTotalItem("0.00");
            this.vendas.setLabelValorUnitarioItem("0.00");
            this.vendas.getTroco().setText("R$ 0.00");
        }
    }
    
    public boolean statusCaixa(){
        if(this.vendas.getLabelStatusCaixa().getText().equalsIgnoreCase("Fechado")){
            Utilities.feedbackErros(9);
            return false;
        }else{
            return true;
        }
    }
    
    public void setObservacao(){
        this.faturacao.setObeservacao(tipopagamento);       
    }

    
}
