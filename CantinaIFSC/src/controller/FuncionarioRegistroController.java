package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import model.bo.Endereco;
import model.bo.Funcionario;
import utilities.Utilities;
import view.EnderecoPesquisa;
import view.EnderecoRegistro;
import view.Feedback;
import view.FuncionarioPesquisa;
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

        Utilities.active(true, this.funcionarioRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.funcionarioRegistro.getPainelDados());

    }

    WindowListener disposeListener = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if (codigo != 0) {
                Funcionario funcionario = new Funcionario();
                funcionario = DAO.Persiste.funcionarios.get(codigo - 1);
                
               
                Utilities.active(false, funcionarioRegistro.getPainelBotoes());
                Utilities.limpaComponentes(true, funcionarioRegistro.getPainelDados());

                funcionarioRegistro.getId().setText(funcionario.getId()+"");
                funcionarioRegistro.getNome().setText(funcionario.getNome());
                funcionarioRegistro.getData().setText(funcionario.getDataNascimento());
                funcionarioRegistro.getCpf1().setText(funcionario.getCpf());
                funcionarioRegistro.getRg().setText(funcionario.getRg());
                funcionarioRegistro.getFone1().setText(funcionario.getFone1());
                funcionarioRegistro.getFone2().setText(funcionario.getFone2());
                funcionarioRegistro.getEmail().setText(funcionario.getEmail());

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
            }
        }
    };

    WindowListener disposeListenerEndereco = new WindowAdapter() {

        @Override
        public void windowClosed(WindowEvent e) {
            if (codigoEndereco != 0) {
                Endereco endereco = new Endereco();
                endereco = DAO.Persiste.enderecos.get(codigoEndereco - 1);
                idEndereco = endereco.getId() - 1;

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
        public void windowClosed(WindowEvent e){
           if (condicaoCadastro!=0){
            DAO.Persiste.funcionarios.get(idSenha).setSenha(senha);
            DAO.Persiste.funcionarios.get(idSenha).setUsuario(usuario);
            
            Feedback feedback=new Feedback();
            FeedbackController feedbackController= new FeedbackController(feedback);
            
            if(condicao==1){
                feedbackController.codigoFB=7;
                feedbackController.cadastroClasse();
            }else if(condicao==2){
                feedbackController.codigoFB=7;
                feedbackController.atualizacaoClasse();
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

        } else if (e.getSource() == this.funcionarioRegistro.getGravar()) {
            FuncionarioSenha funcionarioSenha = new FuncionarioSenha();
            FuncionarioSenhaController funcionarioSenhaController = new FuncionarioSenhaController(funcionarioSenha);
            
            Funcionario funcionario = new Funcionario();
            
            funcionario.setId(DAO.Persiste.funcionarios.size()+1);
            funcionario.setNome(this.funcionarioRegistro.getNome().getText());
            funcionario.setCpf(this.funcionarioRegistro.getCpf1().getText());
            funcionario.setRg(this.funcionarioRegistro.getRg().getText());
            funcionario.setDataNascimento(this.funcionarioRegistro.getData().getText());
            funcionario.setFone1(this.funcionarioRegistro.getFone1().getText());
            funcionario.setFone2(this.funcionarioRegistro.getFone2().getText());
            funcionario.setEmail(this.funcionarioRegistro.getEmail().getText());
            funcionario.setEndereco(DAO.Persiste.enderecos.get(idEndereco));
            
            
            
            if(this.funcionarioRegistro.getId().getText().equalsIgnoreCase("")){
                DAO.Persiste.funcionarios.add(funcionario);
                condicao=1;
                idSenha=funcionario.getId()-1;
            }else{
                int index = Integer.parseInt(this.funcionarioRegistro.getId().getText())-1;
                
                DAO.Persiste.funcionarios.get(index).setNome(this.funcionarioRegistro.getNome().getText());
                DAO.Persiste.funcionarios.get(index).setDataNascimento(this.funcionarioRegistro.getData().getText());
                DAO.Persiste.funcionarios.get(index).setCpf(this.funcionarioRegistro.getCpf1().getText());
                DAO.Persiste.funcionarios.get(index).setRg(this.funcionarioRegistro.getRg().getText());
                DAO.Persiste.funcionarios.get(index).setFone1(this.funcionarioRegistro.getFone1().getText());
                DAO.Persiste.funcionarios.get(index).setFone2(this.funcionarioRegistro.getFone2().getText());
                DAO.Persiste.funcionarios.get(index).setEmail(this.funcionarioRegistro.getEmail().getText());
                DAO.Persiste.funcionarios.get(index).setEndereco(DAO.Persiste.enderecos.get(idEndereco));
                condicao=2;
                idSenha=DAO.Persiste.funcionarios.get(index).getId()-1;
            }
            
            funcionarioSenha.addWindowListener(disposeListenerSenha);
            funcionarioSenha.setVisible(true);
           

        } else if (e.getSource() == this.funcionarioRegistro.getCancelar()) {
            Utilities.active(true, this.funcionarioRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.funcionarioRegistro.getPainelDados());

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
            EnderecoPesquisa enderecoPesquisa = new EnderecoPesquisa();
            EnderecoPesquisaController enderecoPesquisaController = new EnderecoPesquisaController(enderecoPesquisa);
            enderecoPesquisa.addWindowListener(disposeListenerEndereco);
            enderecoPesquisa.setVisible(true);
        }

    }

}
