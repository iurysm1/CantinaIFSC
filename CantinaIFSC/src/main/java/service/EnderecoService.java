
package service;

import java.util.List;
import model.DAO.EnderecoDAO;
import model.bo.Endereco;

public class EnderecoService{
    public static void  adicionar(Endereco objeto) {
        EnderecoDAO objetoDAO = new EnderecoDAO();
        objetoDAO.create(objeto);
    }

    public static List<Endereco> carregar() {
        EnderecoDAO objetoDAO = new EnderecoDAO();
        return objetoDAO.retrieve();
    }

    public static Endereco carregar(int parPK) {
        EnderecoDAO objetoDAO = new EnderecoDAO();
        return objetoDAO.retrieve(parPK);
    }

    public static List<Endereco> carregar(String parString, String parParametro) {
        EnderecoDAO objetoDAO = new EnderecoDAO();
        return objetoDAO.retrieve(parString, parParametro);
        }
    
    public static void atualizar(Endereco objeto) {
       EnderecoDAO objetoDAO = new EnderecoDAO();
        objetoDAO.update(objeto);
    }

    public static void remover(Endereco objeto) {
        EnderecoDAO objetoDAO = new EnderecoDAO();
        objetoDAO.delete(objeto);
    }
}
