
package controller;

import DAO.Persiste;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Produto;
import view.ProdutoPesquisa;

public class ProdutoPesquisaController implements ActionListener{
    
    ProdutoPesquisa produtoPesquisa;

    public ProdutoPesquisaController(ProdutoPesquisa produtoPesquisa) {
        this.produtoPesquisa = produtoPesquisa;
        
        this.produtoPesquisa.getSair().addActionListener(this);
        this.produtoPesquisa.getPesquisar().addActionListener(this);
        this.produtoPesquisa.getCarregar().addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.produtoPesquisa.getSair()){
            this.produtoPesquisa.dispose();
            
        }else if(e.getSource()==this.produtoPesquisa.getPesquisar()){
            DefaultTableModel tabela = (DefaultTableModel) this.produtoPesquisa.getTabelaDados().getModel();
            int contador=tabela.getRowCount();
            for (int i = contador; i > 0; i--) {
                tabela.removeRow(i);
            }
            for (Produto produtoAtual : Persiste.produtos) {
                tabela.addRow(new Object[]{produtoAtual.getId(),produtoAtual.getDescricao(),produtoAtual.getCodigobarra(), produtoAtual.getPreco()});
            }
        }else if(e.getSource()==this.produtoPesquisa.getCarregar()){
            controller.ProdutoRegistroController.codigo=(int) this.produtoPesquisa.getTabelaDados().getValueAt(this.produtoPesquisa.getTabelaDados().getSelectedRow(), 0);
            
            this.produtoPesquisa.dispose();
        }
    }
    
}
