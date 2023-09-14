package service;

import java.util.List;
import model.DAO.BairroDAO;
import model.bo.Bairro;

public class BairroService implements InterfacecService<Bairro>{

    @Override
    public void adicionar(Bairro objeto) {
        BairroDAO bairroDAO = new BairroDAO();
        bairroDAO.create(objeto);
    }

    @Override
    public List<Bairro> carregar() {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve();
    }

    @Override
    public Bairro carregar(int parPK) {
        BairroDAO bairroDAO = new BairroDAO();
        return bairroDAO.retrieve(parPK);
    }

    @Override
    public Bairro carregar(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizar(Bairro objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(Bairro objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        
    
}
