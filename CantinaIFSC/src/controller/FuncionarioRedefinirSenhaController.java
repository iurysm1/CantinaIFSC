package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Funcionario;
import view.Feedback;
import view.FeedbackSENHA;
import view.FuncionarioRedefinirSenha;
import view.FuncionarioSenha;

public class FuncionarioRedefinirSenhaController implements ActionListener {

    public FuncionarioRedefinirSenha funcionarioSenha;

    public FuncionarioRedefinirSenhaController(FuncionarioRedefinirSenha funcionarioSenha) {
        this.funcionarioSenha = funcionarioSenha;

        this.funcionarioSenha.getSalvar().addActionListener(this);
        this.funcionarioSenha.getCancelar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.funcionarioSenha.getCancelar()) {

            this.funcionarioSenha.dispose();
        } else if (e.getSource() == this.funcionarioSenha.getSalvar()) {
            Funcionario funcionarioSenha = new Funcionario();
            for (Funcionario funcionarioAtual : DAO.Persiste.funcionarios) {
                if (this.funcionarioSenha.getLogin().getText().equals(funcionarioAtual.getUsuario())) {
                    funcionarioSenha = DAO.Persiste.funcionarios.get(funcionarioAtual.getId()-1);
                    break;
                }
            }System.out.println(funcionarioSenha.getNome());
            System.out.println("antiga: "+funcionarioSenha.getSenha());
            
            String senhaAntiga = String.valueOf(this.funcionarioSenha.getSenhaAntiga().getPassword());
            String senha = String.valueOf(this.funcionarioSenha.getSenha().getPassword());
            String senhaTeste = String.valueOf(this.funcionarioSenha.getSenhaRepetir().getPassword());

            if (senhaAntiga.equals(funcionarioSenha.getSenha())) {
                if (senha.equals(senhaTeste)) {
                    funcionarioSenha.setSenha(senha);
                    Feedback feedback = new Feedback();
                    FeedbackController feedbackController = new FeedbackController(feedback);
                    this.funcionarioSenha.dispose();
                    feedbackController.codigoFB = 7;
                    feedbackController.atualizacaoClasse();
                    feedback.setVisible(true);
                } else {
                    FeedbackSENHA feedbackSENHA = new FeedbackSENHA();
                    FeedbackSenhaController fbc = new FeedbackSenhaController(feedbackSENHA);
                    
                    feedbackSENHA.setVisible(true);
                }System.out.println("nova: "+funcionarioSenha.getSenha());
            }else{
                FeedbackSENHA feedbackSENHA = new FeedbackSENHA();
                    FeedbackSenhaController fbc = new FeedbackSenhaController(feedbackSENHA);
                    
                    feedbackSENHA.setVisible(true);
            }

        }
    }
}
