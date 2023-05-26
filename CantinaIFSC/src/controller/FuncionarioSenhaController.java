
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            this.funcionarioSenha.dispose();
        }
    }
    
}
