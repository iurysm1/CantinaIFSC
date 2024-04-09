/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.CarteirinhaDAO;
import model.bo.Carteirinha;

/**
 *
 * @author Mony
 */
public class CarteirinhaService {
    public static void  adicionar(Carteirinha objeto) {
        CarteirinhaDAO objetoDAO = new CarteirinhaDAO();
        objetoDAO.create(objeto);
    }

    public static List<Carteirinha> carregar() {
        CarteirinhaDAO objetoDAO = new CarteirinhaDAO();
        return objetoDAO.retrieve();
    }

    public static Carteirinha carregar(int parPK) {
       CarteirinhaDAO objetoDAO = new CarteirinhaDAO();
        return objetoDAO.retrieve(parPK);
    }

    public static List<Carteirinha> carregar(String parString, String parParametro) {
        CarteirinhaDAO objetoDAO = new CarteirinhaDAO();
        return objetoDAO.retrieve(parString, parParametro);
        }

    
    public static void atualizar(Carteirinha objeto) {
      CarteirinhaDAO objetoDAO = new CarteirinhaDAO();
        objetoDAO.update(objeto);
    }

    public static void remover(Carteirinha objeto) {
        CarteirinhaDAO objetoDAO = new CarteirinhaDAO();
        objetoDAO.delete(objeto);
    }
}
