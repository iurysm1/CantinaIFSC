package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Utilities;
import view.CidadePesquisa;
import view.CidadeRegistro;


public class CidadeRegistroController implements ActionListener{
    
    CidadeRegistro cidadeRegistro;

    public CidadeRegistroController(CidadeRegistro cidadeRegistro) {
        
        this.cidadeRegistro = cidadeRegistro;
        
        this.cidadeRegistro.getNovo().addActionListener(this);
        this.cidadeRegistro.getCancelar().addActionListener(this);
        this.cidadeRegistro.getGravar().addActionListener(this);
        this.cidadeRegistro.getSair().addActionListener(this);
        this.cidadeRegistro.getPesquisar().addActionListener(this);
        
        
        Utilities.active(true, this.cidadeRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.cidadeRegistro.getPainelDados());
    }

    

    


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.cidadeRegistro.getNovo()){
            Utilities.active(false, this.cidadeRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.cidadeRegistro.getPainelDados());
        }else if(e.getSource()==this.cidadeRegistro.getCancelar()){
            Utilities.active(true, this.cidadeRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.cidadeRegistro.getPainelDados());
        }else if (e.getSource()==this.cidadeRegistro.getGravar()){
            Utilities.active(true, this.cidadeRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.cidadeRegistro.getPainelDados());
        }else if (e.getSource()==this.cidadeRegistro.getSair()){
            this.cidadeRegistro.dispose();
        }else if (e.getSource()==this.cidadeRegistro.getPesquisar()){
            CidadePesquisa cidadePesquisa=new CidadePesquisa();
            CidadePesquisaController cidadePesquisaController = new CidadePesquisaController(cidadePesquisa);
            cidadePesquisa.setVisible(true);
        }
    }
    }