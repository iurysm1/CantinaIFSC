
package service;

import java.util.List;
import model.DAO.ItemVendaDAO;
import model.bo.ItemVenda;

public class ItemVendaService {
    
    public static void adicionar(ItemVenda objeto){
        ItemVendaDAO objetoDAO = new ItemVendaDAO();
        objetoDAO.create(objeto);
    }
    
    public static List<ItemVenda> totalItemVenda(int parPK){
        ItemVendaDAO objetoDAO = new ItemVendaDAO();
        return objetoDAO.totalItemVenda(parPK);
    }
}
