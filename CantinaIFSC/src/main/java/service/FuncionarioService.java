
package service;

import java.util.List;
import model.DAO.FuncionarioDAO;
import model.bo.Funcionario;

public class FuncionarioService {
    
    public static void  adicionar(Funcionario objeto) {
        FuncionarioDAO objetoDAO = new FuncionarioDAO();
        objetoDAO.create(objeto);
    }

    public static List<Funcionario> carregar() {
        FuncionarioDAO objetoDAO = new FuncionarioDAO();
        return objetoDAO.retrieve();
    }

    public static Funcionario carregar(int parPK) {
        FuncionarioDAO objetoDAO = new FuncionarioDAO();
        return objetoDAO.retrieve(parPK);
    }

    public static List<Funcionario> carregar(String parString) {
        FuncionarioDAO objetoDAO = new FuncionarioDAO();
        return objetoDAO.retrieve(parString);
        }
    
    public static List<Funcionario> carregarCPF(String parString) {
        FuncionarioDAO objetoDAO = new FuncionarioDAO();
        return objetoDAO.retrieveCPF(parString);
        }
    
    public static void atualizar(Funcionario objeto) {
       FuncionarioDAO objetoDAO = new FuncionarioDAO();
        objetoDAO.update(objeto);
    }
    
    public static void atualizarSenha(String senha, String usuario, int id){
        FuncionarioDAO objetoDAO = new FuncionarioDAO();
        objetoDAO.UsuarioESenha(senha,usuario,id);
    }

    public static void remover(Funcionario objeto) {
        FuncionarioDAO objetoDAO = new FuncionarioDAO();
        objetoDAO.delete(objeto);
    }
    
}
