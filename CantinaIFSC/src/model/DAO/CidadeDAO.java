
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
import model.bo.Cidade;

public class CidadeDAO implements InterfaceDAO<Cidade>{

    @Override
    public void create(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cantina.cidade(descricao, uf) VALUES (?,?,?)";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getUf());
            pstm.setString(3, objeto.getStatus());
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Cidade> retrieve() {
        
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select * from cidade";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cidade> listaObjeto = new ArrayList<Cidade>();

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Cidade objeto = new Cidade();
                objeto.setId(rst.getInt("id"));
                objeto.setDescricao(rst.getString("descricao"));
                objeto.setUf(rst.getString("uf"));
                objeto.setStatus(rst.getString("status"));
                
                listaObjeto.add(objeto);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaObjeto;
        }
        
        
        
        
    }

    @Override
    public Cidade retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select * from cidade where id= ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Cidade cidadeParPK = new Cidade();

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
                        
            pstm.setInt(1, parPK);

            rst = pstm.executeQuery();
            
            if(rst.next()){
                cidadeParPK.setId(rst.getInt("id"));
                cidadeParPK.setDescricao(rst.getString("descricao"));
                cidadeParPK.setUf(rst.getString("uf"));
                cidadeParPK.setStatus(rst.getString("status"));
            }
            
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cidadeParPK;
        }
    }

    @Override
    public List<Cidade> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select * from cidade where descricao like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cidade> listaCidade = new ArrayList<Cidade>();

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, parString+'%');
            
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
                cidade.setUf(rst.getString("uf"));
                 cidade.setStatus(rst.getString("status"));
                
                listaCidade.add(cidade);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCidade;
        }
            }
    
    public List<Cidade> retrieveUF(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select * from cidade where uf like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cidade> listaCidade = new ArrayList<Cidade>();

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, parString+'%');
            
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Cidade cidade = new Cidade();
                cidade.setId(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
                cidade.setUf(rst.getString("uf"));
                 cidade.setStatus(rst.getString("status"));
                
                listaCidade.add(cidade);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCidade;
        }
            }

    @Override
    public void update(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE cidade "
                           + " SET cidade.descricao =?, cidade.uf =?, cidade.status=? "
                           + " WHERE cidade.id=?";
        
        PreparedStatement pstm=null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getUf());
            pstm.setInt(4, objeto.getId());
            pstm.setString(3, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
        
    }

    @Override
    public void delete(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM cidade WHERE id = ?;";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }
    
}
