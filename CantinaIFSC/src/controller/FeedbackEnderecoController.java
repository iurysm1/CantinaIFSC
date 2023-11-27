
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FeedbackENDERECO;
public class FeedbackEnderecoController implements ActionListener{
    
    FeedbackENDERECO feedBack;
    
    public static int codigoFB;

    public FeedbackEnderecoController(FeedbackENDERECO feedBack) {
        this.feedBack=feedBack;
        
        this.feedBack.getConcluir().addActionListener(this);
        
        
    }
    
     public void atualizacaoLabel(){
        switch (this.codigoFB) {         
            case 1:
                this.feedBack.setFeedBack("   O BAIRRO DIGITADO NÃO EXISTE!");
                break;
            case 2:
                this.feedBack.setFeedBack("   A CIDADE DIGITADA NÃO EXISTE!");
                break;
            case 3:
                this.feedBack.setFeedBack("  O CLIENTE DIGITADO NÃO EXISTE!");
                break;
            case 4:
                this.feedBack.setFeedBack("  ATENÇÃO, ALGUNS CAMPOS VAZIOS!");
            
                
            
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if(e.getSource()==this.feedBack.getConcluir()){
           
     
            
            this.feedBack.dispose();
        }
    }
    
}
