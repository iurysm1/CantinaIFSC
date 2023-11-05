
package controller;

import model.DAO.Persiste;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import model.bo.Cidade;
import service.CidadeService;
import utilities.Utilities;
import view.CidadePesquisa;

public class CidadePesquisaController implements ActionListener{

    CidadePesquisa cidadePesquisa;
    
    

    public CidadePesquisaController(CidadePesquisa cidadePesquisa) {
        this.cidadePesquisa=cidadePesquisa;
        
        this.cidadePesquisa.getSair().addActionListener(this);
        this.cidadePesquisa.getCarregar().addActionListener(this);
        this.cidadePesquisa.getPesquisar().addActionListener(this);
        this.cidadePesquisa.getFiltro().addActionListener(this);
        
        DefaultTableModel tabelaDados = (DefaultTableModel) cidadePesquisa.getTabelaDados().getModel();
        Utilities.limpaComponentes(true, this.cidadePesquisa.getPainelPesquisa());

        CidadeService cidadeService = new CidadeService();
        List<Cidade> listaCidades = new ArrayList<>();
        listaCidades = cidadeService.carregar();
        for (Cidade listaObjetoAtual : listaCidades) {
            tabelaDados.addRow(new Object[]{listaObjetoAtual.getId(),  listaObjetoAtual.getUf(),listaObjetoAtual.getDescricao()});
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.cidadePesquisa.getSair()){
            this.cidadePesquisa.dispose();
            
            
        }else if(e.getSource()==this.cidadePesquisa.getPesquisar()){             
            
            
            Persiste.getInstance();

            DefaultTableModel tabela = (DefaultTableModel) this.cidadePesquisa.getTabelaDados().getModel();

               tabela.setRowCount(0);
                
                 
                if(this.cidadePesquisa.getPesquisa().getText().equalsIgnoreCase("")){
                    List<Cidade> listaObjetos = new ArrayList<>();
                    listaObjetos = CidadeService.carregar();
                    for (Cidade listaObjetoAtual : listaObjetos) {
                        tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getUf(),listaObjetoAtual.getDescricao()});
                        }
                }else{
                        String filtro = this.cidadePesquisa.getPesquisa().getText();
                        List<Cidade> listaObjetos = new ArrayList<>();
                        
                        switch (this.cidadePesquisa.getFiltro().getSelectedIndex()) {
                        case 0:
                            Cidade objeto = CidadeService.carregar(Integer.parseInt(filtro));
                            tabela.addRow(new Object[]{objeto.getId(), objeto.getUf(),objeto.getDescricao()});
                            break;
                        case 1:
                            listaObjetos = CidadeService.carregarUF(filtro);
                            for (Cidade ObjetoAtual : listaObjetos) {
                               tabela.addRow(new Object[]{ObjetoAtual.getId(), ObjetoAtual.getUf(), ObjetoAtual.getDescricao()});    
                            }
                            break;
                        case 2:
                            listaObjetos = CidadeService.carregar(filtro);
                            for (Cidade ObjetoAtual : listaObjetos) {
                               tabela.addRow(new Object[]{ObjetoAtual.getId(), ObjetoAtual.getUf(), ObjetoAtual.getDescricao()});    
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(cidadePesquisa, "Erro");
                    }
                        
                        
                        
                }
         
            Utilities.limpaComponentes(true, this.cidadePesquisa.getPainelPesquisa());
            
        }else if(e.getSource()==this.cidadePesquisa.getCarregar()){
            controller.EnderecoRegistroController.codigoCidade=(int) this.cidadePesquisa.getTabelaDados().getValueAt(this.cidadePesquisa.getTabelaDados().getSelectedRow(), 0);
            controller.CidadeRegistroController.codigo=(int) this.cidadePesquisa.getTabelaDados().getValueAt(this.cidadePesquisa.getTabelaDados().getSelectedRow(), 0);
            
          this.cidadePesquisa.dispose();
        }
        
    }
    
}
