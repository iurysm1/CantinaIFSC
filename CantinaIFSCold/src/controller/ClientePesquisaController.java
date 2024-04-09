
package controller;

import model.DAO.Persiste;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Cliente;
import service.ClienteService;
import view.ClientePesquisa;



public class ClientePesquisaController implements ActionListener{
    ClientePesquisa clientePesquisa;
    
    public ClientePesquisaController(ClientePesquisa clientePesquisa) {
        this.clientePesquisa=clientePesquisa;
        
        this.clientePesquisa.getSair().addActionListener(this);
        this.clientePesquisa.getCarregar().addActionListener(this);
        this.clientePesquisa.getPesquisar().addActionListener(this);
        
        
        DefaultTableModel tabela = (DefaultTableModel) this.clientePesquisa.getTabelaDados().getModel();
        
        List<Cliente> listaObjetos = new ArrayList<>();
        listaObjetos = ClienteService.carregar();
        
        for (Cliente listaObjetoAtual : listaObjetos) {
            tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getCpf(), listaObjetoAtual.getNome()});
        }
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
            DefaultTableModel tabela = (DefaultTableModel) this.clientePesquisa.getTabelaDados().getModel();
            
            tabela.setRowCount(0);
            List<Cliente> listaObjetos = new ArrayList<>();
            if(this.clientePesquisa.getPesquisa().getText().equalsIgnoreCase("")){
               listaObjetos = ClienteService.carregar();

            for (Cliente listaObjetoAtual : listaObjetos) {
                tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getCpf(), listaObjetoAtual.getNome()});
            } 
            }else{
                String filtro= this.clientePesquisa.getPesquisa().getText();
                
                switch (this.clientePesquisa.getFiltro().getSelectedIndex()) {
                    case 0:
                        Cliente objeto = ClienteService.carregar(Integer.parseInt(filtro));
                        tabela.addRow(new Object[]{objeto.getId(), objeto.getCpf(), objeto.getNome()});
                        break;
                    
                    case 1:
                        listaObjetos = ClienteService.carregarCPF(filtro);

                        for (Cliente listaObjetoAtual : listaObjetos) {
                            tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getCpf(), listaObjetoAtual.getNome()});
                        } 
                        break;
                        
                    case 2:
                        listaObjetos = ClienteService.carregar(filtro);

                        for (Cliente listaObjetoAtual : listaObjetos) {
                            tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getCpf(), listaObjetoAtual.getNome()});
                        } 
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            
            
            
            
        }
    }
    
}
