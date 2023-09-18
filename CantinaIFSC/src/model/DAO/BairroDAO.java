
package model.DAO;


import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bo.Bairro;

public class BairroDAO implements InterfaceDAO<Bairro>{

    @Override
    public void create(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cantina.bairro(descricao) VALUES (?)";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
            
        
    }

    @Override
    public List<Bairro> retrieve() {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select bairro.id, bairro.descricao from bairro";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Bairro> listaBairro = new ArrayList<Bairro>();

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("id"));
                bairro.setDescricao(rst.getString("descricao"));
                
                listaBairro.add(bairro);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaBairro;
        }
        
        
        
        
    }

    @Override
    public Bairro retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select bairro.id, bairro.descricao from bairro where id= ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Bairro bairroParPK = new Bairro();

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
                        
            pstm.setInt(1, parPK);

            rst = pstm.executeQuery();
            
            if(rst.next()){
                bairroParPK.setId(rst.getInt("id"));
                bairroParPK.setDescricao(rst.getString("descricao"));
            }
            
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return bairroParPK;
        }
    }

    @Override
    public Bairro retrieve(String parString) {
        return null;
    }

    @Override
    public void update(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE bairro "
                           + " SET bairro.descricao =? "
                           + " WHERE bairro.id=?";
        
        PreparedStatement pstm=null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
        
    }

    @Override
    public void delete(Bairro objeto) {
        
    }


    
    
}
