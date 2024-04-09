
package model.DAO;

import java.util.List;
import model.bo.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bo.Cidade;
import model.bo.Bairro;

public class EnderecoDAO implements InterfaceDAO<Endereco>{

    @Override
    public void create(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cantina.endereco(cep, logradouro, cidade_id, bairro_id, status) VALUES (?,?,?,?,?)";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCep());
            pstm.setString(2, objeto.getLogradouro());
            pstm.setInt(3, objeto.getCidade().getId());
            pstm.setInt(4, objeto.getBairro().getId());
            pstm.setString(5, objeto.getStatus());
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Endereco> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select e.*, c.descricao, c.uf, c.status, b.descricao, b.status from endereco e left outer join cidade c on e.cidade_id = c.id join bairro b on e.bairro_id = b.id";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Endereco> listaObjeto = new ArrayList<Endereco>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                
                Endereco objeto = new Endereco();
                objeto.setId(rst.getInt("id"));
                objeto.setCep(rst.getString("cep"));
                objeto.setLogradouro(rst.getString("logradouro"));
                objeto.setStatus(rst.getString("status"));
                
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("uf"));
                cidade.setStatus(rst.getString("c.status"));
                cidade.setDescricao(rst.getString("c.descricao"));
               
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setStatus(rst.getString("b.status"));
                bairro.setDescricao(rst.getString("b.descricao"));
                
                objeto.setBairro(bairro);
                objeto.setCidade(cidade);
                
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
    public Endereco retrieve(int parPK) {
       Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select e.*, c.descricao, c.uf, c.status, b.status, b.descricao from endereco e left outer join cidade c on e.cidade_id = c.id join bairro b on e.bairro_id = b.id where e.id=?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Endereco objeto = new Endereco();

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
                        
            pstm.setInt(1, parPK);

            rst = pstm.executeQuery();
            
            if(rst.next()){
                 Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                
                objeto = new Endereco();
                objeto.setId(rst.getInt("id"));
                objeto.setCep(rst.getString("cep"));
                objeto.setLogradouro(rst.getString("logradouro"));
                objeto.setStatus(rst.getString("status"));
                
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("uf"));
                cidade.setStatus(rst.getString("c.status"));
                cidade.setDescricao(rst.getString("c.descricao"));
               
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setDescricao(rst.getString("b.descricao"));
                bairro.setStatus(rst.getString("b.status"));
                
                objeto.setBairro(bairro);
                objeto.setCidade(cidade);
                            }
            
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return objeto;
        }
    }
    
    public Endereco retrieveCEP(String cep) {
       Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select e.*, c.descricao, c.uf, c.status, b.status, b.descricao from endereco e left outer join cidade c on e.cidade_id = c.id join bairro b on e.bairro_id = b.id where e.cep=?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Endereco objeto = new Endereco();

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
                        
            pstm.setString(1, cep);

            rst = pstm.executeQuery();
            
            if(rst.next()){
                 Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                
                objeto = new Endereco();
                objeto.setId(rst.getInt("id"));
                objeto.setCep(rst.getString("cep"));
                objeto.setLogradouro(rst.getString("logradouro"));
                objeto.setStatus(rst.getString("status"));
                
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("uf"));
                cidade.setStatus(rst.getString("c.status"));
                cidade.setDescricao(rst.getString("c.descricao"));
               
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setDescricao(rst.getString("b.descricao"));
                bairro.setStatus(rst.getString("b.status"));
                
                objeto.setBairro(bairro);
                objeto.setCidade(cidade);
                            }
            
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return objeto;
        }
    }

    
    @Override
    public List<Endereco> retrieve(String parString) {
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select e.*, c.descricao, c.uf, c.status, b.status, b.descricao from endereco e left outer join cidade c on e.cidade_id = c.id join bairro b on e.bairro_id = b.id where e.logradouro like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Endereco> listaObjeto = new ArrayList<Endereco>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString+'%');
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                
                
                
                Endereco objeto = new Endereco();
                objeto.setId(rst.getInt("id"));
                objeto.setCep(rst.getString("cep"));
                objeto.setLogradouro(rst.getString("logradouro"));
                objeto.setStatus(rst.getString("status"));
                
                Cidade cidade= new Cidade();
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("uf"));
                cidade.setDescricao(rst.getString("c.descricao"));
               
                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setDescricao(rst.getString("b.descricao"));
                
                bairro.setStatus(rst.getString("b.status"));
                cidade.setStatus(rst.getString("c.status"));
               
                objeto.setBairro(bairro);
                objeto.setCidade(cidade);
                
                listaObjeto.add(objeto);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaObjeto;
        }
    }
    
    public List<Endereco> retrieveBairro(String parString) {
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select e.*, c.descricao, c.uf, b.descricao, c.status, b.status from endereco e left outer join cidade c on e.cidade_id = c.id join bairro b on e.bairro_id = b.id where b.descricao like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Endereco> listaObjeto = new ArrayList<Endereco>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString+'%');
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                
                
                
                Endereco objeto = new Endereco();
                objeto.setId(rst.getInt("id"));
                objeto.setCep(rst.getString("cep"));
                objeto.setLogradouro(rst.getString("logradouro"));
                objeto.setStatus(rst.getString("status"));
                
                Cidade cidade= new Cidade();
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("uf"));
                cidade.setDescricao(rst.getString("c.descricao"));
               
                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setDescricao(rst.getString("b.descricao"));
                
                bairro.setStatus(rst.getString("b.status"));
                cidade.setStatus(rst.getString("c.status"));
                
                objeto.setBairro(bairro);
                objeto.setCidade(cidade);
                
                listaObjeto.add(objeto);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaObjeto;
        }
    }
    
    public List<Endereco> retrieveCidade(String parString) {
         Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "Select e.*, c.descricao, c.uf, b.descricao, c.status, b.status from endereco e left outer join cidade c on e.cidade_id = c.id join bairro b on e.bairro_id = b.id where c.descricao like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Endereco> listaObjeto = new ArrayList<Endereco>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString+'%');
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                
                
                
                Endereco objeto = new Endereco();
                objeto.setId(rst.getInt("id"));
                objeto.setCep(rst.getString("cep"));
                objeto.setLogradouro(rst.getString("logradouro"));
                objeto.setStatus(rst.getString("status"));
                
                Cidade cidade= new Cidade();
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("uf"));
                cidade.setDescricao(rst.getString("c.descricao"));
               
                Bairro bairro = new Bairro();
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setDescricao(rst.getString("b.descricao"));
                
                bairro.setStatus(rst.getString("b.status"));
                cidade.setStatus(rst.getString("c.status"));
                
                objeto.setBairro(bairro);
                objeto.setCidade(cidade);
                
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
    public void update(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE endereco "
                           + " SET endereco.logradouro =?, endereco.status=?, endereco.cep=?, endereco.bairro_id=?, endereco.cidade_id=?"
                           + " WHERE endereco.id=?";
        
        PreparedStatement pstm=null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getLogradouro());
            pstm.setString(2, objeto.getStatus());
            pstm.setString(3, objeto.getCep());
            pstm.setInt(4, objeto.getBairro().getId());
            pstm.setInt(5, objeto.getCidade().getId());
            pstm.setInt(6, objeto.getId());
            
           
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Endereco objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
