
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Feedback;
import view.FeedbackSENHA;
import view.FuncionarioSenha;

public class FuncionarioSenhaController implements ActionListener{
        
    public FuncionarioSenha funcionarioSenha;

    public FuncionarioSenhaController(FuncionarioSenha funcionarioSenha) {
        this.funcionarioSenha = funcionarioSenha;
        
        this.funcionarioSenha.getSalvar().addActionListener(this);
        this.funcionarioSenha.getCancelar().addActionListener(this);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.funcionarioSenha.getCancelar()){
            FuncionarioRegistroController.condicaoCadastro=0;
            this.funcionarioSenha.dispose();
        }else if(e.getSource()==this.funcionarioSenha.getSalvar()){
            FuncionarioRegistroController.condicaoCadastro=1;
            String senha=String.valueOf(this.funcionarioSenha.getSenha().getPassword());
            String senhaTeste=String.valueOf(this.funcionarioSenha.getSenhaRepetir().getPassword());
            
            FuncionarioRegistroController.usuario=this.funcionarioSenha.getLogin().getText(); 
            if(senha.equals(senhaTeste)){
            FuncionarioRegistroController.senha=String.valueOf(this.funcionarioSenha.getSenha().getPassword());
            this.funcionarioSenha.dispose();
            }else{
                FeedbackSENHA feedbackSENHA = new FeedbackSENHA();
                FeedbackSenhaController fbc = new FeedbackSenhaController(feedbackSENHA);
                feedbackSENHA.setVisible(true);
            }
            
            
            
            
        }
    }
    
}
