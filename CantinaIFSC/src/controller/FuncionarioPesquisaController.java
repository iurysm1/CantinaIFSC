
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FuncionarioPesquisa;

class FuncionarioPesquisaController implements ActionListener{
    
    FuncionarioPesquisa funcionarioPesquisa;

    public FuncionarioPesquisaController(FuncionarioPesquisa funcionarioPesquisa) {
        this.funcionarioPesquisa=funcionarioPesquisa;
        
        this.funcionarioPesquisa.getSair().addActionListener(this);
        this.funcionarioPesquisa.getCarregar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.funcionarioPesquisa.getSair()){
            this.funcionarioPesquisa.dispose();
        }
    }
    
}
