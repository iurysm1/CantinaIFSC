
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.plaf.FileChooserUI;
import view.ProdutoAdicionarFoto;

public class ProdutoAdicionarFotoController implements ActionListener{
    
    ProdutoAdicionarFoto produtoAdicionarFoto;

    public ProdutoAdicionarFotoController(ProdutoAdicionarFoto produtoAdicionarFoto) {
        this.produtoAdicionarFoto = produtoAdicionarFoto;
        this.produtoAdicionarFoto.getjFileChooser1().addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.produtoAdicionarFoto.getjFileChooser1()){
             String caminho=this.produtoAdicionarFoto.getjFileChooser1().getSelectedFile().getAbsolutePath();
             
             int opcao=this.produtoAdicionarFoto.getjFileChooser1().showOpenDialog(this.produtoAdicionarFoto);
             
            if(opcao==JFileChooser.APPROVE_OPTION){
                    ProdutoRegistroController.caminhoArquivo= caminho;
                this.produtoAdicionarFoto.dispose();
            }else{
                
                this.produtoAdicionarFoto.dispose();
            }
        }
        
    }
    
}
