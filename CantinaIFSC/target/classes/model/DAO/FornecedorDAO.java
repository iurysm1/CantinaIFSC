
package model.DAO;

import java.util.List;
import model.bo.Fornecedor;

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

public class FornecedorDAO implements InterfaceDAO<Fornecedor>{

    private static FornecedorDAO instance;
    protected EntityManager entityManager;
            
    public static FornecedorDAO getInstance(){
        if(instance==null){
            instance=new FornecedorDAO();
        }
        
        return instance;
    }

    public FornecedorDAO() {
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
    public void create(Fornecedor objeto) {
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
    public List<Fornecedor> retrieve() {
        
        List<Fornecedor> listaObjetos;
        listaObjetos=entityManager.createQuery("Select f from Fornecedor f", Fornecedor.class).getResultList();
        return listaObjetos;
        
    }

    @Override
    public Fornecedor retrieve(int parPK) {
       return entityManager.find(Fornecedor.class, parPK);
    }

    
    @Override
    public List<Fornecedor> retrieve(String parString, String parParametro) {
        List<Fornecedor> listaObjetos;
        listaObjetos=entityManager.createQuery("Select f from Fornecedor f where f."+parParametro+" LIKE :parDescricao", Fornecedor.class).setParameter("parDescricao", "%"+parString+"%").getResultList();
        return listaObjetos;
    }



    @Override
    public void update(Fornecedor objeto) {
        try {
            Fornecedor fornecedor = entityManager.find(Fornecedor.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Fornecedor objeto) {
        try {
            Fornecedor fornecedor = entityManager.find(Fornecedor.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
