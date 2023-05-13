
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EnderecoPesquisa;

public class EnderecoPesquisaController implements ActionListener{

    EnderecoPesquisa enderecoPesquisa;

    public EnderecoPesquisaController(EnderecoPesquisa enderecoPesquisa) {
        
        this.enderecoPesquisa=enderecoPesquisa;
        
        this.enderecoPesquisa.getSair().addActionListener(this);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==this.enderecoPesquisa.getSair()){
           this.enderecoPesquisa.dispose();

       }
    }
    
}
