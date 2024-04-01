
package service;

import java.util.List;
import model.DAO.ProdutoDAO;
import model.bo.Produto;

public class ProdutoService {
    public static void  adicionar(Produto objeto) {
        ProdutoDAO objetoDAO = new ProdutoDAO();
        objetoDAO.create(objeto);
    }

    public static List<Produto> carregar() {
        ProdutoDAO objetoDAO = new ProdutoDAO();
        return objetoDAO.retrieve();
    }

    public static Produto carregar(int parPK) {
        ProdutoDAO objetoDAO = new ProdutoDAO();
        return objetoDAO.retrieve(parPK);
    }

    public static List<Produto> carregarDescricao(String parString) {
        ProdutoDAO objetoDAO = new ProdutoDAO();
        return objetoDAO.retrieve(parString);
        }
    
    public static Produto carregarCodigoBarra(String parString) {
        ProdutoDAO objetoDAO = new ProdutoDAO();
        return objetoDAO.retrieveCodigoBarras(parString);
        }
    
    public static List<Produto> carregarPreco(Float parFloat) {
        ProdutoDAO objetoDAO = new ProdutoDAO();
        return objetoDAO.retrievePreco(parFloat);
        }
    
    public static void atualizar(Produto objeto) {
       ProdutoDAO objetoDAO = new ProdutoDAO();
        objetoDAO.update(objeto);
    }

    public static void remover(Produto objeto) {
        ProdutoDAO objetoDAO = new ProdutoDAO();
        objetoDAO.delete(objeto);
    }
}
