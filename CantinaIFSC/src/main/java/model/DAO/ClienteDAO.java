
package model.DAO;

import model.bo.Cliente;
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
import model.bo.Bairro;
import model.bo.Cidade;
import utilities.Utilities;


public class ClienteDAO implements InterfaceDAO<Cliente>{

    private static ClienteDAO instance;
    protected EntityManager entityManager;
            
    public static ClienteDAO getInstance(){
        if(instance==null){
            instance=new ClienteDAO();
        }
        
        return instance;
    }

    public ClienteDAO() {
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
    public void create(Cliente objeto) {
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
    public List<Cliente> retrieve() {
        List<Cliente> listaObjetos;
        listaObjetos=entityManager.createQuery("Select c from Cliente c", Cliente.class).getResultList();
        return listaObjetos;
    }

    @Override
    public Cliente retrieve(int parPK) {
        return entityManager.find(Cliente.class, parPK);

    }

    @Override
    public List<Cliente> retrieve(String parString, String parParametro) {
        List<Cliente> listaObjetos;
        listaObjetos=entityManager.createQuery("Select c from Cliente c where c."+parParametro+" LIKE :parDescricao", Cliente.class).setParameter("parDescricao", "%"+parString+"%").getResultList();
        return listaObjetos;
    }

    @Override
    public void update(Cliente objeto) {
        try {
            Cliente cliente = entityManager.find(Cliente.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Cliente objeto) {
        try {
            Cliente cliente = entityManager.find(Cliente.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
