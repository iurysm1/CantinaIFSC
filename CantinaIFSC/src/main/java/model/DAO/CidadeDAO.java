
package model.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Bairro;
import model.bo.Cidade;

public class CidadeDAO implements InterfaceDAO<Cidade>{
    
      private static CidadeDAO instance;
    protected EntityManager entityManager;
            
    public static CidadeDAO getInstance(){
        if(instance==null){
            instance=new CidadeDAO();
        }
        
        return instance;
    }

    public CidadeDAO() {
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
    public void create(Cidade objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Cidade> retrieve() {
        
        List<Cidade> listaObjetos;
        listaObjetos=entityManager.createQuery("Select c from Cidade c", Cidade.class).getResultList();
        return listaObjetos;
        
    }

    @Override
    public Cidade retrieve(int parPK) {
               return entityManager.find(Cidade.class, parPK);

    }

    @Override
    public List<Cidade> retrieve(String parString, String parParametro) {
        List<Cidade> listaObjetos;
        listaObjetos=entityManager.createQuery("Select c from Cidade c where c."+parParametro+" LIKE :parDescricao", Cidade.class).setParameter("parDescricao", "%"+parString+"%").getResultList();
        return listaObjetos;
    }

    @Override
    public void update(Cidade objeto) {
        try {
            Cidade cidade = entityManager.find(Cidade.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        
    }

    @Override
    public void delete(Cidade objeto) {
        try {
            Cidade cidade = entityManager.find(Cidade.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
