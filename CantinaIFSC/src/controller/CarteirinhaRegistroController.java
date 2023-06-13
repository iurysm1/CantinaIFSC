
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Carteirinha;
import utilities.Utilities;
import view.CarteirinhaPesquisa;
import view.CarteirinhaRegistro;

public class CarteirinhaRegistroController implements ActionListener{
    
    CarteirinhaRegistro carteirinhaRegistro;

    public CarteirinhaRegistroController(CarteirinhaRegistro carteirinhaRegistro) {
        this.carteirinhaRegistro = carteirinhaRegistro;
        
        this.carteirinhaRegistro.getNovo().addActionListener(this);
        this.carteirinhaRegistro.getGravar().addActionListener(this);
        this.carteirinhaRegistro.getCancelar().addActionListener(this);
        this.carteirinhaRegistro.getPesquisar().addActionListener(this);
        this.carteirinhaRegistro.getSair().addActionListener(this);
        
        Utilities.active(true, this.carteirinhaRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.carteirinhaRegistro.getPainelDados());
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.carteirinhaRegistro.getNovo()){
            Utilities.active(false, this.carteirinhaRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.carteirinhaRegistro.getPainelDados());
        }else if(e.getSource()==this.carteirinhaRegistro.getGravar()){
            Carteirinha carteirinha = new Carteirinha();
            
            carteirinha.setId(DAO.Persiste.carteirinhas.size()+1);
            carteirinha.setDatageracao(this.carteirinhaRegistro.getDataCriacao().getText());
            carteirinha.setDatacancelamento(this.carteirinhaRegistro.getDataCancelamento().getText());
            carteirinha.setCodigobarra(this.carteirinhaRegistro.getCodigoBarra().getText());
            
            Utilities.active(true, this.carteirinhaRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.carteirinhaRegistro.getPainelDados());
        }else if(e.getSource()==this.carteirinhaRegistro.getCancelar()){
            Utilities.active(true, this.carteirinhaRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.carteirinhaRegistro.getPainelDados());
        }else if(e.getSource()==this.carteirinhaRegistro.getPesquisar()){
            CarteirinhaPesquisa carteirinhaPesquisa=new CarteirinhaPesquisa();
            CarteirinhaPesquisaController carteirinhaPesquisaController=new CarteirinhaPesquisaController(carteirinhaPesquisa);
            carteirinhaPesquisa.setVisible(true);
        }else if(e.getSource()==this.carteirinhaRegistro.getSair()){
            this.carteirinhaRegistro.dispose();
        }
        
    }
    
}
