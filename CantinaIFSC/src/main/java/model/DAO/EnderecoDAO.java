
package model.DAO;

import java.util.List;
import model.bo.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Cidade;
import model.bo.Bairro;

public class EnderecoDAO implements InterfaceDAO<Endereco>{
    
    
    private static EnderecoDAO instance;
    protected EntityManager entityManager;
            
    public static EnderecoDAO getInstance(){
        if(instance==null){
            instance=new EnderecoDAO();
        }
        
        return instance;
    }

    public EnderecoDAO() {
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
    public void create(Endereco objeto) {
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
    public List<Endereco> retrieve() {
        
        List<Endereco> listaObjetos;
        listaObjetos=entityManager.createQuery("Select e from Endereco e", Endereco.class).getResultList();
        return listaObjetos;
        
    }

    @Override
    public Endereco retrieve(int parPK) {
       return entityManager.find(Endereco.class, parPK);
    }

    
    @Override
    public List<Endereco> retrieve(String parString, String parParametro) {
         List<Endereco> listaObjetos;
        listaObjetos=entityManager.createQuery("Select e from Endereco e where e."+parParametro+" LIKE :parDescricao", Endereco.class).setParameter("parDescricao", "%"+parString+"%").getResultList();
        return listaObjetos;
    }



    @Override
    public void update(Endereco objeto) {
        try {
            Endereco endereco = entityManager.find(Endereco.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Endereco objeto) {
        try {
            Endereco endereco = entityManager.find(Endereco.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
