
package controller;

import DAO.Persiste;
import static DAO.Persiste.clientes;
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
            
        }else if (e.getSource()==this.clientePesquisa.getPesquisar()){
            Persiste.getInstance();
            
            DefaultTableModel tabela = (DefaultTableModel) this.clientePesquisa.getTabelaDados().getModel();
            for (Cliente cliente : clientes) {
                tabela.addRow(new Object[]{cliente.getId(),cliente.getNome(),cliente.getCpf()});
            }
            
            
        }
    }
    
}
