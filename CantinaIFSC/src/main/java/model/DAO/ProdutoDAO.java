
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Produto;
import utilities.Utilities;

public class ProdutoDAO implements InterfaceDAO<Produto>{

    private static ProdutoDAO instance;
    protected EntityManager entityManager;
            
    public static ProdutoDAO getInstance(){
        if(instance==null){
            instance=new ProdutoDAO();
        }
        
        return instance;
    }

    public ProdutoDAO() {
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
    public void create(Produto objeto) {
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
    public List<Produto> retrieve() {
        
        List<Produto> listaObjetos;
        listaObjetos=entityManager.createQuery("Select p from Produto p", Produto.class).getResultList();
        return listaObjetos;
        
    }

    @Override
    public Produto retrieve(int parPK) {
       return entityManager.find(Produto.class, parPK);
    }

    
    @Override
    public List<Produto> retrieve(String parString, String parParametro) {
        List<Produto> listaObjetos;
        listaObjetos=entityManager.createQuery("Select p from Produto p where p."+parParametro+" LIKE :parDescricao", Produto.class).setParameter("parDescricao", "%"+parString+"%").getResultList();
        return listaObjetos;
    }



    @Override
    public void update(Produto objeto) {
        try {
            Produto produto = entityManager.find(Produto.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Produto objeto) {
        try {
            Produto produto = entityManager.find(Produto.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
