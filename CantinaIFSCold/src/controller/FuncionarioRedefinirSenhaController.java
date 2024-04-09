package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Funcionario;
import view.Feedback;
import view.FeedbackSENHA;
import view.FuncionarioRedefinirSenha;
import view.FuncionarioSenha;
import model.DAO.Persiste;
import service.FuncionarioService;

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
            for (Funcionario funcionarioAtual : FuncionarioService.carregar()) {
                if (this.funcionarioSenha.getLogin().getText().equals(funcionarioAtual.getUsuario())) {
                    funcionarioSenha = FuncionarioService.carregar(funcionarioAtual.getId());
                    break;
                }
            }
            System.out.println(funcionarioSenha.getNome());
            System.out.println("antiga: "+funcionarioSenha.getSenha());
            
            String senhaAntiga = String.valueOf(this.funcionarioSenha.getSenhaAntiga().getPassword());
            String senha = String.valueOf(this.funcionarioSenha.getSenha().getPassword());
            String senhaTeste = String.valueOf(this.funcionarioSenha.getSenhaRepetir().getPassword());

            if (senhaAntiga.equals(funcionarioSenha.getSenha())) {
                if (senha.equals(senhaTeste)) {
                    FuncionarioService.atualizarSenha(senha, funcionarioSenha.getUsuario(), funcionarioSenha.getId());
                    Feedback feedback = new Feedback();
                    FeedbackController feedbackController = new FeedbackController(feedback);
                    this.funcionarioSenha.dispose();
                    feedbackController.atualizacaoClasse(7);
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
