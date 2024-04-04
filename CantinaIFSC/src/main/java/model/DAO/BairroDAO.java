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

public class BairroDAO implements InterfaceDAO<Bairro> {

    private static BairroDAO instance;
    protected EntityManager entityManager;

    public static BairroDAO getInstance() {
        if (instance == null) {
            instance = new BairroDAO();
        }
        return instance;
    }

    public BairroDAO() {
        
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
    public void create(Bairro objeto) {
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
    public List<Bairro> retrieve() {
        
        List<Bairro> listaObjetos;
        
        listaObjetos= entityManager.createQuery("Select b from Bairro b",Bairro.class).getResultList();
        return listaObjetos;

    }

    @Override
    public Bairro retrieve(int parPK) {
        return entityManager.find(Bairro.class, parPK);
    }

    @Override
    public List<Bairro> retrieve(String parString, String parParametro) {
        
        List<Bairro> listaObjetos;
        listaObjetos= entityManager.createQuery("Select b from Bairro b where b." +parParametro+ "LIKE :parDescricao",Bairro.class).setParameter("parDescricao", "%"+parString+"%").getResultList();

                
        return listaObjetos;
    }

    @Override
    public void update(Bairro objeto) {
        try {
            Bairro bairro = entityManager.find(Bairro.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public void delete(Bairro objeto) {
        try {
            Bairro bairro = entityManager.find(Bairro.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
