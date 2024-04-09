package service;

import java.util.List;
import model.DAO.BairroDAO;
import model.bo.Bairro;

public class BairroService{

    public static void  adicionar(Bairro objeto) {
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.create(objeto);
    }

    public static List<Bairro> carregar() {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve();
    }

    public static Bairro carregar(int parPK) {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve(parPK);
    }

    public static List<Bairro> carregar(String parString, String parParametro) {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve(parString, parParametro);
        }

    public static void atualizar(Bairro objeto) {
       BairroDAO bairroDAO = new BairroDAO();
       bairroDAO.update(objeto);
    }

    public static void remover(Bairro objeto) {
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.delete(objeto);
    }
    
        
    
}
