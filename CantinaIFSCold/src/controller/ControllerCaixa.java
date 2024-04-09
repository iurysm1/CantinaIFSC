
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
    public static boolean statusCaixa=false;
    
    Caixa caixa;
    
    public ControllerCaixa(CaixaView caixa) {
        
        this.caixaView=caixa;
        
        this.caixaView.getPesquisarFuncionario().addActionListener(this);
        this.caixaView.getAbrirCaixa().addActionListener(this);
        this.caixaView.getFecharCaixa().addActionListener(this);
        this.caixaView.getNovoCaixa().addActionListener(this);
        this.caixaView.getIdFuncionario().setEnabled(false);
        this.caixaView.getValorAbertura().setEnabled(false);
        utilities.Utilities.active(true, this.caixaView.getPainelGeral());
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
                 VendaController.idFuncionario=funcionarioAtual.getId();
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
                        this.caixaView.getAbrirCaixa().setEnabled(false);
                        this.caixaView.getNovoCaixa().setEnabled(false);
                        this.caixaView.getPesquisarFuncionario().setEnabled(false);
                        this.caixaView.setStatusCaixa("  Aberto");
                        this.caixaView.getPainelStatus().setBackground(new Color(40,150,90));
                        this.caixaView.getIdFuncionario().setEnabled(false);
                        this.caixaView.getValorAbertura().setEnabled(false);
                        this.statusCaixa=true;
                    }  
                }  
            }else{
                utilities.Utilities.feedbackErros(12);
            }
            
            
            
            
        }else if(e.getSource()==this.caixaView.getFecharCaixa()){
            fecharCaixa();
            this.caixaView.getAbrirCaixa().setEnabled(false);
            this.caixaView.getFecharCaixa().setEnabled(false);
            this.caixaView.getPesquisarFuncionario().setEnabled(false);
        }else if(e.getSource()==this.caixaView.getNovoCaixa()){
            novoCaixa();
        }
    }
    
    
    
    public void fecharCaixa(){
        this.caixaView.getNovoCaixa().setEnabled(false);
        String dataFechamento=service.CaixaService.retornarDataAtual();
        List<Venda> listaVendas= service.VendaService.VendasDateTime(this.caixa.getDatahoraabertura(), dataFechamento);
        //List<Venda> listaVendas= service.VendaService.VendasDateTime("2023-12-11 13:55:06", "2023-12-11 13:55:29");
        System.out.println(dataFechamento+"| data abertura: "+this.caixa.getDatahoraabertura());
        float valorDebito=0, valorCredito=0, valorCedula=0;
        
        for (Venda listaVenda : listaVendas) {
            List<ItemVenda> itensDaVenda=service.ItemVendaService.totalItemVenda(listaVenda.getId());
            System.out.println(listaVenda.getId());
            if(listaVenda.getObeservacao().equalsIgnoreCase("debito")){
                for (ItemVenda itemVenda : itensDaVenda) {
                   valorDebito+=itemVenda.getQtdproduto()*itemVenda.getProduto().getPreco();
                    System.out.println("d: "+itemVenda.getProduto().getPreco()+"-"+itemVenda.getQtdproduto());
                }
            }else if(listaVenda.getObeservacao().equalsIgnoreCase("credito")){
                for (ItemVenda itemVenda : itensDaVenda) {
                   valorCredito+=itemVenda.getQtdproduto()*itemVenda.getProduto().getPreco();
                   System.out.println("Cre: "+itemVenda.getProduto().getPreco()+"-"+itemVenda.getQtdproduto());

                }
            }else if(listaVenda.getObeservacao().equalsIgnoreCase("cedula")){
                for (ItemVenda itemVenda : itensDaVenda) {
                   valorCedula+=itemVenda.getQtdproduto()*itemVenda.getProduto().getPreco();
                   System.out.println("Ce: "+itemVenda.getProduto().getPreco()+"-"+itemVenda.getQtdproduto());
                
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
        
        valorCedula=0;
        valorDebito=0;
        valorCredito=0;
        this.caixaView.getNovoCaixa().setEnabled(true);
        this.caixaView.getIdFuncionario().setEnabled(false);
        this.caixaView.getValorAbertura().setEnabled(false);
        statusCaixa=false;
    }
    
    public void novoCaixa(){
        
        this.caixaView.setDataAbertura("00/00/0000 00:00:00");
        this.caixaView.setDataFechamento("00/00/0000 00:00:00");
        this.caixaView.setValorCedula("0.00");
        this.caixaView.setValorCredito("0.00");
        this.caixaView.setValorDebito("0.00");
        this.caixaView.setValorFechamento("0.00");
        utilities.Utilities.active(false, this.caixaView.getPainelGeral());
        utilities.Utilities.limpaComponentes(true, this.caixaView.getPainelGeral());
        this.caixaView.getIdFuncionario().setEnabled(true);
        this.caixaView.getValorAbertura().setEnabled(true);
        this.caixaView.getNomeFuncionario().setEnabled(false);
        this.caixa=null;
        
    }
    
}
