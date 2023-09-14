package controller;

import model.DAO.Persiste;
import static controller.BairroRegistroController.codigo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import service.BairroService;
import view.BairroPesquisa;

public class BairroPesquisaController implements ActionListener {

    BairroPesquisa bairroPesquisa;

    public BairroPesquisaController(BairroPesquisa bairroPesquisa) {

        this.bairroPesquisa = bairroPesquisa;

        this.bairroPesquisa.getCarregar().addActionListener(this);
        this.bairroPesquisa.getSair().addActionListener(this);
        this.bairroPesquisa.getPesquisar().addActionListener(this);
        this.bairroPesquisa.getPesquisa().addActionListener(this);
        //Carga inicial de dados sendo que é provisória...
        //Posteriormente levar para o botao pesquisar
        DefaultTableModel tabelaDados = (DefaultTableModel) bairroPesquisa.getTabelaDados().getModel();
        
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

                while (tabela.getRowCount()!=0) {                
                    int i=tabela.getRowCount();
                    tabela.removeRow(i-1);
                    i--;
                    }
                 BairroService bairroService = new BairroService();
                 Bairro bairro = bairroService.carregar(Integer.parseInt(this.bairroPesquisa.getPesquisa().getText()));
                 tabela.addRow(new Object[]{bairro.getId(),bairro.getDescricao()});
                 

               
            

        }
    }
    

}
