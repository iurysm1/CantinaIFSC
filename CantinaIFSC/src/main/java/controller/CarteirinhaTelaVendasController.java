
package controller;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import model.bo.Carteirinha;
import view.CarteirinhaTelaVendas;
import view.FeedbackENDERECO;

public class CarteirinhaTelaVendasController implements ActionListener{
    
    Carteirinha carteirinha;
    
    CarteirinhaTelaVendas carteirinhaTelaVendas;
    public CarteirinhaTelaVendasController(CarteirinhaTelaVendas carteirinhaTelaVendas) {
        this.carteirinhaTelaVendas=carteirinhaTelaVendas;
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(atalhos);
        this.carteirinhaTelaVendas.getPesquisar().addActionListener(this);
        this.carteirinhaTelaVendas.getComputarVenda().addActionListener(this);

    }
    
    private KeyEventDispatcher atalhos = new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                         pesquisarCarteirinha();                        
                        break;
                     case KeyEvent.VK_C:
                        cadastroCarteirinha();
                        
                        break;
                    default:
                        break;
                }
                

            }
            return false;
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.carteirinhaTelaVendas.getPesquisar()){
            
            pesquisarCarteirinha();
    }else if(e.getSource()==this.carteirinhaTelaVendas.getComputarVenda()){
        cadastroCarteirinha();
    }
}
    

    public void pesquisarCarteirinha(){
        this.carteirinha =  service.CarteirinhaService.carregar(this.carteirinhaTelaVendas.getCodigoBarras().getText(), "codigobarra").get(0);
        if(carteirinha.getCodigobarra()!=null){
            this.carteirinhaTelaVendas.getNomeCliente().setText(carteirinha.getCliente().getNome());
            this.carteirinhaTelaVendas.getIdCliente().setText(carteirinha.getCliente().getId()+"");
            this.carteirinhaTelaVendas.getDataCancelamento().setText(utilities.Utilities.dateToString(carteirinha.getDatacancelamento()));

            this.carteirinhaTelaVendas.getComputarVenda().setEnabled(true);
            this.carteirinhaTelaVendas.getLabelEND().setEnabled(true);
        }else{
            utilities.Utilities.feedbackErros(5);
        }
    }
    
    public void cadastroCarteirinha(){
        System.out.println(this.carteirinha.getId());
        VendaController.idCarteirinha=this.carteirinha.getId();
        this.carteirinhaTelaVendas.dispose();
    }
}