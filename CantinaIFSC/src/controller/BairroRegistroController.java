package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Utilities;
import view.BairroPesquisa;
import view.BairroRegistro;


public class BairroRegistroController implements ActionListener{
    
    BairroRegistro bairroRegistro;

    public BairroRegistroController(BairroRegistro bairroRegistro) {
        
        
        this.bairroRegistro=bairroRegistro;
        
        this.bairroRegistro.getNovo().addActionListener(this);
        this.bairroRegistro.getCancelar().addActionListener(this);
        this.bairroRegistro.getGravar().addActionListener(this);
        this.bairroRegistro.getPesquisar().addActionListener(this);
        this.bairroRegistro.getSair().addActionListener(this);
        
       
        Utilities.active(true, this.bairroRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.bairroRegistro.getPainelDados());
    }

    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.bairroRegistro.getNovo()){
            Utilities.active(false, this.bairroRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.bairroRegistro.getPainelDados());
        }else if(e.getSource()==this.bairroRegistro.getCancelar()){
            Utilities.active(true, this.bairroRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.bairroRegistro.getPainelDados());
        }else if(e.getSource()==this.bairroRegistro.getGravar()){
            Utilities.active(true, this.bairroRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.bairroRegistro.getPainelDados());
        }else if(e.getSource()==this.bairroRegistro.getPesquisar()){
            BairroPesquisa bairroPesqusia = new BairroPesquisa();
            BairroPesquisaController bairroPesquisaController = new BairroPesquisaController(bairroPesqusia);
            bairroPesqusia.setVisible(true);
        }else if(e.getSource()==this.bairroRegistro.getSair()){
            this.bairroRegistro.dispose();
        }
           
    }
}