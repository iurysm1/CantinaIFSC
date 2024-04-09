
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Venda;

public class VendaDAO implements InterfaceDAO<Venda>{
    

    @Override
    public void create(Venda objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "insert into cantina.venda(datahoravenda, flagtipodesconto, observacao,status, funcionario_id, carteirinha_id) values (NOW(), ?, ?, ?, ?,?)";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getFlagtipodesconto());
            pstm.setString(2, objeto.getObeservacao());
            pstm.setString(3, objeto.getStatus());
            pstm.setInt(4, objeto.getFuncionario().getId());
            pstm.setInt(5, objeto.getCarteirinha().getId());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }
    
    
    public int createReturnID(Venda objeto){
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "insert into cantina.venda(datahoravenda, flagtipodesconto, observacao,status, funcionario_id, carteirinha_id) values (NOW(), ?, ?, ?, ?,?)";
        
        PreparedStatement pstm =null;
        ResultSet rst=null;
        int idUltimaVenda=0;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, objeto.getFlagtipodesconto()+"");
            pstm.setString(2, objeto.getObeservacao());
            pstm.setString(3, objeto.getStatus());
            pstm.setInt(4, objeto.getFuncionario().getId());
            pstm.setInt(5, objeto.getCarteirinha().getId());
            
            int linhasAfetadas = pstm.executeUpdate();
            
            if(linhasAfetadas>0){
                rst=pstm.getGeneratedKeys();
                if(rst.next()){
                    idUltimaVenda=rst.getInt(1);
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return idUltimaVenda;
        }
    }
    
    

    @Override
    public List<Venda> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venda retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select * from venda where id=?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Venda objeto = new Venda();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, parPK);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                
                
                objeto.setId(rst.getInt("id"));
                objeto.setDatahoravenda(rst.getString("datahoravenda"));
                objeto.setFlagtipodesconto(rst.getString("flagtipodesconto"));
                objeto.setObeservacao(rst.getString("observacao"));
                objeto.setValordesconto(rst.getInt("valordesconto"));
                objeto.setStatus(rst.getString("status"));
                
                objeto.setCarteirinha(service.CarteirinhaService.carregar(rst.getInt("carteirinha_id")));
                objeto.setFuncionario(service.FuncionarioService.carregar(rst.getInt("funcionario_id")));
                
                
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return objeto;
        }
    }

    @Override
    public List<Venda> retrieve(String parString, String parParametro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Venda> retornarVendas(String dataAbertura, String dataFechamento){
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select * from venda where datahoravenda between ? AND ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Venda> listaObjeto = new ArrayList<Venda>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, utilities.Utilities.converterFormato(dataAbertura));
            pstm.setString(2, utilities.Utilities.converterFormato(dataFechamento));
            System.out.println(utilities.Utilities.stringToDateTime(dataAbertura)+"+"+utilities.Utilities.stringToDateTime(dataFechamento));
            
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Venda objeto = new Venda();
                
                objeto.setId(rst.getInt("id"));
                objeto.setDatahoravenda(rst.getString("datahoravenda"));
                objeto.setFlagtipodesconto(rst.getString("flagtipodesconto"));
                objeto.setObeservacao(rst.getString("observacao"));
                objeto.setValordesconto(rst.getInt("valordesconto"));
                objeto.setStatus(rst.getString("status"));
                
                objeto.setCarteirinha(service.CarteirinhaService.carregar(rst.getInt("carteirinha_id")));
                objeto.setFuncionario(service.FuncionarioService.carregar(rst.getInt("funcionario_id")));
                
                listaObjeto.add(objeto);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaObjeto;
        }
    }
    
}
