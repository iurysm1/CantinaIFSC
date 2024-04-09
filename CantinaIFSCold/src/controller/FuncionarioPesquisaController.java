
package controller;

import model.DAO.Persiste;
import static model.DAO.Persiste.funcionarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Funcionario;
import service.FuncionarioService;
import view.FuncionarioPesquisa;

class FuncionarioPesquisaController implements ActionListener{
    
    FuncionarioPesquisa funcionarioPesquisa;

    public FuncionarioPesquisaController(FuncionarioPesquisa funcionarioPesquisa) {
        this.funcionarioPesquisa=funcionarioPesquisa;
        
        this.funcionarioPesquisa.getSair().addActionListener(this);
        this.funcionarioPesquisa.getCarregar().addActionListener(this);
        this.funcionarioPesquisa.getPesquisar().addActionListener(this);
        
        this.funcionarioPesquisa.getFiltro().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.funcionarioPesquisa.getTabelaDados().getModel();
            
        
        for (Funcionario objetoAtual : FuncionarioService.carregar()) {
                
                tabela.addRow(new Object[]{objetoAtual.getId(),objetoAtual.getCpf(),objetoAtual.getNome()});
            }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.funcionarioPesquisa.getSair()){
            this.funcionarioPesquisa.dispose();
            
            
            
        }else if(e.getSource()==this.funcionarioPesquisa.getPesquisar()){
            Persiste.getInstance();
            
            DefaultTableModel tabela = (DefaultTableModel) this.funcionarioPesquisa.getTabelaDados().getModel();
            tabela.setRowCount(0);
            List<Funcionario> listaObjetos = new ArrayList<>();
        
            
            if(this.funcionarioPesquisa.getPesquisa().getText().equalsIgnoreCase(""))
            {
                for (Funcionario objetoAtual : FuncionarioService.carregar()) {
                
                tabela.addRow(new Object[]{objetoAtual.getId(),objetoAtual.getCpf(),objetoAtual.getNome()});
            }
            }else{
                String filtro= this.funcionarioPesquisa.getPesquisa().getText();
                
                switch (this.funcionarioPesquisa.getFiltro().getSelectedIndex()) {
                    case 0:
                        Funcionario objeto = FuncionarioService.carregar(Integer.parseInt(filtro));
                        tabela.addRow(new Object[]{objeto.getId(), objeto.getCpf(), objeto.getNome()});
                        break;
                    
                    case 1:
                        listaObjetos = FuncionarioService.carregarCPF(filtro);

                        for (Funcionario listaObjetoAtual : listaObjetos) {
                            tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getCpf(), listaObjetoAtual.getNome()});
                        } 
                        break;
                        
                    case 2:
                        listaObjetos = FuncionarioService.carregar(filtro);

                        for (Funcionario listaObjetoAtual : listaObjetos) {
                            tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getCpf(), listaObjetoAtual.getNome()});
                        } 
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            
            
        }else if(e.getSource()==this.funcionarioPesquisa.getCarregar()){
            FuncionarioRegistroController.codigo=(int) this.funcionarioPesquisa.getTabelaDados().getValueAt(this.funcionarioPesquisa.getTabelaDados().getSelectedRow(), 0);
            this.funcionarioPesquisa.dispose();
            
        }
    }
    
}
