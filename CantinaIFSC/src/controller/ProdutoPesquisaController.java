
package controller;

import model.DAO.Persiste;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Produto;
import service.ProdutoService;
import view.ProdutoPesquisa;

public class ProdutoPesquisaController implements ActionListener{
    
    ProdutoPesquisa produtoPesquisa;
    

    public ProdutoPesquisaController(ProdutoPesquisa produtoPesquisa) {
        this.produtoPesquisa = produtoPesquisa;
        
        this.produtoPesquisa.getSair().addActionListener(this);
        this.produtoPesquisa.getPesquisar().addActionListener(this);
        this.produtoPesquisa.getCarregar().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.produtoPesquisa.getTabelaDados().getModel();
        List<Produto> listaObjetos=new ArrayList<>();
        listaObjetos=ProdutoService.carregar();
        
        for (Produto listaObjeto : listaObjetos) {
            tabela.addRow(new Object[]{listaObjeto.getId(),listaObjeto.getDescricao(),listaObjeto.getCodigobarra(),listaObjeto.getPreco()});
        }
    }
    
    ListSelectionListener selectionListener = new ListSelectionListener() {
        
        @Override
        public void valueChanged(ListSelectionEvent e){
            if(e.getValueIsAdjusting()){
                int selectedRow = produtoPesquisa.getTabelaDados().getSelectedRow();
                if(selectedRow!=-1){
                    int selectedItem= (int) produtoPesquisa.getTabelaDados().getValueAt(selectedRow, 0);
                    ImageIcon icon = new ImageIcon(model.DAO.Persiste.produtos.get(selectedItem).getCaminhoFotoProduto());
                    
                    produtoPesquisa.setIcon(icon);
                    produtoPesquisa.getPainelFoto().setBackground(Color.white);
                }
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.produtoPesquisa.getSair()){
            controller.ProdutoRegistroController.codigo=0;
            this.produtoPesquisa.dispose();
            
        }else if(e.getSource()==this.produtoPesquisa.getPesquisar()){
            DefaultTableModel tabela = (DefaultTableModel) this.produtoPesquisa.getTabelaDados().getModel();
            tabela.setRowCount(0);
            List<Produto> listaObjetos=new ArrayList<>();
            
            if(this.produtoPesquisa.getPesquisa().getText().equals("")){
                listaObjetos=ProdutoService.carregar();
                for (Produto listaObjeto : listaObjetos) {
                    tabela.addRow(new Object[]{listaObjeto.getId(),listaObjeto.getDescricao(),listaObjeto.getCodigobarra(),listaObjeto.getPreco()});
                }
            }else{
                String filtro= this.produtoPesquisa.getPesquisa().getText();
                
                switch (this.produtoPesquisa.getFiltro().getSelectedIndex()) {
                    case 0:
                        Produto objeto = ProdutoService.carregar(Integer.parseInt(filtro));
                        tabela.addRow(new Object[]{objeto.getId(),objeto.getDescricao(),objeto.getCodigobarra(),objeto.getPreco()});
                        break;
                    
                    case 1:
                        listaObjetos = ProdutoService.carregarDescricao(filtro);

                        for (Produto listaObjeto : listaObjetos) {
                            tabela.addRow(new Object[]{listaObjeto.getId(),listaObjeto.getDescricao(),listaObjeto.getCodigobarra(),listaObjeto.getPreco()});
                        } 
                        break;
                        
                    case 2:
                       listaObjetos = ProdutoService.carregarCodigoBarra(filtro);

                        for (Produto listaObjeto : listaObjetos) {
                            tabela.addRow(new Object[]{listaObjeto.getId(),listaObjeto.getDescricao(),listaObjeto.getCodigobarra(),listaObjeto.getPreco()});
                            System.out.println("teste");
                        } 
                        break;
                        case 3:
                       listaObjetos = ProdutoService.carregarPreco(Float.parseFloat(filtro));

                        for (Produto listaObjeto : listaObjetos) {
                            tabela.addRow(new Object[]{listaObjeto.getId(),listaObjeto.getDescricao(),listaObjeto.getCodigobarra(),listaObjeto.getPreco()});
                        } 
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            
            
            
            
            
            
        }else if(e.getSource()==this.produtoPesquisa.getCarregar()){
            controller.ProdutoRegistroController.codigo=(int) this.produtoPesquisa.getTabelaDados().getValueAt(this.produtoPesquisa.getTabelaDados().getSelectedRow(), 0);
            
            this.produtoPesquisa.dispose();
        }
    }
    
    
    
}
