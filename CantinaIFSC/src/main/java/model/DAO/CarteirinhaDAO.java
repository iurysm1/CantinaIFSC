
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Bairro;
import model.bo.Carteirinha;
import model.bo.Cidade;
import model.bo.Cliente;
import model.bo.Endereco;
import service.EnderecoService;
import utilities.Utilities;

public class CarteirinhaDAO implements InterfaceDAO<Carteirinha>{
    
    private static CarteirinhaDAO instance;
    protected EntityManager entityManager;
    
    public static CarteirinhaDAO getInstance(){
        if(instance==null){
            instance= new CarteirinhaDAO();
        }
        
        return instance;
    }

    public CarteirinhaDAO() {
        entityManager=getEntityManager();
    }
    
    
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_Cantina");
        
        if(entityManager==null){
            entityManager=factory.createEntityManager();
        }
        return entityManager;
    }
    
    @Override
    public void create(Carteirinha objeto) {
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
    public List<Carteirinha> retrieve() {
        List<Carteirinha> listaObjetos;
        listaObjetos=entityManager.createQuery("Select c from Carteirinha c", Carteirinha.class).getResultList();
        return listaObjetos;
    }

    @Override
    public Carteirinha retrieve(int parPK) {
               return entityManager.find(Carteirinha.class, parPK);

    }

    @Override
    public List<Carteirinha> retrieve(String parString, String parParametro) {
        List<Carteirinha> listaObjetos;
        listaObjetos=entityManager.createQuery("Select c from Carteirinha c where c."+parParametro+" LIKE :parDescricao", Carteirinha.class).setParameter("parDescricao", "%"+parString+"%").getResultList();
        return listaObjetos;
    }

    @Override
    public void update(Carteirinha objeto) {
        try {
            Carteirinha carteirinha = entityManager.find(Carteirinha.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Carteirinha objeto) {
          try {
            Carteirinha carteirinha = entityManager.find(Carteirinha.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
