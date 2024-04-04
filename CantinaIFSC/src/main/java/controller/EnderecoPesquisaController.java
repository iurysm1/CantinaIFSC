
package controller;

import java.util.ArrayList;
import java.util.List;
import model.DAO.Persiste;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.EnderecoService;
import model.bo.Endereco;
import utilities.Utilities;

import view.EnderecoPesquisa;

public class EnderecoPesquisaController implements ActionListener{

    EnderecoPesquisa enderecoPesquisa;

    public EnderecoPesquisaController(EnderecoPesquisa enderecoPesquisa) {
        
        this.enderecoPesquisa=enderecoPesquisa;
        
        this.enderecoPesquisa.getSair().addActionListener(this);
        this.enderecoPesquisa.getPesquisar().addActionListener(this);
        this.enderecoPesquisa.getCarregar().addActionListener(this);
   
        DefaultTableModel tabela = (DefaultTableModel) this.enderecoPesquisa.getTabelaDados().getModel();
        
        List<Endereco> listaObjetos = new ArrayList<>();
        listaObjetos = EnderecoService.carregar();
            for (Endereco listaObjetoAtual : listaObjetos) {
               tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getLogradouro(), listaObjetoAtual.getCidade().getDescricao(), listaObjetoAtual.getBairro().getDescricao()});
    }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==this.enderecoPesquisa.getSair()){
           this.enderecoPesquisa.dispose();

       }else if(e.getSource()==this.enderecoPesquisa.getPesquisar()){
           Persiste.getInstance();
           
           DefaultTableModel tabela = (DefaultTableModel) this.enderecoPesquisa.getTabelaDados().getModel();
           
           tabela.setRowCount(0);
           
           if(this.enderecoPesquisa.getPesquisa().getText().equalsIgnoreCase("")){
                    List<Endereco> listaObjetos = new ArrayList<>();
                    listaObjetos = EnderecoService.carregar();
                    for (Endereco listaObjetoAtual : listaObjetos) {
                        tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getLogradouro(), listaObjetoAtual.getCidade().getDescricao(), listaObjetoAtual.getBairro().getDescricao()});
                        }
                }else{
                        String filtro = this.enderecoPesquisa.getPesquisa().getText();
                        String filtroParametro = "cidade.descricao";
                        //Voltar com o case ou fazer uma outra lógica
                        List<Endereco> listaObjetos = new ArrayList<>();
                        
                        if(this.enderecoPesquisa.getFiltro().getSelectedIndex()==0){
                            Endereco objeto = EnderecoService.carregar(Integer.parseInt(filtro));
                            tabela.addRow(new Object[]{objeto.getId(), objeto.getLogradouro(), objeto.getCidade().getDescricao(), objeto.getBairro().getDescricao()});
                        }else{
                            System.out.println(filtro+" "+filtroParametro);
                            listaObjetos = EnderecoService.carregar(filtro, filtroParametro);
                            for (Endereco listaObjetoAtual : listaObjetos) {
                               tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getLogradouro(), listaObjetoAtual.getCidade().getDescricao(), listaObjetoAtual.getBairro().getDescricao()});
                            }
                       }
                }
         
            Utilities.limpaComponentes(true, this.enderecoPesquisa.getPainelPesquisa());
           
       }else if(e.getSource()==this.enderecoPesquisa.getCarregar()){
           ClienteRegistroController.codigoEndereco=(int) this.enderecoPesquisa.getTabelaDados().getValueAt(this.enderecoPesquisa.getTabelaDados().getSelectedRow(), 0);
           
           EnderecoRegistroController.codigo=(int) this.enderecoPesquisa.getTabelaDados().getValueAt(this.enderecoPesquisa.getTabelaDados().getSelectedRow(), 0);
           this.enderecoPesquisa.dispose();
           
           FornecedorRegistroController.codigoEndereco=(int) this.enderecoPesquisa.getTabelaDados().getValueAt(this.enderecoPesquisa.getTabelaDados().getSelectedRow(), 0);
           
           FuncionarioRegistroController.codigoEndereco=(int) this.enderecoPesquisa.getTabelaDados().getValueAt(this.enderecoPesquisa.getTabelaDados().getSelectedRow(), 0);
       }
    }
    
}
