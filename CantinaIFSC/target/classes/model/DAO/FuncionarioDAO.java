
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
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Funcionario;
import utilities.Utilities;

public class FuncionarioDAO implements InterfaceDAO<Funcionario>{
    
    
    private static FuncionarioDAO instance;
    protected EntityManager entityManager;
            
    public static FuncionarioDAO getInstance(){
        if(instance==null){
            instance=new FuncionarioDAO();
        }
        
        return instance;
    }

    public FuncionarioDAO() {
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
    public void create(Funcionario objeto) {
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
    public List<Funcionario> retrieve() {
        List<Funcionario> listaObjetos;
        listaObjetos=entityManager.createQuery("Select f from Funcionario f", Funcionario.class).getResultList();
        return listaObjetos;
    }

    @Override
    public Funcionario retrieve(int parPK) {
        return entityManager.find(Funcionario.class, parPK);
    }

    @Override
    public List<Funcionario> retrieve(String parString, String parParametro) {
        
        List<Funcionario> listaObjetos;
        listaObjetos=entityManager.createQuery("Select f from Funcionario f where f."+parParametro+" LIKE :parDescricao", Funcionario.class).setParameter("parDescricao", "%"+parString+"%").getResultList();
        return listaObjetos;
    }
    
    @Override
    public void update(Funcionario objeto) {
        try {
            Funcionario funcionario = entityManager.find(Funcionario.class, objeto.getId());
            entityManager.getTransaction().begin();
            objeto.setSenha(funcionario.getSenha());
            objeto.setUsuario(funcionario.getUsuario());
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void UsuarioESenha (String senha, String usuario, int id){
        try {
            Funcionario funcionario = entityManager.find(Funcionario.class, id);
            entityManager.getTransaction().begin();
            funcionario.setSenha(senha);
            funcionario.setUsuario(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Funcionario objeto) {
        try {
            Funcionario funcionario = entityManager.find(Funcionario.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
