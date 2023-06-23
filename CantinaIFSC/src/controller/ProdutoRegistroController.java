
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import model.bo.Produto;
import utilities.Utilities;
import view.Feedback;
import view.ProdutoAdicionarFoto;
import view.ProdutoPesquisa;
import view.ProdutoRegistro;

public class ProdutoRegistroController implements ActionListener{

    ProdutoRegistro produtoRegistro;
    public static int codigo;
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
    
    WindowListener disposeListener = new WindowAdapter() {
        
        public void windowClosed(WindowEvent e){
            if(codigo!=0){
            Produto produto = new Produto();
            produto=DAO.Persiste.produtos.get(codigo-1);
            Utilities.active(false, produtoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, produtoRegistro.getPainelDados());
            
            produtoRegistro.getId().setText(produto.getId()+"");
            produtoRegistro.getId().setEnabled(false);
            produtoRegistro.getNome().setText(produto.getDescricao());
            produtoRegistro.getPreco().setText(produto.getPreco()+"");
            produtoRegistro.getCodigoBarra().setText(produto.getCodigobarra());
        }
        }
    };
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.produtoRegistro.getNovo()){
            
            Utilities.active(false, this.produtoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.produtoRegistro.getPainelDados());
            this.produtoRegistro.getId().setEnabled(false);
            
            
        }else if(e.getSource()==this.produtoRegistro.getGravar()){
            Produto produto = new Produto();
            
            produto.setCodigobarra(this.produtoRegistro.getPreco().getText());
            produto.setId(DAO.Persiste.produtos.size()+1);
            produto.setDescricao(this.produtoRegistro.getNome().getText());
            produto.setCodigobarra(this.produtoRegistro.getCodigoBarra().getText());
            Feedback feedback=new Feedback();
            FeedbackController feedbackController= new FeedbackController(feedback);
            
            if(this.produtoRegistro.getId().getText().equalsIgnoreCase("")){
                DAO.Persiste.produtos.add(produto);
                feedbackController.codigoFB=4;
                feedbackController.cadastroClasse();
            }else{
                int index= Integer.parseInt(this.produtoRegistro.getId().getText())-1;
                DAO.Persiste.produtos.get(index).setCodigobarra(this.produtoRegistro.getCodigoBarra().getText()+"");
                DAO.Persiste.produtos.get(index).setDescricao(this.produtoRegistro.getNome().getText());
                DAO.Persiste.produtos.get(index).setPreco(Float.valueOf(this.produtoRegistro.getPreco().getText()));
                feedbackController.codigoFB=4;
                feedbackController.atualizacaoClasse();
            }
            
            feedback.setVisible(true);
            Utilities.active(true, this.produtoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.produtoRegistro.getPainelDados());
            
            
        }else if(e.getSource()==this.produtoRegistro.getCancelar()){
            Utilities.active(true, this.produtoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.produtoRegistro.getPainelDados());
            
            
        }else if(e.getSource()==this.produtoRegistro.getPesquisar()){
            ProdutoPesquisa produtoPesquisa=new ProdutoPesquisa();
            ProdutoPesquisaController pesquisaController=new ProdutoPesquisaController(produtoPesquisa);
            
            produtoPesquisa.addWindowListener(disposeListener);
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
