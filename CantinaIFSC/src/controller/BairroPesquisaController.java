package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Utilities;
import view.BairroPesquisa;

public class BairroPesquisaController implements ActionListener{

    BairroPesquisa bairroPesquisa;

    public BairroPesquisaController(BairroPesquisa bairroPesquisa) {
        
        this.bairroPesquisa=bairroPesquisa;
        
        this.bairroPesquisa.getCarregar().addActionListener(this);
        this.bairroPesquisa.getSair().addActionListener(this);

        Utilities.active(true, this.bairroPesquisa.getPainelBotoes());
               
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.bairroPesquisa.getCarregar()){
            
        }else if(e.getSource()==this.bairroPesquisa.getSair()){
            this.bairroPesquisa.dispose();
        }
    }
    
    
    
}
