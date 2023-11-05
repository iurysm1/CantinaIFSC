
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bo.Fornecedor;
import service.FornecedorService;
import view.FornecedorPesquisa;

public class FornecedorPesquisaController implements ActionListener{

    FornecedorPesquisa fornecedorPesquisa;
    
    public FornecedorPesquisaController(FornecedorPesquisa fornecedorPesquisa) {
        this.fornecedorPesquisa = fornecedorPesquisa;
        
        this.fornecedorPesquisa.getSair().addActionListener(this);
        this.fornecedorPesquisa.getPesquisar().addActionListener(this);
        this.fornecedorPesquisa.getCarregar().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.fornecedorPesquisa.getTabelaDados().getModel();
            
        
        for (Fornecedor fornecedorAtual : FornecedorService.carregar()) {
                
                tabela.addRow(new Object[]{fornecedorAtual.getId(),fornecedorAtual.getCnpj(),fornecedorAtual.getNome()});
            }
        
        
    }


    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.fornecedorPesquisa.getSair()){
            this.fornecedorPesquisa.dispose();
        }else if(e.getSource()==this.fornecedorPesquisa.getPesquisar()){
            DefaultTableModel tabela = (DefaultTableModel) this.fornecedorPesquisa.getTabelaDados().getModel();
            
            tabela.setRowCount(0);
            List<Fornecedor> listaObjetos = new ArrayList<>();
            if(this.fornecedorPesquisa.getPesquisa().getText().equalsIgnoreCase("")){
               listaObjetos = FornecedorService.carregar();

            for (Fornecedor listaObjetoAtual : listaObjetos) {
                tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getCnpj(), listaObjetoAtual.getNome()});
            } 
            }else{
                String filtro= this.fornecedorPesquisa.getPesquisa().getText();
                
                switch (this.fornecedorPesquisa.getFiltro().getSelectedIndex()) {
                    case 0:
                        Fornecedor objeto = FornecedorService.carregar(Integer.parseInt(filtro));
                        tabela.addRow(new Object[]{objeto.getId(), objeto.getCnpj(), objeto.getNome()});
                        break;
                    
                    case 1:
                        listaObjetos = FornecedorService.carregarCNPJ(filtro);

                        for (Fornecedor listaObjetoAtual : listaObjetos) {
                            tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getCnpj(), listaObjetoAtual.getNome()});
                        } 
                        break;
                        
                    case 2:
                        listaObjetos = FornecedorService.carregar(filtro);

                        for (Fornecedor listaObjetoAtual : listaObjetos) {
                            tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getCnpj(), listaObjetoAtual.getNome()});
                        } 
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            
        }else if (e.getSource()==this.fornecedorPesquisa.getCarregar()){
            FornecedorRegistroController.codigo=(int) this.fornecedorPesquisa.getTabelaDados().getValueAt(this.fornecedorPesquisa.getTabelaDados().getSelectedRow(), 0);
            this.fornecedorPesquisa.dispose();
            
        }
    }
    
}
