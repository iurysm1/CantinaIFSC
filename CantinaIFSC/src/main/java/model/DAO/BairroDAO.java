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
        
        listaObjetos= entityManager.createQuery("Select b from bairro b",Bairro.class).getResultList();
        return listaObjetos;

    }

    @Override
    public Bairro retrieve(int parPK) {
        return entityManager.find(Bairro.class, parPK);
    }

    @Override
    public List<Bairro> retrieve(String parString) {
        
        List<Bairro> listaObjetos;
        listaObjetos= entityManager.createQuery("Select b from bairro b where b.descricao LIKE :parDescricao",Bairro.class).setParameter("parDescricao", "%"+parString+"%").getResultList();
                
        return listaObjetos;
    }

    @Override
    public void update(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE bairro "
                + " SET bairro.descricao =?, "
                + "bairro.status = ?"
                + " WHERE bairro.id=?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(3, objeto.getId());
            pstm.setString(2, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public void delete(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM bairro WHERE id = ?;";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

}
