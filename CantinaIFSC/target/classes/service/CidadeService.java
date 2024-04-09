
package service;

import java.util.List;
import model.DAO.CidadeDAO;
import model.bo.Cidade;

public class CidadeService {
    public static void  adicionar(Cidade objeto) {
        CidadeDAO objetoDAO = new CidadeDAO();
        objetoDAO.create(objeto);
    }

    public static List<Cidade> carregar() {
        CidadeDAO objetoDAO = new CidadeDAO();
        return objetoDAO.retrieve();
    }

    public static Cidade carregar(int parPK) {
        CidadeDAO objetoDAO = new CidadeDAO();
        return objetoDAO.retrieve(parPK);
    }

    public static List<Cidade> carregar(String parString, String parParametro) {
        CidadeDAO objetoDAO = new CidadeDAO();
        return objetoDAO.retrieve(parString, parParametro);
    }
    
    public static void atualizar(Cidade objeto) {
       CidadeDAO objetoDAO = new CidadeDAO();
        objetoDAO.update(objeto);
    }

    public static void remover(Cidade objeto) {
        CidadeDAO objetoDAO = new CidadeDAO();
        objetoDAO.delete(objeto);
    }
}
