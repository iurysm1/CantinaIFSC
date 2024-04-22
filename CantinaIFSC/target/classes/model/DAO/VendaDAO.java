
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Funcionario;
import model.bo.Venda;

public class VendaDAO implements InterfaceDAO<Venda>{
    

    private static VendaDAO instance;
    protected EntityManager entityManager;
            
    public static VendaDAO getInstance(){
        if(instance==null){
            instance=new VendaDAO();
        }
        
        return instance;
    }

    public VendaDAO() {
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
    public void create(Venda objeto) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
            
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
    
    public int createReturnID (Venda objeto){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
            
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            return objeto.getId();
        }
    }
    

    @Override
    public List<Venda> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venda retrieve(int parPK) {
        return entityManager.find(Venda.class, parPK);
    }

    @Override
    public List<Venda> retrieve(String parString, String parParametro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Venda> retornarVendas(Timestamp dataAbertura, Timestamp dataFechamento){
        List<Venda> listaObjetos;
        listaObjetos=entityManager.createQuery("Select v from Venda v where v.datahoravenda BETWEEN :dataAbertura AND :dataFechamento", Venda.class).setParameter("dataAbertura", dataAbertura).setParameter("dataFechamento", dataFechamento).getResultList();
        return listaObjetos;
    }
    
}
