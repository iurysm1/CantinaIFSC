package controller;

import DAO.Persiste;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import utilities.Utilities;
import view.BairroPesquisa;
import view.BairroRegistro;
import view.CidadePesquisa;
import view.CidadeRegistro;
import view.EnderecoPesquisa;
import view.EnderecoRegistro;
import view.Feedback;
import view.FeedbackENDERECO;
import view.FeedbackSENHA;

public class EnderecoRegistroController implements ActionListener {

    EnderecoRegistro enderecoRegistro;
    
    
    public static int codigoCidade, codigoBairro, codigo;
    public static int idCidade, idBairro;
    
    public EnderecoRegistroController(EnderecoRegistro enderecoRegistro) {

        this.enderecoRegistro = enderecoRegistro;

        this.enderecoRegistro.getNovo().addActionListener(this);
        this.enderecoRegistro.getGravar().addActionListener(this);
        this.enderecoRegistro.getCancelar().addActionListener(this);
        this.enderecoRegistro.getPesquisar().addActionListener(this);
        this.enderecoRegistro.getSair().addActionListener(this);
        this.enderecoRegistro.getPesquisaBairro().addActionListener(this);
        this.enderecoRegistro.getPesquisaCidade().addActionListener(this);
        this.enderecoRegistro.getNovoBairro().addActionListener(this);
        this.enderecoRegistro.getNovoCidade().addActionListener(this);

        Utilities.active(true, this.enderecoRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.enderecoRegistro.getPainelDados());
    }
    
    WindowListener disposeListener = new WindowAdapter() {
        
        public void windowClosed(WindowEvent e){
            if(codigo!=0){
                Endereco endereco = new Endereco();
                endereco=DAO.Persiste.enderecos.get(codigo-1);
                Utilities.active(false, enderecoRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, enderecoRegistro.getPainelDados());
                
                enderecoRegistro.getId().setText(endereco.getId()+"");
                enderecoRegistro.getCep().setText(endereco.getCep());
                enderecoRegistro.getLogradouro().setText(endereco.getLogradouro());
                enderecoRegistro.getBairro().setText(endereco.getBairro().getDescricao());
                enderecoRegistro.getCidade().setText(endereco.getCidade().getDescricao());
                
                enderecoRegistro.getId().setEnabled(false);
           }
        }
    };
    WindowListener disposeListenerBairro = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if(codigoBairro!=0){
                Bairro bairro;
                bairro=DAO.Persiste.bairros.get(codigoBairro-1);
                Utilities.active(false, enderecoRegistro.getPainelBotoes());
                idBairro=bairro.getId()-1;
                
                enderecoRegistro.getBairro().setText(bairro.getDescricao());
                
            }
        }
    };
    WindowListener disposeListenerCidade = new WindowAdapter() {
         @Override
         public void windowClosed(WindowEvent e){
            if(codigoCidade!=0){
                Cidade cidade;
                cidade=DAO.Persiste.cidades.get(codigoCidade-1);
                Utilities.active(false, enderecoRegistro.getPainelBotoes());
                idCidade=cidade.getId()-1;
                
                enderecoRegistro.getCidade().setText(cidade.getDescricao());
            }
            }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.enderecoRegistro.getNovo()) {

            Utilities.active(false, this.enderecoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.enderecoRegistro.getPainelDados());
            this.enderecoRegistro.getId().setEnabled(false);
            
        } else if (e.getSource() == this.enderecoRegistro.getGravar()) {
            Endereco endereco = new Endereco();
            
            endereco.setId(DAO.Persiste.enderecos.size() + 1);
            endereco.setLogradouro(this.enderecoRegistro.getLogradouro().getText());
            endereco.setCep(this.enderecoRegistro.getCep().getText());
            endereco.setBairro(DAO.Persiste.bairros.get(idBairro));
            endereco.setCidade(DAO.Persiste.cidades.get(idCidade));
            
            Feedback feedback=new Feedback();
            FeedbackController feedbackController= new FeedbackController(feedback);
            if(this.enderecoRegistro.getId().getText().equalsIgnoreCase("")){
                DAO.Persiste.enderecos.add(endereco);
                feedbackController.codigoFB=3;
                feedbackController.cadastroClasse();
                
                
            }else{
                int index = Integer.parseInt(this.enderecoRegistro.getId().getText())-1;
                DAO.Persiste.enderecos.get(index).setLogradouro(this.enderecoRegistro.getLogradouro().getText());
                DAO.Persiste.enderecos.get(index).setCep(this.enderecoRegistro.getCep().getText());
                DAO.Persiste.enderecos.get(index).setBairro(DAO.Persiste.bairros.get(idBairro));
                DAO.Persiste.enderecos.get(index).setCidade(DAO.Persiste.cidades.get(idCidade));
                feedbackController.codigoFB=3;
                feedbackController.atualizacaoClasse();
                
                //OUTRO JEITO DE FAZER
                /*for (Bairro bairroAtual : Persiste.bairros) {
                    if(bairroAtual.getDescricao().equalsIgnoreCase(this.enderecoRegistro.getBairro().getText())){
                        DAO.Persiste.enderecos.get(index).setBairro(bairroAtual);
                    }
                }
                for (Cidade cidadeAtual : Persiste.cidades) {
                    if(cidadeAtual.getDescricao().equalsIgnoreCase(this.enderecoRegistro.getCidade().getText())){
                        DAO.Persiste.enderecos.get(index).setCidade(cidadeAtual);
                    }
                }*/
                
            }
            
            
            feedback.setVisible(true);
            
            Utilities.active(true, this.enderecoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.enderecoRegistro.getPainelDados());

            
        } else if (e.getSource() == this.enderecoRegistro.getCancelar()) {
            Utilities.active(true, this.enderecoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.enderecoRegistro.getPainelDados());

            
        } else if (e.getSource() == this.enderecoRegistro.getPesquisar()) {
            EnderecoPesquisa enderecoPesquisa = new EnderecoPesquisa();
            EnderecoPesquisaController enderecoPesquisaController = new EnderecoPesquisaController(enderecoPesquisa);
            enderecoPesquisa.addWindowListener(disposeListener);
            enderecoPesquisa.setVisible(true);

            
        } else if (e.getSource() == this.enderecoRegistro.getSair()) {
            this.enderecoRegistro.dispose();

            
        } else if (e.getSource() == this.enderecoRegistro.getNovoBairro()) {
            BairroRegistro bairroRegistro = new BairroRegistro();
            BairroRegistroController bairroRegistroController = new BairroRegistroController(bairroRegistro);
            bairroRegistro.setVisible(true);

            
        } else if (e.getSource() == this.enderecoRegistro.getPesquisaBairro()) {
            
            if(this.enderecoRegistro.getBairro().getText().equalsIgnoreCase("")){
            codigoBairro=0;
            BairroPesquisa bairroPesquisa = new BairroPesquisa();
            BairroPesquisaController bairroPesquisaController = new BairroPesquisaController(bairroPesquisa);
            bairroPesquisa.addWindowListener(disposeListenerBairro);
            bairroPesquisa.setVisible(true);
            }else{
                boolean validacao=true;
                for (Bairro bairroAtual : Persiste.bairros) {
                    if(bairroAtual.getDescricao().equalsIgnoreCase(this.enderecoRegistro.getBairro().getText())){
                        idBairro=bairroAtual.getId()-1;
                        this.enderecoRegistro.getBairro().setText(bairroAtual.getDescricao());
                        validacao=false;
                    }                  
                }
                if(validacao==true){
                    FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                    FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                    FeedbackEnderecoController.codigoFB=1;
                    feedbackEnderecoController.atualizacaoLabel();
                    feedbackENDERECO.setVisible(true);
                    }
            }
            
        } else if (e.getSource() == this.enderecoRegistro.getNovoCidade()) {
            CidadeRegistro cidadeRegistro = new CidadeRegistro();
            CidadeRegistroController cidadeRegistroController = new CidadeRegistroController(cidadeRegistro);
            cidadeRegistro.setVisible(true);

            
        } else if (e.getSource() == this.enderecoRegistro.getPesquisaCidade()) {
            if(this.enderecoRegistro.getCidade().getText().equalsIgnoreCase("")){
            codigoCidade=0;
            CidadePesquisa cidadePesquisa = new CidadePesquisa();
            CidadePesquisaController cidadePesquisaController = new CidadePesquisaController(cidadePesquisa);
            cidadePesquisa.addWindowListener(disposeListenerCidade);
            cidadePesquisa.setVisible(true);
            }else{
                boolean validacao=true;
                for (Cidade cidadeAtual : Persiste.cidades) {
                    if(cidadeAtual.getDescricao().equalsIgnoreCase(this.enderecoRegistro.getCidade().getText())){
                        idCidade=cidadeAtual.getId()-1;
                        this.enderecoRegistro.getCidade().setText(cidadeAtual.getDescricao());
                        validacao=false;
                    }
                }
                if(validacao==true){
                    FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                    FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                    FeedbackEnderecoController.codigoFB=2;
                    feedbackEnderecoController.atualizacaoLabel();
                    feedbackENDERECO.setVisible(true);
                    }
            }
        }
    }

}
