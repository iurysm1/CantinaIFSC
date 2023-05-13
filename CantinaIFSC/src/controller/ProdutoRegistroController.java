
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Utilities;
import view.ProdutoAdicionarFoto;
import view.ProdutoPesquisa;
import view.ProdutoRegistro;

public class ProdutoRegistroController implements ActionListener{

    ProdutoRegistro produtoRegistro;

    public ProdutoRegistroController(ProdutoRegistro produtoRegistro) {
        this.produtoRegistro = produtoRegistro;
        
        this.produtoRegistro.getNovo().addActionListener(this);
        this.produtoRegistro.getGravar().addActionListener(this);
        this.produtoRegistro.getCancelar().addActionListener(this);
        this.produtoRegistro.getPesquisar().addActionListener(this);
        this.produtoRegistro.getSair().addActionListener(this);
        this.produtoRegistro.getNovaFoto().addActionListener(this);
        
        Utilities.active(true, this.produtoRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.produtoRegistro.getPainelDados());
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.produtoRegistro.getNovo()){
            Utilities.active(false, this.produtoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.produtoRegistro.getPainelDados());
        }else if(e.getSource()==this.produtoRegistro.getGravar()){
            Utilities.active(true, this.produtoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.produtoRegistro.getPainelDados());
        }else if(e.getSource()==this.produtoRegistro.getCancelar()){
            Utilities.active(true, this.produtoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.produtoRegistro.getPainelDados());
        }else if(e.getSource()==this.produtoRegistro.getPesquisar()){
            ProdutoPesquisa produtoPesquisa=new ProdutoPesquisa();
            ProdutoPesquisaController pesquisaController=new ProdutoPesquisaController(produtoPesquisa);
            produtoPesquisa.setVisible(true);
        }else if(e.getSource()==this.produtoRegistro.getSair()){
            this.produtoRegistro.dispose();
        }else if(e.getSource()==this.produtoRegistro.getNovaFoto()){
            ProdutoAdicionarFoto produtoAdicionarFoto=new ProdutoAdicionarFoto();
            ProdutoAdicionarFotoController produtoAdicionarFotoController=new ProdutoAdicionarFotoController(produtoAdicionarFoto);
            produtoAdicionarFoto.setVisible(true);
        }
        
    }
    
}
