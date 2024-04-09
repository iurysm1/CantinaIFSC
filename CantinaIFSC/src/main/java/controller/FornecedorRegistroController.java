package controller;

import static controller.FuncionarioRegistroController.idEndereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import model.DAO.Persiste;
import model.bo.Endereco;
import model.bo.Fornecedor;
import service.EnderecoService;
import service.FornecedorService;
import utilities.Utilities;
import view.EnderecoPesquisa;
import view.EnderecoRegistro;
import view.Feedback;
import view.FeedbackENDERECO;
import view.FornecedorPesquisa;
import view.FornecedorRegistro;

public class FornecedorRegistroController implements ActionListener {

    FornecedorRegistro fornecedorRegistro;
    public static int codigo, codigoEndereco, idEndereco;

    public FornecedorRegistroController(FornecedorRegistro fornecedorRegistro) {
        this.fornecedorRegistro = fornecedorRegistro;

        this.fornecedorRegistro.getNovo().addActionListener(this);
        this.fornecedorRegistro.getGravar().addActionListener(this);
        this.fornecedorRegistro.getCancelar().addActionListener(this);
        this.fornecedorRegistro.getPesquisar().addActionListener(this);
        this.fornecedorRegistro.getSair().addActionListener(this);
        this.fornecedorRegistro.getPesquisarCep().addActionListener(this);
        this.fornecedorRegistro.getAdicionarCep().addActionListener(this);
        this.fornecedorRegistro.getNome().addFocusListener(focusNome);
        this.fornecedorRegistro.getCnpj().addFocusListener(focusCpf);
        this.fornecedorRegistro.getCep().addFocusListener(focusCep);
        this.fornecedorRegistro.getInscricaoEstadual().addFocusListener(focusMatricula);

        Utilities.active(true, this.fornecedorRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.fornecedorRegistro.getPainelDados());

    }
    
    FocusListener focusCep = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(fornecedorRegistro.getCep());
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnCepTextFieldRed(fornecedorRegistro.getCep());
        }
    };
    
    FocusListener focusMatricula = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnTextFieldGray(fornecedorRegistro.getInscricaoEstadual());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnTextFieldRed(fornecedorRegistro.getInscricaoEstadual());
        }
    };
    
    FocusListener focusCpf = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(fornecedorRegistro.getCnpj());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnCepTextFieldRed(fornecedorRegistro.getCnpj());
        }
    };
    
    FocusListener focusNome = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnTextFieldGray(fornecedorRegistro.getNome());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnTextFieldRed(fornecedorRegistro.getNome());
        }
    };

    WindowListener disposeListener = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if (codigo != 0) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor = FornecedorService.carregar(codigo);
                Utilities.active(false, fornecedorRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, fornecedorRegistro.getPainelDados());

                fornecedorRegistro.getId().setText(fornecedor.getId() + "");
                fornecedorRegistro.getNome().setText(fornecedor.getNome());// ou razao social
                fornecedorRegistro.getEmail().setText(fornecedor.getEmail());
                fornecedorRegistro.getCnpj().setText(fornecedor.getCnpj());
                fornecedorRegistro.getFone1().setText(fornecedor.getFone1());
                System.out.println(fornecedor.getFone1());
                fornecedorRegistro.getFone2().setText(fornecedor.getFone2());
                fornecedorRegistro.getInscricaoEstadual().setText(fornecedor.getInscricaoestadual());

                fornecedorRegistro.getCep().setText(fornecedor.getEndereco().getCep());
                fornecedorRegistro.getUf().setText(fornecedor.getEndereco().getCidade().getUf());
                fornecedorRegistro.getCidade().setText(fornecedor.getEndereco().getCidade().getDescricao());
                fornecedorRegistro.getBairro().setText(fornecedor.getEndereco().getBairro().getDescricao());
                fornecedorRegistro.getLogradouro().setText(fornecedor.getEndereco().getLogradouro());
                fornecedorRegistro.getComplemento().setText(fornecedor.getComplementoEndereco());

                fornecedorRegistro.getId().setEnabled(false);
                fornecedorRegistro.getUf().setEnabled(false);
                fornecedorRegistro.getCidade().setEnabled(false);
                fornecedorRegistro.getBairro().setEnabled(false);
                fornecedorRegistro.getLogradouro().setEnabled(false);
                
                if(fornecedor.getStatus().equalsIgnoreCase("A")){
                    fornecedorRegistro.getStatus().setSelectedIndex(0);
                }else{
                    fornecedorRegistro.getStatus().setSelectedIndex(1);
                }
                
                idEndereco=fornecedor.getEndereco().getId();
            }
        }
    };
    WindowListener disposeListenerEndereco=new WindowAdapter() {
    
        @Override
        public void windowClosed(WindowEvent e){
            if(codigoEndereco!=0){
                Endereco endereco = new Endereco();
                endereco=EnderecoService.carregar(codigoEndereco);
                idEndereco=endereco.getId();
                
                fornecedorRegistro.getCep().setText(endereco.getCep());
                fornecedorRegistro.getCidade().setText(endereco.getCidade().getDescricao());
                fornecedorRegistro.getBairro().setText(endereco.getBairro().getDescricao());
                fornecedorRegistro.getUf().setText(endereco.getCidade().getUf());
                fornecedorRegistro.getLogradouro().setText(endereco.getLogradouro());
                
                fornecedorRegistro.getLogradouro().setEnabled(false);
                fornecedorRegistro.getUf().setEnabled(false);
                fornecedorRegistro.getCidade().setEnabled(false);
                fornecedorRegistro.getBairro().setEnabled(false);

            }
            
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.fornecedorRegistro.getNovo()) {
            System.out.println(this.fornecedorRegistro.getCnpj().getValue());
            System.out.println(this.fornecedorRegistro.getCep().getValue());
            
            Utilities.active(false, this.fornecedorRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.fornecedorRegistro.getPainelDados());

            fornecedorRegistro.getId().setEnabled(false);
            fornecedorRegistro.getUf().setEnabled(false);
            fornecedorRegistro.getCidade().setEnabled(false);
            fornecedorRegistro.getBairro().setEnabled(false);
            fornecedorRegistro.getLogradouro().setEnabled(false);
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getGravar()) {
            
            if(Utilities.isDataEmpty(this.fornecedorRegistro.getNome(),this.fornecedorRegistro.getInscricaoEstadual())||Utilities.isFormattedDataEmpty(this.fornecedorRegistro.getCep(),this.fornecedorRegistro.getCnpj())){
                FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                FeedbackEnderecoController.codigoFB=4;
                feedbackEnderecoController.atualizacaoLabel();
                feedbackENDERECO.setVisible(true);
            }else{
                Fornecedor fornecedor = new Fornecedor();
            
                fornecedor.setInscricaoestadual(this.fornecedorRegistro.getInscricaoEstadual().getText());
                fornecedor.setNome(this.fornecedorRegistro.getNome().getText());
                fornecedor.setEmail(this.fornecedorRegistro.getEmail().getText());
                fornecedor.setCnpj(this.fornecedorRegistro.getCnpj().getText());
                fornecedor.setFone1(this.fornecedorRegistro.getFone1().getText());
                fornecedor.setFone2(this.fornecedorRegistro.getFone2().getText());
                fornecedor.setComplementoEndereco(this.fornecedorRegistro.getComplemento().getText());

                fornecedor.setEndereco(EnderecoService.carregar(idEndereco));

                if(this.fornecedorRegistro.getStatus().getSelectedIndex()==0){
                    fornecedor.setStatus("A");
                }else{
                    fornecedor.setStatus("D");
                }

                Feedback feedback=new Feedback();
                FeedbackController feedbackController= new FeedbackController(feedback);
                if(this.fornecedorRegistro.getId().getText().equalsIgnoreCase("")){
                    FornecedorService.adicionar(fornecedor);
                    feedbackController.cadastroClasse(8);
                }else{
                    fornecedor.setId(codigo);
                    FornecedorService.atualizar(fornecedor);

                    feedbackController.atualizacaoClasse(8);
                }

                feedback.setVisible(true);
                Utilities.active(true, this.fornecedorRegistro.getPainelBotoes());
                Utilities.limpaComponentes(false, this.fornecedorRegistro.getPainelDados());
            
            }
            
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getCancelar()) {
            Utilities.active(true, this.fornecedorRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.fornecedorRegistro.getPainelDados());
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getSair()) {
            this.fornecedorRegistro.dispose();
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getPesquisar()) {
            FornecedorPesquisa fornecedorPesquisa = new FornecedorPesquisa();
            FornecedorPesquisaController fornecedorPesquisaController = new FornecedorPesquisaController(fornecedorPesquisa);
            fornecedorPesquisa.addWindowListener(disposeListener);
            fornecedorPesquisa.setVisible(true);
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getAdicionarCep()) {
            EnderecoRegistro enderecoRegistro = new EnderecoRegistro();
            EnderecoRegistroController enderecoRegistroController = new EnderecoRegistroController(enderecoRegistro);
            enderecoRegistro.setVisible(true);
            
            
        } else if (e.getSource() == this.fornecedorRegistro.getPesquisarCep()) {
            boolean validacao=true;
            if(this.fornecedorRegistro.getCep().getText().equalsIgnoreCase("")){
            EnderecoPesquisa enderecoPesquisa = new EnderecoPesquisa();
            EnderecoPesquisaController enderecoPesquisaController = new EnderecoPesquisaController(enderecoPesquisa);
            enderecoPesquisa.addWindowListener(disposeListenerEndereco);
            enderecoPesquisa.setVisible(true);
            
        }else{
             validacao=true;
                for (Endereco enderecoAtual : EnderecoService.carregar()) {
                    if(enderecoAtual.getCep().equalsIgnoreCase(this.fornecedorRegistro.getCep().getText())){
                        validacao=false;
                    }
                }
                if(validacao==true){
                    FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                    FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                    feedbackEnderecoController.atualizacaoLabel();
                    feedbackENDERECO.setVisible(true);
                    }else{
                        Endereco enderecoPesquisa = EnderecoService.carregar(this.fornecedorRegistro.getCep().getText(), "cep").get(0);
                        idEndereco=enderecoPesquisa.getId();
                        this.fornecedorRegistro.getBairro().setText(enderecoPesquisa.getBairro().getDescricao());
                        this.fornecedorRegistro.getCidade().setText(enderecoPesquisa.getCidade().getDescricao());
                        this.fornecedorRegistro.getUf().setText(enderecoPesquisa.getCidade().getUf());
                        this.fornecedorRegistro.getLogradouro().setText(enderecoPesquisa.getLogradouro());
                        this.fornecedorRegistro.getCep().setText(enderecoPesquisa.getCep());
                }
            }
        }
    }

}
