/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Feedback;
import view.FeedbackSENHA;

/**
 *
 * @author Mony
 */
public class FeedbackSenhaController implements ActionListener{
    
    FeedbackSENHA feedBack;
    
    public static int codigoFB;

    public FeedbackSenhaController(FeedbackSENHA feedBack) {
        this.feedBack=feedBack;
        
        this.feedBack.getConcluir().addActionListener(this);
        
        
    }
    
  
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if(e.getSource()==this.feedBack.getConcluir()){
           
     
            
            this.feedBack.dispose();
        }
    }
    
}
