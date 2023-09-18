package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import model.DAO.Persiste;
import model.bo.Bairro;
import model.bo.Cidade;
import utilities.Utilities;
import view.CidadePesquisa;
import view.CidadeRegistro;
import view.Feedback;


public class CidadeRegistroController implements ActionListener{
    
    CidadeRegistro cidadeRegistro;
    public static int codigo;
    
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
    
    WindowListener disposeListener = new WindowAdapter() {
            public void windowClosed(WindowEvent e){
                if (codigo!=0){
                    Cidade cidade = new Cidade();
                    cidade=Persiste.cidades.get(codigo-1);
                    Utilities.active(false, cidadeRegistro.getPainelBotoes());
                    Utilities.limpaComponentes(true, cidadeRegistro.getPainelDados());
                    
                    cidadeRegistro.getId().setText(cidade.getId()+"");
                    cidadeRegistro.getNomeCidade().setText(cidade.getDescricao());
                    cidadeRegistro.getUf().setText(cidade.getUf());
                    cidadeRegistro.getId().setEnabled(false);
                }
            }
    };
    

    


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.cidadeRegistro.getNovo()){
            Utilities.active(false, this.cidadeRegistro.getPainelBotoes());
            Utilities.limpaComponentes(true, this.cidadeRegistro.getPainelDados());
            this.cidadeRegistro.getId().setEnabled(false);
        }else if(e.getSource()==this.cidadeRegistro.getCancelar()){
            Utilities.active(true, this.cidadeRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.cidadeRegistro.getPainelDados());
        }else if (e.getSource()==this.cidadeRegistro.getGravar()){
            Cidade cidade=new Cidade();
            
            cidade.setId(Persiste.cidades.size()+1);
            cidade.setUf(this.cidadeRegistro.getUf().getText());
            cidade.setDescricao(this.cidadeRegistro.getNomeCidade().getText());
           Feedback feedback=new Feedback();
            FeedbackController feedbackController= new FeedbackController(feedback);
            
            if(this.cidadeRegistro.getId().getText().equalsIgnoreCase("")){
                Persiste.cidades.add(cidade);
                feedbackController.cadastroClasse(2);
            }else{
                int index=Integer.parseInt(this.cidadeRegistro.getId().getText())-1;
                Persiste.cidades.get(index).setDescricao(this.cidadeRegistro.getNomeCidade().getText());
                Persiste.cidades.get(index).setUf(this.cidadeRegistro.getUf().getText());
                
                feedbackController.atualizacaoClasse(2);
            }
            
            
            
            feedback.setVisible(true);
            
            Utilities.active(true, this.cidadeRegistro.getPainelBotoes());
            Utilities.limpaComponentes(false, this.cidadeRegistro.getPainelDados());
        }else if (e.getSource()==this.cidadeRegistro.getSair()){
            this.cidadeRegistro.dispose();
        }else if (e.getSource()==this.cidadeRegistro.getPesquisar()){
            CidadePesquisa cidadePesquisa=new CidadePesquisa();
            CidadePesquisaController cidadePesquisaController = new CidadePesquisaController(cidadePesquisa);
            cidadePesquisa.addWindowListener(disposeListener);
            cidadePesquisa.setVisible(true);
        }
    }
    }