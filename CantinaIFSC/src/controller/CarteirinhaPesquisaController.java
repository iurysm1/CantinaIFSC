package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CarteirinhaPesquisa;

public class CarteirinhaPesquisaController implements ActionListener{

    CarteirinhaPesquisa carteirinhaPesquisa;

    public CarteirinhaPesquisaController(CarteirinhaPesquisa carteirinhaPesquisa) {
        this.carteirinhaPesquisa = carteirinhaPesquisa;
        
        this.carteirinhaPesquisa.getSair().addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==this.carteirinhaPesquisa.getSair()){
            this.carteirinhaPesquisa.dispose();
        }
    }
    
}
