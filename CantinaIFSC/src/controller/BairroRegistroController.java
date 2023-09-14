package controller;


import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.DAO.Persiste;
import model.bo.Bairro;
import utilities.Utilities;
import view.BairroPesquisa;
import view.BairroRegistro;
import view.Feedback;

public class BairroRegistroController implements ActionListener {

    BairroRegistro bairroRegistro;
    public static int codigo;

    public BairroRegistroController(BairroRegistro bairroRegistro) {

        this.bairroRegistro = bairroRegistro;

        this.bairroRegistro.getNovo().addActionListener(this);
        this.bairroRegistro.getCancelar().addActionListener(this);
        this.bairroRegistro.getGravar().addActionListener(this);
        this.bairroRegistro.getPesquisar().addActionListener(this);
        this.bairroRegistro.getSair().addActionListener(this);
        this.bairroRegistro.getId().addActionListener(this);

        Utilities.active(true, this.bairroRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.bairroRegistro.getPainelDados());

    }
    WindowListener disposeListener = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if (codigo != 0) {
                Bairro bairro = new Bairro();
                bairro = Persiste.bairros.get(codigo - 1);
                Utilities.active(false, bairroRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, bairroRegistro.getPainelDados());

                bairroRegistro.getId().setText(bairro.getId() + "");
                bairroRegistro.getNomeDoBairro().setText(bairro.getDescricao());
                bairroRegistro.getId().setEnabled(false);
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.bairroRegistro.getNovo()) {
            Utilities.active(false, this.bairroRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.bairroRegistro.getPainelDados());
            this.bairroRegistro.getId().setEditable(false);

        } else if (e.getSource() == this.bairroRegistro.getCancelar()) {
            Utilities.active(true, this.bairroRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.bairroRegistro.getPainelDados());

        } else if (e.getSource() == this.bairroRegistro.getGravar()) {
            Bairro bairro = new Bairro();

            bairro.setId(Persiste.bairros.size() + 1);
            bairro.setDescricao(this.bairroRegistro.getNomeDoBairro().getText());
            Feedback feedback=new Feedback();
            FeedbackController feedbackController= new FeedbackController(feedback);
            if (this.bairroRegistro.getId().getText().equalsIgnoreCase("")) {
                Persiste.bairros.add(bairro);
                feedbackController.codigoFB=1;
                feedbackController.cadastroClasse();
            } else {
                int index = Integer.parseInt(this.bairroRegistro.getId().getText()) - 1;
                Persiste.bairros.get(index).setDescricao(this.bairroRegistro.getNomeDoBairro().getText());
                feedbackController.codigoFB=1;
                feedbackController.atualizacaoClasse();
            }
            
            
            feedback.setVisible(true);
            
            Utilities.active(true, this.bairroRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.bairroRegistro.getPainelDados());

        } else if (e.getSource() == this.bairroRegistro.getPesquisar()) {
            codigo = 0;
            BairroPesquisa bairroPesqusia = new BairroPesquisa();
            BairroPesquisaController bairroPesquisaController = new BairroPesquisaController(bairroPesqusia);
            bairroPesqusia.addWindowListener(disposeListener);
            bairroPesqusia.setVisible(true);

        } else if (e.getSource() == this.bairroRegistro.getSair()) {
            this.bairroRegistro.dispose();
        }

    }
}
