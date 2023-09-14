package controller;


import static model.DAO.Persiste.carteirinhas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.DAO.Persiste;
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
           if(tabela.getRowCount()==0){
            for (Carteirinha carteirinha : carteirinhas) {
                tabela.addRow(new Object[]{carteirinha.getId(), carteirinha.getCliente().getId(), carteirinha.getCliente().getNome()});
            }
           }
        }else if (e.getSource()==this.carteirinhaPesquisa.getCarregar()){
            CarteirinhaRegistroController.codigo=(int) this.carteirinhaPesquisa.getTabelaDados().getValueAt(this.carteirinhaPesquisa.getTabelaDados().getSelectedRow(), 0);
            this.carteirinhaPesquisa.dispose();
        }
    }
    
}
