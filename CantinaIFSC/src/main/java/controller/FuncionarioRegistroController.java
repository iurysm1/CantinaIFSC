package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import model.DAO.Persiste;
import model.bo.Endereco;
import model.bo.Funcionario;
import service.EnderecoService;
import service.FuncionarioService;
import utilities.Utilities;
import view.EnderecoPesquisa;
import view.EnderecoRegistro;
import view.Feedback;
import view.FeedbackENDERECO;
import view.FuncionarioPesquisa;
import view.FuncionarioRedefinirSenha;
import view.FuncionarioRegistro;
import view.FuncionarioSenha;

public class FuncionarioRegistroController implements ActionListener {

    FuncionarioRegistro funcionarioRegistro;
    public static int codigo, codigoEndereco, idEndereco, idSenha, condicao, condicaoCadastro;
    public static String senha, usuario;

    public FuncionarioRegistroController(FuncionarioRegistro funcionarioRegistro) {
        this.funcionarioRegistro = funcionarioRegistro;

        this.funcionarioRegistro.getNovo().addActionListener(this);
        this.funcionarioRegistro.getGravar().addActionListener(this);
        this.funcionarioRegistro.getCancelar().addActionListener(this);
        this.funcionarioRegistro.getPesquisar().addActionListener(this);
        this.funcionarioRegistro.getSair().addActionListener(this);
        this.funcionarioRegistro.getNovoCep().addActionListener(this);
        this.funcionarioRegistro.getPesquisaCep().addActionListener(this);
        this.funcionarioRegistro.getRedefinirSenha().addActionListener(this);
        this.funcionarioRegistro.getNome().addFocusListener(focusNome);
        this.funcionarioRegistro.getData().addFocusListener(focusData);
        this.funcionarioRegistro.getCep().addFocusListener(focusCep);
        this.funcionarioRegistro.getCpf1().addFocusListener(focusCpf);

        Utilities.active(true, this.funcionarioRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.funcionarioRegistro.getPainelDados());

    }
    
    FocusListener focusCep = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(funcionarioRegistro.getCep());
            
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnCepTextFieldRed(funcionarioRegistro.getCep());
        }
    };
    
    FocusListener focusData = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(funcionarioRegistro.getData());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnCepTextFieldRed(funcionarioRegistro.getData());
        }
    };
    
    FocusListener focusCpf = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnCepTextFieldGray(funcionarioRegistro.getCpf1());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnCpfTextFieldRed(funcionarioRegistro.getCpf1());
        }
    };
    
    FocusListener focusNome = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            Utilities.turnTextFieldGray(funcionarioRegistro.getNome());
        }

        @Override
        public void focusLost(FocusEvent e) {
            Utilities.turnTextFieldRed(funcionarioRegistro.getNome());
        }
    };

    WindowListener disposeListener = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if (codigo != 0) {
                Funcionario funcionario = new Funcionario();
                funcionario = FuncionarioService.carregar(codigo);

                Utilities.active(false, funcionarioRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, funcionarioRegistro.getPainelDados());

                funcionarioRegistro.getId().setText(funcionario.getId() + "");
                funcionarioRegistro.getNome().setText(funcionario.getNome());
                funcionarioRegistro.getData().setText(Utilities.dateToString(funcionario.getDataNascimento()));
                funcionarioRegistro.getCpf1().setText(funcionario.getCpf());
                funcionarioRegistro.getRg().setText(funcionario.getRg());
                funcionarioRegistro.getFone1().setText(funcionario.getFone1());
                funcionarioRegistro.getFone2().setText(funcionario.getFone2());
                funcionarioRegistro.getEmail().setText(funcionario.getEmail());
                senha=funcionario.getSenha();
                usuario=funcionario.getUsuario();

                funcionarioRegistro.getCep().setText(funcionario.getEndereco().getCep());
                funcionarioRegistro.getUf().setText(funcionario.getEndereco().getCidade().getUf());
                funcionarioRegistro.getCidade().setText(funcionario.getEndereco().getCidade().getDescricao());
                funcionarioRegistro.getBairro().setText(funcionario.getEndereco().getBairro().getDescricao());
                funcionarioRegistro.getLogradouro().setText(funcionario.getEndereco().getLogradouro());
                funcionarioRegistro.getComplemento().setText(funcionario.getComplementoEndereco());

                funcionarioRegistro.getId().setEnabled(false);
                funcionarioRegistro.getUf().setEnabled(false);
                funcionarioRegistro.getBairro().setEnabled(false);
                funcionarioRegistro.getCidade().setEnabled(false);
                funcionarioRegistro.getLogradouro().setEnabled(false);
                
                if(funcionario.getStatus().equalsIgnoreCase("A")){
                    funcionarioRegistro.getStatus().setSelectedIndex(0);
                }else{
                    funcionarioRegistro.getStatus().setSelectedIndex(1);
                }
                
                idEndereco=funcionario.getEndereco().getId();
            }
        }
    };

    WindowListener disposeListenerEndereco = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if (codigoEndereco != 0) {
                Endereco endereco = new Endereco();
                endereco = EnderecoService.carregar(codigoEndereco);
                idEndereco = endereco.getId();

                funcionarioRegistro.getCep().setText(endereco.getCep());
                funcionarioRegistro.getBairro().setText(endereco.getBairro().getDescricao());
                funcionarioRegistro.getCidade().setText(endereco.getCidade().getDescricao());
                funcionarioRegistro.getLogradouro().setText(endereco.getLogradouro());
                funcionarioRegistro.getUf().setText(endereco.getCidade().getDescricao());

            }
        }

    };
    WindowListener disposeListenerSenha = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if (condicaoCadastro != 0) {
                
                FuncionarioService.atualizarSenha(senha, usuario, codigo);
                
                Feedback feedback = new Feedback();
                FeedbackController feedbackController = new FeedbackController(feedback);

                if (condicao == 1) {
                    feedbackController.cadastroClasse(7);
                } else if (condicao == 2) {
                    feedbackController.atualizacaoClasse(7);
                }
                feedback.setVisible(true);
                Utilities.active(true, funcionarioRegistro.getPainelBotoes());
                Utilities.limpaComponentes(false, funcionarioRegistro.getPainelDados());
            }

            // JOptionPane.showMessageDialog(null, "Seu usuário foi criado com sucesso, seus dados de login são, Login: "+DAO.Persiste.funcionarios.get(idSenha).getUsuario()+", Senha: "+DAO.Persiste.funcionarios.get(idSenha).getSenha());
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.funcionarioRegistro.getNovo()) {
            Utilities.active(false, this.funcionarioRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.funcionarioRegistro.getPainelDados());

            this.funcionarioRegistro.getId().setEnabled(false);
            this.funcionarioRegistro.getUf().setEnabled(false);
            this.funcionarioRegistro.getBairro().setEnabled(false);
            this.funcionarioRegistro.getCidade().setEnabled(false);
            this.funcionarioRegistro.getLogradouro().setEnabled(false);
            
            this.senha="";
            this.usuario="";

        } else if (e.getSource() == this.funcionarioRegistro.getGravar()) {
            
            if(Utilities.isDataEmpty(this.funcionarioRegistro.getNome())||Utilities.isFormattedDataEmpty(this.funcionarioRegistro.getData(),this.funcionarioRegistro.getCep(),this.funcionarioRegistro.getCpf1())){
                FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                FeedbackEnderecoController.codigoFB=4;
                feedbackEnderecoController.atualizacaoLabel();
                feedbackENDERECO.setVisible(true);
            }else{
                FuncionarioSenha funcionarioSenha = new FuncionarioSenha();
            FuncionarioSenhaController funcionarioSenhaController = new FuncionarioSenhaController(funcionarioSenha);

            Funcionario funcionario = new Funcionario();

            
            funcionario.setNome(this.funcionarioRegistro.getNome().getText());
            funcionario.setCpf(this.funcionarioRegistro.getCpf1().getText());
            funcionario.setRg(this.funcionarioRegistro.getRg().getText());
            funcionario.setDataNascimento(Utilities.stringToDate(this.funcionarioRegistro.getData().getText()));
            funcionario.setFone1(this.funcionarioRegistro.getFone1().getText());
            funcionario.setFone2(this.funcionarioRegistro.getFone2().getText());
            funcionario.setEmail(this.funcionarioRegistro.getEmail().getText());
            funcionario.setComplementoEndereco(this.funcionarioRegistro.getComplemento().getText());
            funcionario.setEndereco(EnderecoService.carregar(idEndereco));
            
            if(this.funcionarioRegistro.getStatus().getSelectedIndex()==0){
                funcionario.setStatus("A");
            }else{
                funcionario.setStatus("D");
            }

            if (this.funcionarioRegistro.getId().getText().equalsIgnoreCase("")) {
                
                condicao = 1;
                //idSenha = funcionario.getId();
                funcionarioSenha.addWindowListener(disposeListenerSenha);
                
                
                funcionarioSenha.setVisible(true);
                FuncionarioService.adicionar(funcionario);
                
            } else {
                Feedback feedback=new Feedback();
                FeedbackController feedbackController= new FeedbackController(feedback);
                
                funcionario.setId(Integer.parseInt(this.funcionarioRegistro.getId().getText()));
                FuncionarioService.atualizar(funcionario);
                
                condicao = 2;
                
                feedbackController.atualizacaoClasse(7);
                feedback.setVisible(true);
                 Utilities.active(true, this.funcionarioRegistro.getPainelBotoes());
                Utilities.limpaComponentes(false, this.funcionarioRegistro.getPainelDados());
            }
        }
            
            

        } else if (e.getSource() == this.funcionarioRegistro.getCancelar()) {
            Utilities.active(true, this.funcionarioRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.funcionarioRegistro.getPainelDados());
            this.senha="";
            this.usuario="";

        } else if (e.getSource() == this.funcionarioRegistro.getPesquisar()) {
            FuncionarioPesquisa funcionarioPesquisa = new FuncionarioPesquisa();
            FuncionarioPesquisaController funcionarioPesquisaController = new FuncionarioPesquisaController(funcionarioPesquisa);
            funcionarioPesquisa.addWindowListener(disposeListener);
            funcionarioPesquisa.setVisible(true);

        } else if (e.getSource() == this.funcionarioRegistro.getSair()) {
            this.funcionarioRegistro.dispose();

        } else if (e.getSource() == this.funcionarioRegistro.getNovoCep()) {
            EnderecoRegistro enderecoRegistro = new EnderecoRegistro();
            EnderecoRegistroController enderecoRegistroController = new EnderecoRegistroController(enderecoRegistro);
            enderecoRegistro.setVisible(true);

        } else if (e.getSource() == this.funcionarioRegistro.getPesquisaCep()) {

            if (this.funcionarioRegistro.getCep().getText().equalsIgnoreCase("")) {
                EnderecoPesquisa enderecoPesquisa = new EnderecoPesquisa();
                EnderecoPesquisaController enderecoPesquisaController = new EnderecoPesquisaController(enderecoPesquisa);
                enderecoPesquisa.addWindowListener(disposeListenerEndereco);
                enderecoPesquisa.setVisible(true);
            }else{
                boolean validacao=true;
                for (Endereco enderecoAtual : EnderecoService.carregar()) {
                    if(enderecoAtual.getCep().equalsIgnoreCase(this.funcionarioRegistro.getCep().getText())){
                        validacao=false;
                    }
                }
                if(validacao==true){
                    FeedbackENDERECO feedbackENDERECO = new FeedbackENDERECO();
                    FeedbackEnderecoController feedbackEnderecoController = new FeedbackEnderecoController(feedbackENDERECO);
                    feedbackEnderecoController.atualizacaoLabel();
                    feedbackENDERECO.setVisible(true);
                    }else{
                    Endereco enderecoPesquisa = EnderecoService.carregar(this.funcionarioRegistro.getCep().getText(), "cep").get(0);
                    idEndereco=enderecoPesquisa.getId();
                    this.funcionarioRegistro.getBairro().setText(enderecoPesquisa.getBairro().getDescricao());
                    this.funcionarioRegistro.getCidade().setText(enderecoPesquisa.getCidade().getDescricao());     
                    this.funcionarioRegistro.getUf().setText(enderecoPesquisa.getCidade().getUf());
                    this.funcionarioRegistro.getLogradouro().setText(enderecoPesquisa.getLogradouro());
                    this.funcionarioRegistro.getCep().setText(enderecoPesquisa.getCep());
                            
                    
                }
            }
        }else if(e.getSource()==this.funcionarioRegistro.getRedefinirSenha()){
            FuncionarioRedefinirSenha funcionarioRedefSenha = new FuncionarioRedefinirSenha();
            FuncionarioRedefinirSenhaController funcionarioRedefinirSenhaController = new FuncionarioRedefinirSenhaController(funcionarioRedefSenha);
            
            funcionarioRedefSenha.setVisible(true);
        }

    }

}
