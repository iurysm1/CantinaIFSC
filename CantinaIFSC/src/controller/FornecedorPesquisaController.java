
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FornecedorPesquisa;

public class FornecedorPesquisaController implements ActionListener{

    FornecedorPesquisa fornecedorPesquisa;
    
    public FornecedorPesquisaController(FornecedorPesquisa fornecedorPesquisa) {
        this.fornecedorPesquisa = fornecedorPesquisa;
        
        this.fornecedorPesquisa.getSair().addActionListener(this);
    }


    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.fornecedorPesquisa.getSair()){
            this.fornecedorPesquisa.dispose();
        }
    }
    
}
