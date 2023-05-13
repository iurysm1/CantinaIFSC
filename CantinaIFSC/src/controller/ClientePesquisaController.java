/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ClientePesquisa;

/**
 *
 * @author Mony
 */
public class ClientePesquisaController implements ActionListener{
    ClientePesquisa clientePesquisa;
    public ClientePesquisaController(ClientePesquisa clientePesquisa) {
        this.clientePesquisa=clientePesquisa;
        
        this.clientePesquisa.getSair().addActionListener(this);
        this.clientePesquisa.getCarregar().addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.clientePesquisa.getSair()){
            this.clientePesquisa.dispose();
        }
    }
    
}
