
package service;

import model.DAO.CaixaDAO;
import model.bo.Caixa;

public class CaixaService {
    
    public static  void adicionar(Caixa objeto){
        CaixaDAO objetoDAO = new CaixaDAO();
        objetoDAO.create(objeto);
    }

}
