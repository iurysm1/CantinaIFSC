package controller;

import model.DAO.Persiste;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import service.BairroService;
import service.CidadeService;
import service.EnderecoService;
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
    public int idCidadeBusca;
    public int idBairroBusca;
    
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
        this.enderecoRegistro.getIdBairro().addFocusListener(focusBairro);
        this.enderecoRegistro.getIdCidade().addFocusListener(focusCidade);
        this.enderecoRegistro.getLogradouro().addFocusListener(focusLogradouro);
        this.enderecoRegistro.getCep().addFocusListener(focusCep);
        
        
        
        Utilities.active(true, this.enderecoRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.enderecoRegistro.getPainelDados());
    }
    
    FocusListener focusLogradouro = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            Utilities.turnTextFieldGray(enderecoRegistro.getLogradouro());  
        }

        @Override
        public void focusLost(FocusEvent e) {
            
            Utilities.turnTextFieldRed(enderecoRegistro.getLogradouro());
        }
    };
    FocusListener focusBairro = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            Utilities.turnTextFieldGray(enderecoRegistro.getIdBairro());
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            
            Utilities.turnTextFieldRed(enderecoRegistro.getIdBairro());
            if(enderecoRegistro.getIdBairro().getText().equalsIgnoreCase("*Campo obrigatório*")){
                enderecoRegistro.getIdBairro().setText("");
            }
                    
        }
    };
    FocusListener focusCidade = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            Utilities.turnTextFieldGray(enderecoRegistro.getIdCidade());
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            
            Utilities.turnTextFieldRed(enderecoRegistro.getIdCidade());
            if(enderecoRegistro.getIdCidade().getText().equalsIgnoreCase("*Campo obrigatório*")){
                enderecoRegistro.getIdCidade().setText("");
            }
            
        }
    };
    FocusListener focusCep = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            
            Utilities.turnCepTextFieldGray(enderecoRegistro.getCep());
        }

        @Override
        public void focusLost(FocusEvent e) {
            
            Utilities.turnCepTextFieldRed(enderecoRegistro.getCep());
        }
    };
    
    WindowListener disposeListener = new WindowAdapter() {
        
        public void windowClosed(WindowEvent e){
            if(codigo!=0){
                Endereco endereco = new Endereco();
                endereco=EnderecoService.carregar(codigo);
                Utilities.active(false, enderecoRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, enderecoRegistro.getPainelDados());
                
                enderecoRegistro.getId().setText(endereco.getId()+"");
                enderecoRegistro.getCep().setText(endereco.getCep());
                enderecoRegistro.getLogradouro().setText(endereco.getLogradouro());
                
                enderecoRegistro.getBairro().setText(endereco.getBairro().getDescricao());
                enderecoRegistro.getCidade().setText(endereco.getCidade().getDescricao());
                enderecoRegistro.getIdCidade().setText(endereco.getCidade().getId()+"");
                enderecoRegistro.getIdBairro().setText(endereco.getBairro().getId()+"");
                
                idBairroBusca=endereco.getBairro().getId();
                idCidadeBusca=endereco.getCidade().getId();
                
                if(endereco.getStatus().equalsIgnoreCase("A")){
                    enderecoRegistro.getStatus().setSelectedIndex(0);
                }else{
                    enderecoRegistro.getStatus().setSelectedIndex(1);
                }
                enderecoRegistro.getId().setEnabled(false);
                enderecoRegistro.getCidade().setEnabled(false);
                enderecoRegistro.getBairro().setEnabled(false);

           }
        }
    };
    WindowListener disposeListenerBairro = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if(codigoBairro!=0){
                Bairro bairro;
                bairro=BairroService.carregar(codigoBairro);
                Utilities.active(false, enderecoRegistro.getPainelBotoes());
                enderecoRegistro.getBairro().setEnabled(false);
                
                enderecoRegistro.getBairro().setText(bairro.getDescricao());
                enderecoRegistro.getIdBairro().setText(bairro.getId()+"");
                idBairroBusca=bairro.getId();
                
                
            }
        }
    };
    WindowListener disposeListenerCidade = new WindowAdapter() {
         @Override
         public void windowClosed(WindowEvent e){
            if(codigoCidade!=0){
                Cidade cidade;
                cidade=CidadeService.carregar(codigoCidade);
                Utilities.active(false, enderecoRegistro.getPainelBotoes());
                
                
                enderecoRegistro.getCidade().setText(cidade.getDescricao());
                enderecoRegistro.getIdCidade().setText(cidade.getId()+"");
                enderecoRegistro.getCidade().setEnabled(false);
                idCidadeBusca=cidade.getId();
            }
            }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.enderecoRegistro.getNovo()) {
            System.out.println(this.enderecoRegistro.getCep());
            Utilities.active(false, this.enderecoRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.enderecoRegistro.getPainelDados());
            this.enderecoRegistro.getId().setEnabled(false);
            this.enderecoRegistro.getBairro().setEnabled(false);
            this.enderecoRegistro.getCidade().setEnabled(false);
            
        } else if (e.getSource() == this.enderecoRegistro.getGravar()) {
            if(Utilities.isDataEmpty(this.enderecoRegistro.getLogradouro(), this.enderecoRegistro.getIdBairro(), this.enderecoRegistro.getIdCidade())){
                FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                FeedbackEnderecoController.codigoFB=4;
                feedbackEnderecoController.atualizacaoLabel();
                feedbackENDERECO.setVisible(true);
            }else{
                Endereco endereco = new Endereco();
            
            
                endereco.setLogradouro(this.enderecoRegistro.getLogradouro().getText());
                endereco.setCep(this.enderecoRegistro.getCep().getText());
                endereco.setBairro(BairroService.carregar(idBairroBusca));
                endereco.setCidade(CidadeService.carregar(idCidadeBusca));

                if(this.enderecoRegistro.getStatus().getSelectedIndex()==0){
                    endereco.setStatus("A");
                }else{
                    endereco.setStatus("D");
                }
                Feedback feedback=new Feedback();
                FeedbackController feedbackController= new FeedbackController(feedback);
                if(this.enderecoRegistro.getId().getText().equalsIgnoreCase("")){
                    EnderecoService.adicionar(endereco);
                    feedbackController.cadastroClasse(3);


                }else{
                    endereco.setId(codigo);
                    EnderecoService.atualizar(endereco);
                    feedbackController.atualizacaoClasse(3);

                }


                feedback.setVisible(true);

                Utilities.active(true, this.enderecoRegistro.getPainelBotoes());
                Utilities.limpaComponentes(false, this.enderecoRegistro.getPainelDados());

            }

            
            
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
            Utilities.turnTextFieldGray(enderecoRegistro.getIdBairro());
            if(this.enderecoRegistro.getIdBairro().getText().equalsIgnoreCase("")){
            codigoBairro=0;
            BairroPesquisa bairroPesquisa = new BairroPesquisa();
            BairroPesquisaController bairroPesquisaController = new BairroPesquisaController(bairroPesquisa);
            bairroPesquisa.addWindowListener(disposeListenerBairro);
            bairroPesquisa.setVisible(true);
            }else{
                Bairro bairroPesquisa = BairroService.carregar(Integer.parseInt(this.enderecoRegistro.getIdBairro().getText()));
                
                idBairroBusca = bairroPesquisa.getId();
                
                this.enderecoRegistro.getBairro().setText(bairroPesquisa.getDescricao());
                
                boolean validacao=true;
                for (Bairro bairroAtual : BairroService.carregar()) {
                    if(bairroAtual.getId()==Integer.parseInt(this.enderecoRegistro.getIdBairro().getText())){
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
            Utilities.turnTextFieldGray(enderecoRegistro.getIdCidade());
            if(this.enderecoRegistro.getIdCidade().getText().equalsIgnoreCase("")){
            codigoCidade=0;
            CidadePesquisa cidadePesquisa = new CidadePesquisa();
            CidadePesquisaController cidadePesquisaController = new CidadePesquisaController(cidadePesquisa);
            cidadePesquisa.addWindowListener(disposeListenerCidade);
            cidadePesquisa.setVisible(true);
            }else{
                Cidade cidadePesquisa= CidadeService.carregar(Integer.parseInt(this.enderecoRegistro.getIdCidade().getText()));
                
                this.enderecoRegistro.getCidade().setText(cidadePesquisa.getDescricao());
                idCidadeBusca=cidadePesquisa.getId();
                
                boolean validacao=true;
                for (Cidade cidadeAtual : CidadeService.carregar()) {
                    if(cidadeAtual.getId()== Integer.parseInt(this.enderecoRegistro.getIdCidade().getText())){
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
