package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import model.bo.Produto;
import utilities.Utilities;
import view.Feedback;
import view.ProdutoAdicionarFoto;
import view.ProdutoPesquisa;
import view.ProdutoRegistro;

public class ProdutoRegistroController implements ActionListener {

    ProdutoRegistro produtoRegistro;
    public static int codigo;
    public static String caminhoArquivo = "D:/Códigos/GitHub/CantinaIFSC/CantinaIFSC/src/viewIMG/iconPadrao.png";

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

        @Override
        public void windowClosed(WindowEvent e) {
            if (codigo != 0) {

                Produto produto = new Produto();
                produto = DAO.Persiste.produtos.get(codigo - 1);
                Utilities.active(false, produtoRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, produtoRegistro.getPainelDados());
                
                ImageIcon icon = new ImageIcon(produto.getCaminhoFotoProduto());
                
                produtoRegistro.getId().setText(produto.getId() + "");
                produtoRegistro.getId().setEnabled(false);
                produtoRegistro.getNome().setText(produto.getDescricao());
                produtoRegistro.getPreco().setText(produto.getPreco() + "");
                produtoRegistro.getCodigoBarra().setText(produto.getCodigobarra());
                
                produtoRegistro.setIcon(icon);
                produtoRegistro.getPainelFoto().setBackground(Color.white);
            } else if (codigo == 0) {
                produtoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/iconPadrao.png")));
                produtoRegistro.getPainelFoto().setBackground(new java.awt.Color(242, 242, 242));
                Utilities.active(true, produtoRegistro.getPainelBotoes());
                Utilities.limpaComponentes(false, produtoRegistro.getPainelDados());
            }
        }
    };

    /*WindowListener disposeListenerProduto = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if (caminhoArquivo.equalsIgnoreCase("D:/Códigos/GitHub/CantinaIFSC/CantinaIFSC/src/viewIMG/iconPadrao.png")) {
                System.out.println("teste");
            } else {
                ImageIcon icon = new ImageIcon(caminhoArquivo);
                produtoRegistro.setIcon(icon);
            }
        }
    };*/

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.produtoRegistro.getNovo()) {
            this.produtoRegistro.getPainelFoto().setBackground(new Color(242, 242, 242));
            Utilities.active(false, this.produtoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.produtoRegistro.getPainelDados());
            this.produtoRegistro.getId().setEnabled(false);

        } else if (e.getSource() == this.produtoRegistro.getGravar()) {
            Produto produto = new Produto();

            produto.setCodigobarra(this.produtoRegistro.getPreco().getText());
            produto.setId(DAO.Persiste.produtos.size() + 1);
            produto.setDescricao(this.produtoRegistro.getNome().getText());
            produto.setCodigobarra(this.produtoRegistro.getCodigoBarra().getText());
            produto.setCaminhoFotoProduto(caminhoArquivo);
            Feedback feedback = new Feedback();
            FeedbackController feedbackController = new FeedbackController(feedback);

            if (this.produtoRegistro.getId().getText().equalsIgnoreCase("")) {
                DAO.Persiste.produtos.add(produto);
                feedbackController.codigoFB = 4;
                feedbackController.cadastroClasse();
            } else {
                int index = Integer.parseInt(this.produtoRegistro.getId().getText()) - 1;
                DAO.Persiste.produtos.get(index).setCodigobarra(this.produtoRegistro.getCodigoBarra().getText() + "");
                DAO.Persiste.produtos.get(index).setDescricao(this.produtoRegistro.getNome().getText());
                DAO.Persiste.produtos.get(index).setPreco(Float.valueOf(this.produtoRegistro.getPreco().getText()));
                DAO.Persiste.produtos.get(index).setCaminhoFotoProduto(caminhoArquivo);
                feedbackController.codigoFB = 4;
                feedbackController.atualizacaoClasse();
            }

            this.produtoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/iconPadrao.png")));
            this.produtoRegistro.getPainelFoto().setBackground(new java.awt.Color(242, 242, 242));
            feedback.setVisible(true);
            Utilities.active(true, this.produtoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.produtoRegistro.getPainelDados());

        } else if (e.getSource() == this.produtoRegistro.getCancelar()) {
            this.produtoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewIMG/iconPadrao.png")));
            this.produtoRegistro.getPainelFoto().setBackground(new java.awt.Color(242, 242, 242));
            Utilities.active(true, this.produtoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.produtoRegistro.getPainelDados());

        } else if (e.getSource() == this.produtoRegistro.getPesquisar()) {
            ProdutoPesquisa produtoPesquisa = new ProdutoPesquisa();
            ProdutoPesquisaController pesquisaController = new ProdutoPesquisaController(produtoPesquisa);

            produtoPesquisa.addWindowListener(disposeListener);
            produtoPesquisa.setVisible(true);

        } else if (e.getSource() == this.produtoRegistro.getSair()) {
            this.produtoRegistro.dispose();

        } else if (e.getSource() == this.produtoRegistro.getNovaFoto()) {

            JFileChooser fileChooser = new JFileChooser();
            int opcao = fileChooser.showOpenDialog(fileChooser);
            String caminho = fileChooser.getSelectedFile().getAbsolutePath();

            if (opcao == JFileChooser.APPROVE_OPTION) {
                ImageIcon icon = new ImageIcon(caminho);
                produtoRegistro.setIcon(icon);
                this.caminhoArquivo = caminho;
                fileChooser.setVisible(false);
                this.produtoRegistro.getPainelFoto().setBackground(Color.white);

            }

            //this.produtoRegistro.setSelecionarArquivo();
            /*ProdutoAdicionarFoto produtoAdicionarFoto=new ProdutoAdicionarFoto();
            ProdutoAdicionarFotoController produtoAdicionarFotoController=new ProdutoAdicionarFotoController(produtoAdicionarFoto);
            produtoAdicionarFoto.addWindowListener(disposeListenerProduto);
            produtoAdicionarFoto.setVisible(true);*/
        }

    }

}
