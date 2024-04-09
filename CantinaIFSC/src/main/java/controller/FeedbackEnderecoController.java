
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
                break;
            case 5:
                this.feedBack.setFeedBack("A CARTEIRINHA DIGITADA NÃO EXISTE!");
            case 6:
                this.feedBack.setFeedBack("NENHUM PRODUTO ADICIONADO A LISTA!");
                break;
            case 7:
                this.feedBack.setFeedBack("  O CÓDIGO DE BARRAS ESTÁ VAZIO!");
                break;
            case 8:
                this.feedBack.setFeedBack("  O PRODUTO DIGITADO NÃO EXISTE!");
                break;
            case 9:
                this.feedBack.setFeedBack("  ATENÇÃO, O CAIXA ESTA FECHADO!");
                break;
            case 10:
                this.feedBack.setFeedBack("METODO DE PAGAMENTO NÃO SELECIONADO");
                break;
            case 11:
                this.feedBack.setFeedBack("ATENÇÃO, O FUNCIONÁRIO NÃO EXISTE!");
                break;
            case 12:
                this.feedBack.setFeedBack("ATENÇÃO, ALGUNS CAMPOS INCORRETOS!");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if(e.getSource()==this.feedBack.getConcluir()){
           
     
            
            this.feedBack.dispose();
        }
    }
    
}
