
package controller;

import model.DAO.Persiste;

import static model.DAO.Persiste.cidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


import model.bo.Cidade;
import view.CidadePesquisa;

public class CidadePesquisaController implements ActionListener{

    CidadePesquisa cidadePesquisa;
    
    

    public CidadePesquisaController(CidadePesquisa cidadePesquisa) {
        this.cidadePesquisa=cidadePesquisa;
        
        this.cidadePesquisa.getSair().addActionListener(this);
        this.cidadePesquisa.getCarregar().addActionListener(this);
        this.cidadePesquisa.getPesquisar().addActionListener(this);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.cidadePesquisa.getSair()){
            this.cidadePesquisa.dispose();
            
            
        }else if(e.getSource()==this.cidadePesquisa.getPesquisar()){
            Persiste.getInstance();
             
            
            
            DefaultTableModel tabela = (DefaultTableModel) this.cidadePesquisa.getTabelaDados().getModel();

            if(tabela.getRowCount()==0){
            for (Cidade cidadeAtual : cidades) {
                tabela.addRow(new Object[]{cidadeAtual.getId(), cidadeAtual.getUf(), cidadeAtual.getDescricao()});
            }
            }
            
        }else if(e.getSource()==this.cidadePesquisa.getCarregar()){
            controller.EnderecoRegistroController.codigoCidade=(int) this.cidadePesquisa.getTabelaDados().getValueAt(this.cidadePesquisa.getTabelaDados().getSelectedRow(), 0);
            controller.CidadeRegistroController.codigo=(int) this.cidadePesquisa.getTabelaDados().getValueAt(this.cidadePesquisa.getTabelaDados().getSelectedRow(), 0);
            
          this.cidadePesquisa.dispose();
        }
        
    }
    
}
