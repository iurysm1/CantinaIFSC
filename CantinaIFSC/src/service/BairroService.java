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

    public static Bairro carregar(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void atualizar(Bairro objeto) {
       BairroDAO bairroDAO = new BairroDAO();
       bairroDAO.update(objeto);
    }

    public static void remover(Bairro objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        
    
}
