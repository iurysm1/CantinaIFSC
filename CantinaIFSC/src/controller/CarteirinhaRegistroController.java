
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import model.DAO.Persiste;
import model.bo.Carteirinha;
import model.bo.Cliente;
import service.CarteirinhaService;
import service.ClienteService;
import utilities.Utilities;
import view.CarteirinhaPesquisa;
import view.CarteirinhaRegistro;
import view.ClientePesquisa;
import view.Feedback;
import view.FeedbackENDERECO;

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
        this.carteirinhaRegistro.getCodigoBarra().addFocusListener(focusCodigo);
        this.carteirinhaRegistro.getDataCriacao().addFocusListener(focusDataCriacao);
        this.carteirinhaRegistro.getDataCancelamento().addFocusListener(focusDataCancelamento);
        this.carteirinhaRegistro.getIdCliente().addFocusListener(focusCliente);
        
        
        Utilities.active(true, this.carteirinhaRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.carteirinhaRegistro.getPainelDados());
        
    }
    
    FocusListener focusCodigo = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnTextFieldGray(carteirinhaRegistro.getCodigoBarra());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnTextFieldRed(carteirinhaRegistro.getCodigoBarra());
        }
    };
    
    FocusListener focusCliente = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            Utilities.turnTextFieldGray(carteirinhaRegistro.getIdCliente());
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            
            Utilities.turnTextFieldRed(carteirinhaRegistro.getIdCliente());
            if(carteirinhaRegistro.getIdCliente().getText().equalsIgnoreCase("*Campo obrigatório*")){
                carteirinhaRegistro.getIdCliente().setText("");
            }
                    
        }
    };
    
    FocusListener focusDataCriacao = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(carteirinhaRegistro.getDataCriacao());
            
        }

        @Override
        public void focusLost(FocusEvent e) {
                
            
             Utilities.turnCepTextFieldRed(carteirinhaRegistro.getDataCriacao());
            
        }
    };
    
    FocusListener focusDataCancelamento = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(carteirinhaRegistro.getDataCancelamento());
            
        }

        @Override
        public void focusLost(FocusEvent e) {
                
            
             Utilities.turnCepTextFieldRed(carteirinhaRegistro.getDataCancelamento());
            
        }
    };
    
    WindowListener disposeListener = new WindowAdapter() {
        
        @Override
        public void windowClosed(WindowEvent e){
            
            if(codigo!=0){
                Carteirinha carteirinha = new Carteirinha();
                carteirinha=CarteirinhaService.carregar(codigo);
                Utilities.active(false, carteirinhaRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, carteirinhaRegistro.getPainelDados());
                
                carteirinhaRegistro.getId().setText(carteirinha.getId()+"");
                carteirinhaRegistro.getCodigoBarra().setText(carteirinha.getCodigobarra());
                carteirinhaRegistro.getDataCriacao().setText(carteirinha.getDatageracao());
                carteirinhaRegistro.getDataCancelamento().setText(carteirinha.getDatacancelamento());
                carteirinhaRegistro.getIdCliente().setText(carteirinha.getCliente().getId()+"");
                carteirinhaRegistro.getNomeCliente().setText(carteirinha.getCliente().getNome());
                
                carteirinhaRegistro.getId().setEnabled(false);
                carteirinhaRegistro.getNomeCliente().setEnabled(false);
                
                idCliente=carteirinha.getCliente().getId();
                
                if(carteirinha.getStatus().equalsIgnoreCase("A")){
                    carteirinhaRegistro.getStatus().setSelectedIndex(0);
                }else{
                    carteirinhaRegistro.getStatus().setSelectedIndex(1);
                }
                carteirinhaRegistro.getDataCriacao().setEnabled(false);
                
            }
        }
    };
    
    WindowListener disposeListenerCliente = new WindowAdapter() {
        
        @Override
        public void windowClosed(WindowEvent e){
            if(codigoCliente!=0){
            Cliente cliente = new Cliente();
            cliente=ClienteService.carregar(codigoCliente);
            idCliente=cliente.getId();
            Utilities.turnTextFieldGray(carteirinhaRegistro.getIdCliente());
            carteirinhaRegistro.getIdCliente().setText(cliente.getId()+"");
            carteirinhaRegistro.getNomeCliente().setText(cliente.getNome());
            
            carteirinhaRegistro.getId().setEnabled(false);
            carteirinhaRegistro.getNomeCliente().setEnabled(false);
        }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.carteirinhaRegistro.getNovo()){
            Utilities.active(false, this.carteirinhaRegistro.getPainelBotoes());
            this.carteirinhaRegistro.getDataCriacao().setEnabled(false);
            Utilities.limpaComponentes(true, this.carteirinhaRegistro.getPainelDados());
            
            this.carteirinhaRegistro.getId().setEnabled(false);
            this.carteirinhaRegistro.getNomeCliente().setEnabled(false);
        }else if(e.getSource()==this.carteirinhaRegistro.getGravar()){
            
            if(Utilities.isDataEmpty(this.carteirinhaRegistro.getMatricula(),this.carteirinhaRegistro.getIdCliente())||Utilities.isFormattedDataEmpty(this.carteirinhaRegistro.getDataCancelamento(),this.carteirinhaRegistro.getDataCriacao())){
                FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                FeedbackEnderecoController.codigoFB=4;
                feedbackEnderecoController.atualizacaoLabel();
                feedbackENDERECO.setVisible(true);
            }else{
               Carteirinha carteirinha = new Carteirinha();
            
                carteirinha.setDatageracao(this.carteirinhaRegistro.getDataCriacao().getText());
                carteirinha.setDatacancelamento(this.carteirinhaRegistro.getDataCancelamento().getText());
                carteirinha.setCodigobarra(this.carteirinhaRegistro.getCodigoBarra().getText());
                carteirinha.setCliente(ClienteService.carregar(idCliente));

                if(carteirinhaRegistro.getStatus().getSelectedIndex()==0){
                        carteirinha.setStatus("A");
                    }else{
                        carteirinha.setStatus("B");
                    }

                Feedback feedback=new Feedback();
                FeedbackController feedbackController= new FeedbackController(feedback);

                if(this.carteirinhaRegistro.getId().getText().equalsIgnoreCase("")){
                    CarteirinhaService.adicionar(carteirinha);
                    feedbackController.cadastroClasse(5);            
                }else{
                    carteirinha.setId(Integer.parseInt(this.carteirinhaRegistro.getId().getText()));
                     CarteirinhaService.atualizar(carteirinha);
                    feedbackController.atualizacaoClasse(5);
                }

                feedback.setVisible(true);
                Utilities.active(true, this.carteirinhaRegistro.getPainelBotoes());
                Utilities.limpaComponentes(false, this.carteirinhaRegistro.getPainelDados()); 
            }
            
            
            
    
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
            
            if(this.carteirinhaRegistro.getIdCliente().getText().equals("")){
                ClientePesquisa clientePesquisa=new ClientePesquisa();
                ClientePesquisaController clientePesquisaController = new ClientePesquisaController(clientePesquisa);
                clientePesquisa.addWindowListener(disposeListenerCliente);
                clientePesquisa.setVisible(true);
    
            }else{
                 Cliente cliente = ClienteService.carregar(Integer.parseInt(this.carteirinhaRegistro.getIdCliente().getText()));
                if(cliente.getId()==0){
                    FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                    FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                    feedbackEnderecoController.codigoFB=3;
                    feedbackEnderecoController.atualizacaoLabel();
                    feedbackENDERECO.setVisible(true);
                    this.carteirinhaRegistro.getIdCliente().setText("");
                }else{
                   
                    idCliente=cliente.getId();
                    this.carteirinhaRegistro.getNomeCliente().setText(cliente.getNome());
                    this.carteirinhaRegistro.getIdCliente().setText(cliente.getId()+"");
                }
            }
            
        }
        
    }
    
}
