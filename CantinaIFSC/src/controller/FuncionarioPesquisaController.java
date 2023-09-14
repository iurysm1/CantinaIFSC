
package controller;

import model.DAO.Persiste;
import static model.DAO.Persiste.funcionarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Funcionario;
import view.FuncionarioPesquisa;

class FuncionarioPesquisaController implements ActionListener{
    
    FuncionarioPesquisa funcionarioPesquisa;

    public FuncionarioPesquisaController(FuncionarioPesquisa funcionarioPesquisa) {
        this.funcionarioPesquisa=funcionarioPesquisa;
        
        this.funcionarioPesquisa.getSair().addActionListener(this);
        this.funcionarioPesquisa.getCarregar().addActionListener(this);
        this.funcionarioPesquisa.getPesquisar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.funcionarioPesquisa.getSair()){
            this.funcionarioPesquisa.dispose();
            
            
            
        }else if(e.getSource()==this.funcionarioPesquisa.getPesquisar()){
            Persiste.getInstance();
            
            DefaultTableModel tabela = (DefaultTableModel) this.funcionarioPesquisa.getTabelaDados().getModel();

            if(tabela.getRowCount()==0){
            for (Funcionario funcionarioAtual : funcionarios) {
                tabela.addRow(new Object[]{funcionarioAtual.getId(),funcionarioAtual.getCpf(),funcionarioAtual.getNome()});
            }
            }
            
            
        }else if(e.getSource()==this.funcionarioPesquisa.getCarregar()){
            FuncionarioRegistroController.codigo=(int) this.funcionarioPesquisa.getTabelaDados().getValueAt(this.funcionarioPesquisa.getTabelaDados().getSelectedRow(), 0);
            this.funcionarioPesquisa.dispose();
            
        }
    }
    
}
