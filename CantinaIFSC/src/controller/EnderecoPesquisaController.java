
package controller;

import DAO.Persiste;
import static DAO.Persiste.enderecos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Endereco;

import view.EnderecoPesquisa;

public class EnderecoPesquisaController implements ActionListener{

    EnderecoPesquisa enderecoPesquisa;

    public EnderecoPesquisaController(EnderecoPesquisa enderecoPesquisa) {
        
        this.enderecoPesquisa=enderecoPesquisa;
        
        this.enderecoPesquisa.getSair().addActionListener(this);
        this.enderecoPesquisa.getPesquisar().addActionListener(this);
        this.enderecoPesquisa.getCarregar().addActionListener(this);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==this.enderecoPesquisa.getSair()){
           this.enderecoPesquisa.dispose();

       }else if(e.getSource()==this.enderecoPesquisa.getPesquisar()){
           Persiste.getInstance();
           
           DefaultTableModel tabela = (DefaultTableModel) this.enderecoPesquisa.getTabelaDados().getModel();
           
           if(tabela.getRowCount()==0){
           for (Endereco enderecoAtual : enderecos) {
               tabela.addRow(new Object[]{enderecoAtual.getId(),enderecoAtual.getLogradouro(),enderecoAtual.getCidade().getDescricao(),enderecoAtual.getBairro().getDescricao()});
           }
           }
           
       }else if(e.getSource()==this.enderecoPesquisa.getCarregar()){
           ClienteRegistroController.codigoEndereco=(int) this.enderecoPesquisa.getTabelaDados().getValueAt(this.enderecoPesquisa.getTabelaDados().getSelectedRow(), 0);
           
           EnderecoRegistroController.codigo=(int) this.enderecoPesquisa.getTabelaDados().getValueAt(this.enderecoPesquisa.getTabelaDados().getSelectedRow(), 0);
           this.enderecoPesquisa.dispose();
           
           FornecedorRegistroController.codigoEndereco=(int) this.enderecoPesquisa.getTabelaDados().getValueAt(this.enderecoPesquisa.getTabelaDados().getSelectedRow(), 0);
           
           FuncionarioRegistroController.codigoEndereco=(int) this.enderecoPesquisa.getTabelaDados().getValueAt(this.enderecoPesquisa.getTabelaDados().getSelectedRow(), 0);
       }
    }
    
}
