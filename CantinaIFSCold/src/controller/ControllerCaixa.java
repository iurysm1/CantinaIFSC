
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.bo.Caixa;
import model.bo.Funcionario;
import model.bo.ItemVenda;
import model.bo.Venda;
import view.CaixaView;

public class ControllerCaixa implements ActionListener{
    CaixaView caixaView;
    Funcionario funcionario=new Funcionario();
    public static List<Venda> listaVendas= new ArrayList<>();
    
    
    Caixa caixa;
    
    public ControllerCaixa(CaixaView caixa) {
        
        this.caixaView=caixa;
        
        this.caixaView.getPesquisarFuncionario().addActionListener(this);
        this.caixaView.getAbrirCaixa().addActionListener(this);
        this.caixaView.getFecharCaixa().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.caixaView.getPesquisarFuncionario()){
            this.caixa=new Caixa();
            
            
            if(this.caixaView.getIdFuncionario().getText().equalsIgnoreCase("")||!utilities.Utilities.isNumeric(this.caixaView.getIdFuncionario().getText())){
                 
              utilities.Utilities.feedbackErros(11);
            }else{
                Funcionario funcionarioAtual=service.FuncionarioService.carregar(Integer.parseInt(this.caixaView.getIdFuncionario().getText()));  
              
                if(funcionarioAtual.getNome()==null){
                 utilities.Utilities.feedbackErros(11);
              }else{

                 this.funcionario=funcionarioAtual;
                 this.caixaView.getNomeFuncionario().setText(this.funcionario.getNome());             
              } 
            }
          
                  
            
            
        }else if(e.getSource()==this.caixaView.getAbrirCaixa()){      
            if(this.funcionario.getNome()!=null){               
                if(!this.caixaView.getValorAbertura().getText().equalsIgnoreCase("")){
                    if(utilities.Utilities.isNumeric(this.caixaView.getValorAbertura().getText())){
                        this.caixa.setStatus("A");
                        this.caixa.setObservacao("Testes");
                        this.caixa.setFuncionario(this.funcionario);
                        this.caixa.setDatahoraabertura(service.CaixaService.retornarDataAtual());
                        this.caixa.setValorabertura(Integer.parseInt(this.caixaView.getValorAbertura().getText()));
                        
                        this.caixaView.setStatusCaixa("  Aberto");
                        this.caixaView.getPainelStatus().setBackground(new Color(40,150,90));
                    }  
                }  
            }else{
                utilities.Utilities.feedbackErros(12);
            }
            
            
            
            
        }else if(e.getSource()==this.caixaView.getFecharCaixa()){
            fecharCaixa();
        }
    }
    
    
    
    public void fecharCaixa(){
        String dataFechamento=service.CaixaService.retornarDataAtual();
        float valorDebito=0, valorCredito=0, valorCedula=0;
        
        for (Venda listaVenda : listaVendas) {
            List<ItemVenda> itensDaVenda=service.ItemVendaService.totalItemVenda(listaVenda.getId());

            if(listaVenda.getObeservacao().equalsIgnoreCase("debito")){
                for (ItemVenda itemVenda : itensDaVenda) {
                   valorDebito+=itemVenda.getQtdproduto()*itemVenda.getProduto().getPreco();
                }
            }else if(listaVenda.getObeservacao().equalsIgnoreCase("credito")){
                for (ItemVenda itemVenda : itensDaVenda) {
                   valorCredito+=itemVenda.getQtdproduto()*itemVenda.getProduto().getPreco();
                }
            }else if(listaVenda.getObeservacao().equalsIgnoreCase("cedula")){
                for (ItemVenda itemVenda : itensDaVenda) {
                   valorCedula+=itemVenda.getQtdproduto()*itemVenda.getProduto().getPreco();
                }
            }
        }
        
        this.caixa.setDatahorafechamento(dataFechamento);
        this.caixa.setValorfechamento(valorCredito+valorCedula+valorDebito);
        
        this.caixaView.setDataAbertura(this.caixa.getDatahoraabertura());
        this.caixaView.setDataFechamento(dataFechamento);
        this.caixaView.setValorCedula(valorCedula+"");
        this.caixaView.setValorCredito(valorCredito+"");
        this.caixaView.setValorDebito(valorDebito+"");
        this.caixaView.setValorFechamento(this.caixa.getValorfechamento()+"");
        System.out.println(this.caixa.getValorfechamento());
    }
    
    
    
}
