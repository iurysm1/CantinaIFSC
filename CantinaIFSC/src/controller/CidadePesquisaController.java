
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CidadePesquisa;

public class CidadePesquisaController implements ActionListener{

    CidadePesquisa cidadePesquisa;
    
    

    public CidadePesquisaController(CidadePesquisa cidadePesquisa) {
        this.cidadePesquisa=cidadePesquisa;
        
        this.cidadePesquisa.getSair().addActionListener(this);
        this.cidadePesquisa.getCarregar().addActionListener(this);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.cidadePesquisa.getSair()){
            this.cidadePesquisa.dispose();
        }
        
    }
    
}
