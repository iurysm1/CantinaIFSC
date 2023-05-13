
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import view.ProdutoAdicionarFoto;

public class ProdutoAdicionarFotoController implements ActionListener{
    
    ProdutoAdicionarFoto produtoAdicionarFoto;

    public ProdutoAdicionarFotoController(ProdutoAdicionarFoto produtoAdicionarFoto) {
        this.produtoAdicionarFoto = produtoAdicionarFoto;
        this.produtoAdicionarFoto.getjFileChooser1();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.produtoAdicionarFoto.getjFileChooser1()){
            this.produtoAdicionarFoto.dispose();
        }
        
    }
    
}
