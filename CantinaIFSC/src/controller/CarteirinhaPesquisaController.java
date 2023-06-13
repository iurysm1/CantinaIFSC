package controller;

import DAO.Persiste;
import static DAO.Persiste.carteirinhas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Carteirinha;
import view.CarteirinhaPesquisa;

public class CarteirinhaPesquisaController implements ActionListener{

    CarteirinhaPesquisa carteirinhaPesquisa;

    public CarteirinhaPesquisaController(CarteirinhaPesquisa carteirinhaPesquisa) {
        this.carteirinhaPesquisa = carteirinhaPesquisa;
        
        this.carteirinhaPesquisa.getSair().addActionListener(this);
        this.carteirinhaPesquisa.getCarregar().addActionListener(this);
        this.carteirinhaPesquisa.getPesquisar().addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==this.carteirinhaPesquisa.getSair()){
            this.carteirinhaPesquisa.dispose();
        }else if(e.getSource()==this.carteirinhaPesquisa.getPesquisar()){
            Persiste.getInstance();
            
            DefaultTableModel tabela = (DefaultTableModel) this.carteirinhaPesquisa.getTabelaDados().getModel();
            for (Carteirinha carteirinha : carteirinhas) {
                tabela.addRow(new Object[]{carteirinha.getId(), carteirinha.getIdCliente(), carteirinha.getNomeCliente()});
            }
        }
    }
    
}
