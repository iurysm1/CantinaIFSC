
package service;

import model.DAO.CaixaDAO;

public class CaixaService {
    
    public static String retornarDataAtual(){
        CaixaDAO objetoDAO = new CaixaDAO();
        return objetoDAO.returnDateNow();
    }
}
