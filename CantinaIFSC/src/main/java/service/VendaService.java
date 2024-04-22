
package service;

import java.sql.Timestamp;
import java.util.List;
import model.DAO.VendaDAO;
import model.bo.Venda;

public class VendaService {
    public static void adicionar(Venda objeto){
        VendaDAO objetoDAO = new VendaDAO();
        objetoDAO.create(objeto);
    }
    
     public static int createReturnID(Venda objeto){
        VendaDAO objetoDAO = new VendaDAO();
        return objetoDAO.createReturnID(objeto);
    }
     
     public static Venda carregar(int parPK){
        VendaDAO objetoDAO = new VendaDAO();
        return objetoDAO.retrieve(parPK);
    }
     
     public static List<Venda> VendasDateTime(Timestamp dataAbertura, Timestamp dataFechamento) {
        VendaDAO objetoDAO = new VendaDAO();
        return objetoDAO.retornarVendas(dataAbertura, dataFechamento);
    }
     
     
    
    
}
