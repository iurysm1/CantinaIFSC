
package service;

import java.util.List;
import model.DAO.ClienteDAO;
import model.bo.Cliente;

public class ClienteService {
    
    public static void  adicionar(Cliente objeto) {
        ClienteDAO objetoDAO = new ClienteDAO();
        objetoDAO.create(objeto);
    }

    public static List<Cliente> carregar() {
        ClienteDAO objetoDAO = new ClienteDAO();
        return objetoDAO.retrieve();
    }

    public static Cliente carregar(int parPK) {
        ClienteDAO objetoDAO = new ClienteDAO();
        return objetoDAO.retrieve(parPK);
    }

    public static List<Cliente> carregar(String parString, String parParametro) {
        ClienteDAO objetoDAO = new ClienteDAO();
        return objetoDAO.retrieve(parString, parParametro);
        }
    
    public static void atualizar(Cliente objeto) {
       ClienteDAO objetoDAO = new ClienteDAO();
        objetoDAO.update(objeto);
    }

    public static void remover(Cliente objeto) {
        ClienteDAO objetoDAO = new ClienteDAO();
        objetoDAO.delete(objeto);
    }
    
}
