
package model.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Caixa;
import model.bo.Venda;

public class CaixaDAO implements InterfaceDAO<Caixa>{

    private static CaixaDAO instance;
    protected EntityManager entityManager;
            
    public static CaixaDAO getInstance(){
        if(instance==null){
            instance=new CaixaDAO();
        }
        
        return instance;
    }

    public CaixaDAO() {
        entityManager=getEntityManager();
    }
    
    
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("pu_Cantina");
        
        if(entityManager == null){
            entityManager=factory.createEntityManager();
        }
        return entityManager;
    }
    
    @Override
    public void create(Caixa objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Caixa> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Caixa retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Caixa> retrieve(String parString, String parParametro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Caixa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Caixa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    
    
}
