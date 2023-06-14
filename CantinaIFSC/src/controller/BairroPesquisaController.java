package controller;

import DAO.Persiste;
import static controller.BairroRegistroController.codigo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import view.BairroPesquisa;


public class BairroPesquisaController implements ActionListener{
    
    BairroPesquisa bairroPesquisa;
    
    
    public BairroPesquisaController(BairroPesquisa bairroPesquisa) {
        
        this.bairroPesquisa=bairroPesquisa;
        
        
        this.bairroPesquisa.getCarregar().addActionListener(this);
        this.bairroPesquisa.getSair().addActionListener(this);
        this.bairroPesquisa.getPesquisar().addActionListener(this);

               
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.bairroPesquisa.getCarregar()){
            
            controller.EnderecoRegistroController.codigoBairro=(int) this.bairroPesquisa.getTabelaDados().getValueAt(this.bairroPesquisa.getTabelaDados().getSelectedRow(), 0);
           controller.BairroRegistroController.codigo=(int) this.bairroPesquisa.getTabelaDados().getValueAt(this.bairroPesquisa.getTabelaDados().getSelectedRow(), 0);
           
            this.bairroPesquisa.dispose();
 
        }else if(e.getSource()==this.bairroPesquisa.getSair()){
            this.bairroPesquisa.dispose();
        }else if(e.getSource()==this.bairroPesquisa.getPesquisar()){
            DAO.Persiste.getInstance();
            
            
            
            DefaultTableModel tabela = (DefaultTableModel) this.bairroPesquisa.getTabelaDados().getModel();
            int contador = tabela.getRowCount();
            for (int i = contador; i > 0; i--) {
                tabela.removeRow(i);
            }
            
            for (Bairro bairroAtual : Persiste.bairros) {
                tabela.addRow(new Object[]{bairroAtual.getId(),bairroAtual.getDescricao()});
            }
            
            
            
            
        }
    }
    
    
    
}
