
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Utilities;
import view.ClientePesquisa;
import view.ClienteRegistro;
import view.EnderecoPesquisa;
import view.EnderecoRegistro;


public class ClienteRegistroController implements ActionListener{

    ClienteRegistro clienteRegistro;

    public ClienteRegistroController(ClienteRegistro clienteRegistro) {
        
        this.clienteRegistro=clienteRegistro;
        
        this.clienteRegistro.getSair().addActionListener(this);
        this.clienteRegistro.getNovo().addActionListener(this);
        this.clienteRegistro.getGravar().addActionListener(this);
        this.clienteRegistro.getCancelar().addActionListener(this);
        this.clienteRegistro.getPesquisar().addActionListener(this);
        this.clienteRegistro.getNovoCep().addActionListener(this);
        this.clienteRegistro.getPesquisarCep().addActionListener(this);
        
        Utilities.active(true, this.clienteRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.clienteRegistro.getPainelDados());
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.clienteRegistro.getSair()){
            this.clienteRegistro.dispose();
        }else if(e.getSource()==this.clienteRegistro.getPesquisar()){
            ClientePesquisa clientePesquisa=new ClientePesquisa();
            ClientePesquisaController clientePesquisaController=new ClientePesquisaController(clientePesquisa);
            clientePesquisa.setVisible(true);
            
        }else if(e.getSource()==this.clienteRegistro.getNovo()){
            Utilities.active(false, this.clienteRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.clienteRegistro.getPainelDados());
            
        }else if(e.getSource()==this.clienteRegistro.getGravar()){
            Utilities.active(true, this.clienteRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.clienteRegistro.getPainelDados());
            
        }else if(e.getSource()==this.clienteRegistro.getCancelar()){
            Utilities.active(true, this.clienteRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.clienteRegistro.getPainelDados());
            
        }else if(e.getSource()==this.clienteRegistro.getNovoCep()){
            EnderecoRegistro enderecoRegistro = new EnderecoRegistro();
            EnderecoRegistroController enderecoRegistroController = new EnderecoRegistroController(enderecoRegistro);
            enderecoRegistro.setVisible(true);
            
        }else if (e.getSource()==this.clienteRegistro.getPesquisarCep()){
            EnderecoPesquisa enderecoPesquisa= new EnderecoPesquisa();
            EnderecoPesquisaController enderecoPesquisaController= new EnderecoPesquisaController(enderecoPesquisa);
            enderecoPesquisa.setVisible(true);
        }
        
    }
    
}
