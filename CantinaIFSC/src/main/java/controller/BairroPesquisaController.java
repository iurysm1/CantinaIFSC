package controller;

import model.DAO.Persiste;
import static controller.BairroRegistroController.codigo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import service.BairroService;
import utilities.Utilities;
import view.BairroPesquisa;

public class BairroPesquisaController implements ActionListener {

    BairroPesquisa bairroPesquisa;

    public BairroPesquisaController(BairroPesquisa bairroPesquisa) {

        this.bairroPesquisa = bairroPesquisa;

        this.bairroPesquisa.getCarregar().addActionListener(this);
        this.bairroPesquisa.getSair().addActionListener(this);
        this.bairroPesquisa.getPesquisar().addActionListener(this);
        this.bairroPesquisa.getPesquisa().addActionListener(this);
        this.bairroPesquisa.getFiltro().addActionListener(this);
        
        //Carga inicial de dados sendo que é provisória...
        //Posteriormente levar para o botao pesquisar
        DefaultTableModel tabelaDados = (DefaultTableModel) bairroPesquisa.getTabelaDados().getModel();
        Utilities.limpaComponentes(true, this.bairroPesquisa.getPainelPesquisa());

        BairroService bairroService = new BairroService();
        List<Bairro> listaBairros = new ArrayList<>();
        listaBairros = bairroService.carregar();
        for (Bairro listaBairroAtual : listaBairros) {
            tabelaDados.addRow(new Object[]{listaBairroAtual.getId(),listaBairroAtual.getDescricao()});
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.bairroPesquisa.getCarregar()) {

            controller.EnderecoRegistroController.codigoBairro = (int) this.bairroPesquisa.getTabelaDados().getValueAt(this.bairroPesquisa.getTabelaDados().getSelectedRow(), 0);
            controller.BairroRegistroController.codigo = (int) this.bairroPesquisa.getTabelaDados().getValueAt(this.bairroPesquisa.getTabelaDados().getSelectedRow(), 0);

            this.bairroPesquisa.dispose();

        } else if (e.getSource() == this.bairroPesquisa.getSair()) {
            this.bairroPesquisa.dispose();
        } else if (e.getSource() == this.bairroPesquisa.getPesquisar()) {
            Persiste.getInstance();

            DefaultTableModel tabela = (DefaultTableModel) this.bairroPesquisa.getTabelaDados().getModel();

               tabela.setRowCount(0);
                
                 
                if(this.bairroPesquisa.getPesquisa().getText().equalsIgnoreCase("")){
                    List<Bairro> listaObjetos = new ArrayList<>();
                    listaObjetos = BairroService.carregar();
                    for (Bairro listaObjetoAtual : listaObjetos) {
                        tabela.addRow(new Object[]{listaObjetoAtual.getId(),listaObjetoAtual.getDescricao()});
                        }
                }else{
                        String filtro = this.bairroPesquisa.getPesquisa().getText();
                        List<Bairro> listaObjetos = new ArrayList<>();
                        
                        switch (this.bairroPesquisa.getFiltro().getSelectedIndex()) {
                        case 0:
                            Bairro objeto = BairroService.carregar(Integer.parseInt(filtro));
                            tabela.addRow(new Object[]{objeto.getId(),objeto.getDescricao()});
                            break;
                        case 1:
                            listaObjetos = BairroService.carregar(filtro);
                            for (Bairro ObjetoAtual : listaObjetos) {
                               tabela.addRow(new Object[]{ObjetoAtual.getId(), ObjetoAtual.getDescricao()});    
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(bairroPesquisa, "Erro");
                    }
                        
                        
                        
                }
         
            Utilities.limpaComponentes(true, this.bairroPesquisa.getPainelPesquisa());

        }
    }
    

}
