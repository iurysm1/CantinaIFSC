
package controller;

import model.DAO.Persiste;
import static model.DAO.Persiste.clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Cliente;
import view.ClientePesquisa;



public class ClientePesquisaController implements ActionListener{
    ClientePesquisa clientePesquisa;
    
    public ClientePesquisaController(ClientePesquisa clientePesquisa) {
        this.clientePesquisa=clientePesquisa;
        
        this.clientePesquisa.getSair().addActionListener(this);
        this.clientePesquisa.getCarregar().addActionListener(this);
        this.clientePesquisa.getPesquisar().addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.clientePesquisa.getSair()){
            this.clientePesquisa.dispose();
        }else if(e.getSource()==this.clientePesquisa.getCarregar()){
            ClienteRegistroController.codigo=(int) this.clientePesquisa.getTabelaDados().getValueAt(this.clientePesquisa.getTabelaDados().getSelectedRow(), 0);
            this.clientePesquisa.dispose();
            CarteirinhaRegistroController.codigoCliente=(int) this.clientePesquisa.getTabelaDados().getValueAt(this.clientePesquisa.getTabelaDados().getSelectedRow(), 0);
            this.clientePesquisa.dispose();
            
            
        }else if (e.getSource()==this.clientePesquisa.getPesquisar()){
            Persiste.getInstance();
            
            DefaultTableModel tabela = (DefaultTableModel) this.clientePesquisa.getTabelaDados().getModel();
            
            if(tabela.getRowCount()==0){
            for (Cliente cliente : clientes) {
                tabela.addRow(new Object[]{cliente.getId(),cliente.getCpf(),cliente.getNome()});
            }
            }
            
        }
    }
    
}
