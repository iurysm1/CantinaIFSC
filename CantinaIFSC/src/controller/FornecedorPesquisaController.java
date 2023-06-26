
package controller;

import DAO.Persiste;
import static DAO.Persiste.fornecedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Fornecedor;
import view.FornecedorPesquisa;

public class FornecedorPesquisaController implements ActionListener{

    FornecedorPesquisa fornecedorPesquisa;
    
    public FornecedorPesquisaController(FornecedorPesquisa fornecedorPesquisa) {
        this.fornecedorPesquisa = fornecedorPesquisa;
        
        this.fornecedorPesquisa.getSair().addActionListener(this);
        this.fornecedorPesquisa.getPesquisar().addActionListener(this);
        this.fornecedorPesquisa.getCarregar().addActionListener(this);
    }


    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.fornecedorPesquisa.getSair()){
            this.fornecedorPesquisa.dispose();
        }else if(e.getSource()==this.fornecedorPesquisa.getPesquisar()){
            Persiste.getInstance();
            
            DefaultTableModel tabela = (DefaultTableModel) this.fornecedorPesquisa.getTabelaDados().getModel();
            if(tabela.getRowCount()==0){
            for (Fornecedor fornecedorAtual : fornecedores) {
                
                tabela.addRow(new Object[]{fornecedorAtual.getId(),fornecedorAtual.getCnpj(),fornecedorAtual.getNome()});
            }
            }
        }else if (e.getSource()==this.fornecedorPesquisa.getCarregar()){
            FornecedorRegistroController.codigo=(int) this.fornecedorPesquisa.getTabelaDados().getValueAt(this.fornecedorPesquisa.getTabelaDados().getSelectedRow(), 0);
            this.fornecedorPesquisa.dispose();
            
        }
    }
    
}
