
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Cliente;
import model.bo.Produto;
import utilities.Utilities;

public class ProdutoDAO implements InterfaceDAO<Produto>{

    @Override
    public void create(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "insert into cantina.produto(descricao, codigoBarra, status, preco, caminho_foto) values (?, ?, ?, ?, ?)";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigobarra());
            pstm.setString(3, objeto.getStatus());
            pstm.setFloat(4, objeto.getPreco());
            pstm.setString(5, objeto.getCaminhoFotoProduto());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Produto> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select * from produto";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Produto> listaObjeto = new ArrayList<Produto>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Produto objeto = new Produto();
                
                
                objeto.setId(rst.getInt("id"));
                objeto.setCodigobarra(rst.getString("codigoBarra"));
                objeto.setStatus(rst.getString("status"));
                objeto.setPreco(rst.getFloat("preco"));
                objeto.setDescricao(rst.getString("descricao"));
                objeto.setCaminhoFotoProduto(rst.getString("caminho_foto"));
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
    public Produto retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select * from produto where id=?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Produto objeto = new Produto();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                
                
                objeto.setId(rst.getInt("id"));
                objeto.setCodigobarra(rst.getString("codigoBarra"));
                objeto.setStatus(rst.getString("status"));
                objeto.setPreco(rst.getFloat("preco"));
                objeto.setDescricao(rst.getString("descricao"));
                objeto.setCaminhoFotoProduto(rst.getString("caminho_foto"));
                
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return objeto;
        }
    }
    
    

    @Override
    public List<Produto> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select * from produto where descricao like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Produto> listaObjeto = new ArrayList<Produto>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString+"%");
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Produto objeto = new Produto();
                
                
                objeto.setId(rst.getInt("id"));
                objeto.setCodigobarra(rst.getString("codigoBarra"));
                objeto.setStatus(rst.getString("status"));
                objeto.setPreco(rst.getFloat("preco"));
                objeto.setDescricao(rst.getString("descricao"));
                objeto.setCaminhoFotoProduto(rst.getString("caminho_foto"));
                listaObjeto.add(objeto);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaObjeto;
        }
    }
    
    public List<Produto> retrieveCodigoBarras(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select * from produto where codigoBarra like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Produto> listaObjeto = new ArrayList<Produto>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString+"%");
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Produto objeto = new Produto();
                
                
                objeto.setId(rst.getInt("id"));
                objeto.setCodigobarra(rst.getString("codigoBarra"));
                objeto.setStatus(rst.getString("status"));
                objeto.setPreco(rst.getFloat("preco"));
                objeto.setDescricao(rst.getString("descricao"));
                objeto.setCaminhoFotoProduto(rst.getString("caminho_foto"));
                listaObjeto.add(objeto);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaObjeto;
        }
    }
    
    public List<Produto> retrievePreco(Float parFloat) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select * from produto where preco = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Produto> listaObjeto = new ArrayList<Produto>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parFloat+"%");
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Produto objeto = new Produto();
                
                
                objeto.setId(rst.getInt("id"));
                objeto.setCodigobarra(rst.getString("codigoBarra"));
                objeto.setStatus(rst.getString("status"));
                objeto.setPreco(rst.getFloat("preco"));
                objeto.setDescricao(rst.getString("descricao"));
                objeto.setCaminhoFotoProduto(rst.getString("caminho_foto"));
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
    public void update(Produto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "update cantina.produto set descricao=?, codigoBarra=?, status=?, preco=?, caminho_foto=? where id=?";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getCodigobarra());
            pstm.setString(3, objeto.getStatus());
            pstm.setFloat(4, objeto.getPreco());
            pstm.setString(5, objeto.getCaminhoFotoProduto());
            pstm.setInt(6, objeto.getId());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Produto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
