/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Feedback;

/**
 *
 * @author Mony
 */
public class FeedbackController implements ActionListener{
    
    Feedback feedBack;
    

    public FeedbackController(Feedback feedBack) {
        this.feedBack = feedBack;
        
        this.feedBack.getConcluir().addActionListener(this);
        
        
    }
    
    public void cadastroClasse(int codigoFB){
        
        switch (codigoFB) {
            case 1:
                this.feedBack.setFeedBack("SEU BAIRRO FOI CADASTRADO COM SUCESSO!");           
                break;
            case 2:
                this.feedBack.setFeedBack("SUA CIDADE FOI CADASTRADA COM SUCESSO!");
                break;
            case 3:
                this.feedBack.setFeedBack("SEU ENDEREÇO FOI CADASTRADO COM SUCESSO!");
                break;
            case 4:
                this.feedBack.setFeedBack("SEU PRODUTO FOI CADASTRADO COM SUCESSO!");
                break;
            case 5: 
                this.feedBack.setFeedBack("SUA CARTEIRINHA FOI CADASTRADA COM SUCESSO!");
                break;
            case 6:
                this.feedBack.setFeedBack("SEU CLIENTE FOI CADASTRADO COM SUCESSO!");
                break;
            case 7:
                this.feedBack.setFeedBack("SEU FUNCIONÁRIO FOI CADASTRADO COM SUCESSO!");
                break;
            case 8:
                this.feedBack.setFeedBack("SEU FORNECEDOR FOI CADASTRADO COM SUCESSO!");
        }
    }

    public void atualizacaoClasse(int codigoFB){
        switch (codigoFB) {
            case 1:
                this.feedBack.setFeedBack("SEU BAIRRO FOI ATUALIZADO COM SUCESSO!");           
                break;
            case 2:
                this.feedBack.setFeedBack("SUA CIDADE FOI ATUALIZADA COM SUCESSO!");
                break;
            case 3:
                this.feedBack.setFeedBack("SEU ENDEREÇO FOI ATUALIZADO COM SUCESSO!");
                break;
            case 4:
                this.feedBack.setFeedBack("SEU PRODUTO FOI ATUALIZADO COM SUCESSO!");
                break;
            case 5: 
                this.feedBack.setFeedBack("SUA CARTEIRINHA FOI ATUALIZADA COM SUCESSO!");
                break;
            case 6:
                this.feedBack.setFeedBack("SEU CLIENTE FOI ATUALIZADO COM SUCESSO!");
                break;
            case 7:
                this.feedBack.setFeedBack("SEU FUNCIONÁRIO FOI ATUALIZADO COM SUCESSO!");
                break;
            case 8:
                this.feedBack.setFeedBack("SEU FORNECEDOR FOI ATUALIZADO COM SUCESSO!");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if(e.getSource()==this.feedBack.getConcluir()){
           
            
            
            this.feedBack.dispose();
        }
    }
    
}
