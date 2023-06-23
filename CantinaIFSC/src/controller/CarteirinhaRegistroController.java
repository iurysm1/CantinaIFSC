
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import model.bo.Carteirinha;
import model.bo.Cliente;
import utilities.Utilities;
import view.CarteirinhaPesquisa;
import view.CarteirinhaRegistro;
import view.ClientePesquisa;
import view.Feedback;

public class CarteirinhaRegistroController implements ActionListener{
    
    CarteirinhaRegistro carteirinhaRegistro;
    public static int codigo, codigoCliente, idCliente;
    
    public CarteirinhaRegistroController(CarteirinhaRegistro carteirinhaRegistro) {
        this.carteirinhaRegistro = carteirinhaRegistro;
        
        this.carteirinhaRegistro.getNovo().addActionListener(this);
        this.carteirinhaRegistro.getGravar().addActionListener(this);
        this.carteirinhaRegistro.getCancelar().addActionListener(this);
        this.carteirinhaRegistro.getPesquisar().addActionListener(this);
        this.carteirinhaRegistro.getSair().addActionListener(this);
        this.carteirinhaRegistro.getPesquisarCliente().addActionListener(this); 
        
        Utilities.active(true, this.carteirinhaRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.carteirinhaRegistro.getPainelDados());
        
    }
    
    WindowListener disposeListener = new WindowAdapter() {
        
        @Override
        public void windowClosed(WindowEvent e){
            
            if(codigo!=0){
                Carteirinha carteirinha = new Carteirinha();
                carteirinha=DAO.Persiste.carteirinhas.get(codigo-1);
                Utilities.active(false, carteirinhaRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, carteirinhaRegistro.getPainelDados());
                
                carteirinhaRegistro.getId().setText(carteirinha.getId()+"");
                carteirinhaRegistro.getCodigoBarra().setText(carteirinha.getCodigobarra());
                carteirinhaRegistro.getDataCriacao().setText(carteirinha.getDatageracao());
                carteirinhaRegistro.getDataCancelamento().setText(carteirinha.getDatacancelamento());
                carteirinhaRegistro.getIdCliente().setText(carteirinha.getCliente().getId()+"");
                carteirinhaRegistro.getNomeCliente().setText(carteirinha.getCliente().getNome());
                
                carteirinhaRegistro.getId().setEnabled(false);
                carteirinhaRegistro.getIdCliente().setEnabled(false);
                carteirinhaRegistro.getNomeCliente().setEnabled(false);
                
                
            }
        }
    };
    
    WindowListener disposeListenerCliente = new WindowAdapter() {
        
        @Override
        public void windowClosed(WindowEvent e){
            if(codigoCliente!=0){
            Cliente cliente = new Cliente();
            cliente=DAO.Persiste.clientes.get(codigoCliente-1);
            idCliente=cliente.getId()-1;
            
            carteirinhaRegistro.getIdCliente().setText(cliente.getId()+"");
            carteirinhaRegistro.getNomeCliente().setText(cliente.getNome());
            
            carteirinhaRegistro.getIdCliente().setEnabled(false);
            carteirinhaRegistro.getNomeCliente().setEnabled(false);
        }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.carteirinhaRegistro.getNovo()){
            Utilities.active(false, this.carteirinhaRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.carteirinhaRegistro.getPainelDados());
            this.carteirinhaRegistro.getId().setEnabled(false);
            this.carteirinhaRegistro.getIdCliente().setEnabled(false);
        }else if(e.getSource()==this.carteirinhaRegistro.getGravar()){
            Carteirinha carteirinha = new Carteirinha();
            
            carteirinha.setId(DAO.Persiste.carteirinhas.size()+1);
            carteirinha.setDatageracao(this.carteirinhaRegistro.getDataCriacao().getText());
            carteirinha.setDatacancelamento(this.carteirinhaRegistro.getDataCancelamento().getText());
            carteirinha.setCodigobarra(this.carteirinhaRegistro.getCodigoBarra().getText());
            carteirinha.setCliente(DAO.Persiste.clientes.get(idCliente));
            Feedback feedback=new Feedback();
            FeedbackController feedbackController= new FeedbackController(feedback);
            
            if(this.carteirinhaRegistro.getId().getText().equalsIgnoreCase("")){
                DAO.Persiste.carteirinhas.add(carteirinha);
                feedbackController.codigoFB=5;
                feedbackController.cadastroClasse();            
            }else{
                 int index = Integer.parseInt(this.carteirinhaRegistro.getId().getText())-1;
                 
                 DAO.Persiste.carteirinhas.get(index).setCliente(DAO.Persiste.clientes.get(idCliente));
                 
                 DAO.Persiste.carteirinhas.get(index).setCodigobarra(this.carteirinhaRegistro.getCodigoBarra().getText());
                 DAO.Persiste.carteirinhas.get(index).setDatacancelamento(this.carteirinhaRegistro.getDataCancelamento().getText());
                 DAO.Persiste.carteirinhas.get(index).setDatageracao(this.carteirinhaRegistro.getDataCriacao().getText());
                 feedbackController.codigoFB=5;
                feedbackController.atualizacaoClasse();
            }
            
            feedback.setVisible(true);
            Utilities.active(true, this.carteirinhaRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.carteirinhaRegistro.getPainelDados());
        }else if(e.getSource()==this.carteirinhaRegistro.getCancelar()){
            Utilities.active(true, this.carteirinhaRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.carteirinhaRegistro.getPainelDados());
        }else if(e.getSource()==this.carteirinhaRegistro.getPesquisar()){
            CarteirinhaPesquisa carteirinhaPesquisa=new CarteirinhaPesquisa();
            CarteirinhaPesquisaController carteirinhaPesquisaController=new CarteirinhaPesquisaController(carteirinhaPesquisa);
            carteirinhaPesquisa.addWindowListener(disposeListener);
            carteirinhaPesquisa.setVisible(true);
        }else if(e.getSource()==this.carteirinhaRegistro.getSair()){
            this.carteirinhaRegistro.dispose();
        }else if(e.getSource()==this.carteirinhaRegistro.getPesquisarCliente()){
            ClientePesquisa clientePesquisa=new ClientePesquisa();
            ClientePesquisaController clientePesquisaController = new ClientePesquisaController(clientePesquisa);
            clientePesquisa.addWindowListener(disposeListenerCliente);
            clientePesquisa.setVisible(true);
        }
        
    }
    
}
