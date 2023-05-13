
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Utilities;
import view.FuncionarioPesquisa;
import view.FuncionarioRegistro;

public class FuncionarioRegistroController implements ActionListener{

    
    FuncionarioRegistro funcionarioRegistro;

    public FuncionarioRegistroController(FuncionarioRegistro funcionarioRegistro) {
        this.funcionarioRegistro=funcionarioRegistro;
        
        this.funcionarioRegistro.getNovo().addActionListener(this);
        this.funcionarioRegistro.getGravar().addActionListener(this);
        this.funcionarioRegistro.getCancelar().addActionListener(this);
        this.funcionarioRegistro.getPesquisar().addActionListener(this);
        this.funcionarioRegistro.getSair().addActionListener(this);
        
        Utilities.active(true, this.funcionarioRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.funcionarioRegistro.getPainelDados());
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.funcionarioRegistro.getNovo()){
            Utilities.active(false, this.funcionarioRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.funcionarioRegistro.getPainelDados());
        }else if(e.getSource()==this.funcionarioRegistro.getGravar()){
            Utilities.active(true, this.funcionarioRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.funcionarioRegistro.getPainelDados());
        }else if(e.getSource()==this.funcionarioRegistro.getCancelar()){
            Utilities.active(true, this.funcionarioRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.funcionarioRegistro.getPainelDados());
        }else if(e.getSource()==this.funcionarioRegistro.getPesquisar()){
            FuncionarioPesquisa funcionarioPesquisa=new FuncionarioPesquisa();
            FuncionarioPesquisaController funcionarioPesquisaController=new FuncionarioPesquisaController(funcionarioPesquisa);
            funcionarioPesquisa.setVisible(true);
            
        }else if(e.getSource()==this.funcionarioRegistro.getSair()){
            this.funcionarioRegistro.dispose();
        }
        
    }
    
}
