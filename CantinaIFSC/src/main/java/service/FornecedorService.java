
package service;

import java.util.List;
import model.DAO.FornecedorDAO;
import model.bo.Fornecedor;

public class FornecedorService {
    public static void  adicionar(Fornecedor objeto) {
        FornecedorDAO objetoDAO = new FornecedorDAO();
        objetoDAO.create(objeto);
    }

    public static List<Fornecedor> carregar() {
        FornecedorDAO objetoDAO = new FornecedorDAO();
        return objetoDAO.retrieve();
    }

    public static Fornecedor carregar(int parPK) {
        FornecedorDAO objetoDAO = new FornecedorDAO();
        return objetoDAO.retrieve(parPK);
    }

    public static List<Fornecedor> carregar(String parString) {
        FornecedorDAO objetoDAO = new FornecedorDAO();
        return objetoDAO.retrieve(parString);
        }
    
    public static List<Fornecedor> carregarCNPJ(String parString) {
        FornecedorDAO objetoDAO = new FornecedorDAO();
        return objetoDAO.retrieveCNPJ(parString);
        }
    
    public static void atualizar(Fornecedor objeto) {
       FornecedorDAO objetoDAO = new FornecedorDAO();
        objetoDAO.update(objeto);
    }

    public static void remover(Fornecedor objeto) {
        FornecedorDAO objetoDAO = new FornecedorDAO();
        objetoDAO.delete(objeto);
    }
}
