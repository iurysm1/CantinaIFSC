package controller;


import static model.DAO.Persiste.carteirinhas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DAO.Persiste;
import model.bo.Carteirinha;
import service.CarteirinhaService;
import view.CarteirinhaPesquisa;

public class CarteirinhaPesquisaController implements ActionListener{

    CarteirinhaPesquisa carteirinhaPesquisa;

    public CarteirinhaPesquisaController(CarteirinhaPesquisa carteirinhaPesquisa) {
        this.carteirinhaPesquisa = carteirinhaPesquisa;
        
        this.carteirinhaPesquisa.getSair().addActionListener(this);
        this.carteirinhaPesquisa.getCarregar().addActionListener(this);
        this.carteirinhaPesquisa.getPesquisar().addActionListener(this);
        
        DefaultTableModel tabela = (DefaultTableModel) this.carteirinhaPesquisa.getTabelaDados().getModel();
            
        
        for (Carteirinha objetoAtual : CarteirinhaService.carregar()) {
                
                tabela.addRow(new Object[]{objetoAtual.getId(),objetoAtual.getCliente().getId(),objetoAtual.getCliente().getNome()});
            }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==this.carteirinhaPesquisa.getSair()){
            this.carteirinhaPesquisa.dispose();
        }else if(e.getSource()==this.carteirinhaPesquisa.getPesquisar()){
            
            DefaultTableModel tabela = (DefaultTableModel) this.carteirinhaPesquisa.getTabelaDados().getModel();
            tabela.setRowCount(0);
            if(this.carteirinhaPesquisa.getPesquisa().getText().equals("")){
                for (Carteirinha carteirinha : CarteirinhaService.carregar()) {
                tabela.addRow(new Object[]{carteirinha.getId(), carteirinha.getCliente().getId(), carteirinha.getCliente().getNome()});
            }
            }else{
                String filtro= this.carteirinhaPesquisa.getPesquisa().getText();
                
                switch (this.carteirinhaPesquisa.getFiltro1().getSelectedIndex()) {
                    case 0:
                        Carteirinha objetoAtual = CarteirinhaService.carregar(Integer.parseInt(filtro));
                        tabela.addRow(new Object[]{objetoAtual.getId(),objetoAtual.getCliente().getId(),objetoAtual.getCliente().getNome()});
                        break;
                    
                    case 1:
                        Carteirinha objetoAtual2 = CarteirinhaService.carregarIdCliente(Integer.parseInt(filtro));
                        tabela.addRow(new Object[]{objetoAtual2.getId(),objetoAtual2.getCliente().getId(),objetoAtual2.getCliente().getNome()});
                        break;
                        
                    case 2:
                        List<Carteirinha>listaObjetos = CarteirinhaService.carregar(filtro);

                        for (Carteirinha listaObjetoAtual : listaObjetos) {
                            tabela.addRow(new Object[]{listaObjetoAtual.getId(), listaObjetoAtual.getCliente().getId(), listaObjetoAtual.getCliente().getNome()});
                        } 
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            
           
           
           
        }else if (e.getSource()==this.carteirinhaPesquisa.getCarregar()){
            CarteirinhaRegistroController.codigo=(int) this.carteirinhaPesquisa.getTabelaDados().getValueAt(this.carteirinhaPesquisa.getTabelaDados().getSelectedRow(), 0);
            this.carteirinhaPesquisa.dispose();
        }
    }
    
}
