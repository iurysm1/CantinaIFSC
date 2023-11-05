package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import model.DAO.Persiste;
import model.bo.Bairro;
import model.bo.Cidade;
import service.BairroService;
import service.CidadeService;
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
                    cidade=CidadeService.carregar(codigo);
                    Utilities.active(false, cidadeRegistro.getPainelBotoes());
                    Utilities.limpaComponentes(true, cidadeRegistro.getPainelDados());
                    
                    cidadeRegistro.getId().setText(cidade.getId()+"");
                    cidadeRegistro.getNomeCidade().setText(cidade.getDescricao());
                    cidadeRegistro.getUf().setText(cidade.getUf());
                    cidadeRegistro.getId().setEnabled(false);
                    
                    if(cidade.getStatus().equalsIgnoreCase("A")){
                        cidadeRegistro.getStatus().setSelectedIndex(0);
                    }else{
                        cidadeRegistro.getStatus().setSelectedIndex(1);
                    }
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
            
            cidade.setUf(this.cidadeRegistro.getUf().getText());
            cidade.setDescricao(this.cidadeRegistro.getNomeCidade().getText());
            
            if(this.cidadeRegistro.getStatus().getSelectedIndex()==0){
                cidade.setStatus("A");
            }else{
                cidade.setStatus("D");
            }
            
            Feedback feedback=new Feedback();
            FeedbackController feedbackController= new FeedbackController(feedback);
            
            if(this.cidadeRegistro.getId().getText().equalsIgnoreCase("")){
                CidadeService.adicionar(cidade);
                feedbackController.cadastroClasse(2);
            }else{
                cidade.setId(codigo);
                CidadeService.atualizar(cidade);
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