
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Utilities;
import view.BairroPesquisa;
import view.BairroRegistro;
import view.CidadePesquisa;
import view.CidadeRegistro;
import view.EnderecoPesquisa;
import view.EnderecoRegistro;

public class EnderecoRegistroController implements ActionListener{
    
    EnderecoRegistro enderecoRegistro;
    

    public EnderecoRegistroController(EnderecoRegistro enderecoRegistro) {
        
        this.enderecoRegistro=enderecoRegistro;
        
        this.enderecoRegistro.getNovo().addActionListener(this);
        this.enderecoRegistro.getGravar().addActionListener(this);
        this.enderecoRegistro.getCancelar().addActionListener(this);
        this.enderecoRegistro.getPesquisar().addActionListener(this);
        this.enderecoRegistro.getSair().addActionListener(this);
        this.enderecoRegistro.getPesquisaBairro().addActionListener(this);
        this.enderecoRegistro.getPesquisaCidade().addActionListener(this);
        this.enderecoRegistro.getNovoBairro().addActionListener(this);
        this.enderecoRegistro.getNovoCidade().addActionListener(this);
        
        Utilities.active(true, this.enderecoRegistro.getPainelBotoes());
        Utilities.limpaComponentes(false, this.enderecoRegistro.getPainelDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==this.enderecoRegistro.getNovo()){
           Utilities.active(false, this.enderecoRegistro.getPainelBotoes());
           Utilities.limpaComponentes(true, this.enderecoRegistro.getPainelDados());
       }else if(e.getSource()==this.enderecoRegistro.getGravar()){
           Utilities.active(true, this.enderecoRegistro.getPainelBotoes());
           Utilities.limpaComponentes(false, this.enderecoRegistro.getPainelDados());
       }else if(e.getSource()==this.enderecoRegistro.getCancelar()){
           Utilities.active(true, this.enderecoRegistro.getPainelBotoes());
           Utilities.limpaComponentes(false, this.enderecoRegistro.getPainelDados());
       }else if(e.getSource()==this.enderecoRegistro.getPesquisar()){
           EnderecoPesquisa enderecoPesquisa=new EnderecoPesquisa();
           EnderecoPesquisaController enderecoPesquisaController=new EnderecoPesquisaController(enderecoPesquisa);
           enderecoPesquisa.setVisible(true);
       }else if(e.getSource()==this.enderecoRegistro.getSair()){
           this.enderecoRegistro.dispose();
       }else if(e.getSource()==this.enderecoRegistro.getNovoBairro()){
           BairroRegistro bairroRegistro = new BairroRegistro();
           BairroRegistroController bairroRegistroController = new BairroRegistroController(bairroRegistro);
           bairroRegistro.setVisible(true);
       }else if(e.getSource()==this.enderecoRegistro.getPesquisaBairro()){
           BairroPesquisa bairroPesquisa = new BairroPesquisa();
           BairroPesquisaController bairroPesquisaController= new BairroPesquisaController(bairroPesquisa);
           bairroPesquisa.setVisible(true);
       }else if (e.getSource()==this.enderecoRegistro.getNovoCidade()){
           CidadeRegistro cidadeRegistro = new CidadeRegistro();
           CidadeRegistroController cidadeRegistroController = new CidadeRegistroController(cidadeRegistro);
           cidadeRegistro.setVisible(true);
       }else if (e.getSource()==this.enderecoRegistro.getPesquisaCidade()){
           CidadePesquisa cidadePesquisa = new CidadePesquisa();
           CidadePesquisaController cidadePesquisaController = new CidadePesquisaController(cidadePesquisa);
           cidadePesquisa.setVisible(true);
       }
    }
    
}
