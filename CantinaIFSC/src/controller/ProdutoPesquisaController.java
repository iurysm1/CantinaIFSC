
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ProdutoPesquisa;

public class ProdutoPesquisaController implements ActionListener{
    
    ProdutoPesquisa produtoPesquisa;

    public ProdutoPesquisaController(ProdutoPesquisa produtoPesquisa) {
        this.produtoPesquisa = produtoPesquisa;
        
        this.produtoPesquisa.getSair().addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.produtoPesquisa.getSair()){
            this.produtoPesquisa.dispose();
        }
    }
    
}
