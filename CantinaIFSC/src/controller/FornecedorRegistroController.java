
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Utilities;
import view.EnderecoPesquisa;
import view.EnderecoRegistro;
import view.FornecedorPesquisa;
import view.FornecedorRegistro;

public class FornecedorRegistroController implements ActionListener{

    FornecedorRegistro fornecedorRegistro;

    public FornecedorRegistroController(FornecedorRegistro fornecedorRegistro) {
        this.fornecedorRegistro = fornecedorRegistro;
        
        this.fornecedorRegistro.getNovo().addActionListener(this);
        this.fornecedorRegistro.getGravar().addActionListener(this);
        this.fornecedorRegistro.getCancelar().addActionListener(this);
        this.fornecedorRegistro.getPesquisar().addActionListener(this);
        this.fornecedorRegistro.getSair().addActionListener(this);
        this.fornecedorRegistro.getPesquisarCep().addActionListener(this);
        this.fornecedorRegistro.getAdicionarCep().addActionListener(this);
        
        
        Utilities.active(true, this.fornecedorRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.fornecedorRegistro.getPainelDados());
               
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.fornecedorRegistro.getNovo()){
            Utilities.active(false, this.fornecedorRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.fornecedorRegistro.getPainelDados());
        }else if(e.getSource()==this.fornecedorRegistro.getGravar()){
            Utilities.active(true, this.fornecedorRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.fornecedorRegistro.getPainelDados());
        }else if(e.getSource()==this.fornecedorRegistro.getCancelar()){
            Utilities.active(true, this.fornecedorRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.fornecedorRegistro.getPainelDados());
        }else if(e.getSource()==this.fornecedorRegistro.getSair()){
            this.fornecedorRegistro.dispose();
        }else if(e.getSource()==this.fornecedorRegistro.getPesquisar()){
            FornecedorPesquisa fornecedorPesquisa=new FornecedorPesquisa();
            FornecedorPesquisaController fornecedorPesquisaController=new FornecedorPesquisaController(fornecedorPesquisa);
            fornecedorPesquisa.setVisible(true);
        }else if(e.getSource()==this.fornecedorRegistro.getAdicionarCep()){
            EnderecoRegistro enderecoRegistro = new EnderecoRegistro();
            EnderecoRegistroController enderecoRegistroController = new EnderecoRegistroController(enderecoRegistro);
            enderecoRegistro.setVisible(true);
        }else if (e.getSource()==this.fornecedorRegistro.getPesquisarCep()){
            EnderecoPesquisa enderecoPesquisa= new EnderecoPesquisa();
            EnderecoPesquisaController enderecoPesquisaController= new EnderecoPesquisaController(enderecoPesquisa);
            enderecoPesquisa.setVisible(true);
        }
    }
    
}
