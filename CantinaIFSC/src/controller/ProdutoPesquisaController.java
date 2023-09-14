
package controller;

import model.DAO.Persiste;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    
    ListSelectionListener selectionListener = new ListSelectionListener() {
        
        @Override
        public void valueChanged(ListSelectionEvent e){
            if(e.getValueIsAdjusting()){
                int selectedRow = produtoPesquisa.getTabelaDados().getSelectedRow();
                if(selectedRow!=-1){
                    int selectedItem= (int) produtoPesquisa.getTabelaDados().getValueAt(selectedRow, 0)-1;
                    ImageIcon icon = new ImageIcon(model.DAO.Persiste.produtos.get(selectedItem).getCaminhoFotoProduto());
                    
                    produtoPesquisa.setIcon(icon);
                    produtoPesquisa.getPainelFoto().setBackground(Color.white);
                }
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.produtoPesquisa.getSair()){
            controller.ProdutoRegistroController.codigo=0;
            this.produtoPesquisa.dispose();
            
        }else if(e.getSource()==this.produtoPesquisa.getPesquisar()){
            DefaultTableModel tabela = (DefaultTableModel) this.produtoPesquisa.getTabelaDados().getModel();
            this.produtoPesquisa.getTabelaDados().getSelectionModel().addListSelectionListener(selectionListener);
            if(tabela.getRowCount()==0)
            for (Produto produtoAtual : Persiste.produtos) {
                tabela.addRow(new Object[]{produtoAtual.getId(),produtoAtual.getDescricao(),produtoAtual.getCodigobarra(), produtoAtual.getPreco()});
            }
            
            
        }else if(e.getSource()==this.produtoPesquisa.getCarregar()){
            controller.ProdutoRegistroController.codigo=(int) this.produtoPesquisa.getTabelaDados().getValueAt(this.produtoPesquisa.getTabelaDados().getSelectedRow(), 0);
            
            this.produtoPesquisa.dispose();
        }
    }
    
    
    
}
