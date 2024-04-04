
package model.DAO;

import java.util.List;
import model.bo.Fornecedor;

import model.bo.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bo.Bairro;
import model.bo.Cidade;

public class FornecedorDAO implements InterfaceDAO<Fornecedor>{

    @Override
    public void create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "insert into cantina.fornecedor(nome, fone1, fone2, email, status, cnpj, inscricaoestadual, complementoEndereco, endereco_id) values (?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus());
            pstm.setString(6, objeto.getCnpj());
            pstm.setString(7, objeto.getInscricaoestadual());
            pstm.setString(8, objeto.getComplementoEndereco());
            pstm.setInt(9, objeto.getEndereco().getId());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Fornecedor> retrieve() {
       Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select objeto.*, e.*, c.*, b.* from fornecedor objeto left outer join endereco e on objeto.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Fornecedor> listaObjeto = new ArrayList<Fornecedor>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Fornecedor objeto = new Fornecedor();
                Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                Endereco endereco = new Endereco();
                
                objeto.setId(rst.getInt("objeto.id"));
                objeto.setNome(rst.getString("objeto.nome"));
                objeto.setFone1(rst.getString("objeto.fone1"));
                objeto.setFone2(rst.getString("objeto.fone2"));                
                objeto.setComplementoEndereco(rst.getString("objeto.complementoEndereco"));
                objeto.setEmail(rst.getString("objeto.email"));
                objeto.setStatus(rst.getString("objeto.status"));
                
                objeto.setInscricaoestadual(rst.getString("objeto.inscricaoestadual"));
                objeto.setCnpj(rst.getString("objeto.cnpj"));
                
                endereco.setId(rst.getInt("e.id"));
                endereco.setCep(rst.getString("e.cep"));
                endereco.setLogradouro(rst.getString("e.logradouro"));
                endereco.setStatus(rst.getString("e.status"));
                
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("c.uf"));
                cidade.setStatus(rst.getString("c.status"));
                cidade.setDescricao(rst.getString("c.descricao"));
               
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setStatus(rst.getString("b.status"));
                bairro.setDescricao(rst.getString("b.descricao"));
                
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                
                objeto.setEndereco(endereco);
                
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
    public Fornecedor retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select objeto.*,e.*, c.*, b.* from fornecedor objeto  left outer join endereco e on objeto.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id where objeto.id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Fornecedor objeto = new Fornecedor();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setInt(1, parPK);
            
            rst = pstm.executeQuery();
            
            
            if(rst.next()){
                Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                Endereco endereco = new Endereco();
                
                objeto.setId(rst.getInt("objeto.id"));
                objeto.setNome(rst.getString("objeto.nome"));
                objeto.setFone1(rst.getString("objeto.fone1"));
                objeto.setFone2(rst.getString("objeto.fone2"));                
                objeto.setComplementoEndereco(rst.getString("objeto.complementoEndereco"));
                objeto.setEmail(rst.getString("objeto.email"));
                objeto.setStatus(rst.getString("objeto.status"));
                
                objeto.setInscricaoestadual(rst.getString("objeto.inscricaoestadual"));
                objeto.setCnpj(rst.getString("objeto.cnpj"));
                
                endereco.setId(rst.getInt("e.id"));
                endereco.setCep(rst.getString("e.cep"));
                endereco.setLogradouro(rst.getString("e.logradouro"));
                endereco.setStatus(rst.getString("e.status"));
                
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("c.uf"));
                cidade.setStatus(rst.getString("c.status"));
                cidade.setDescricao(rst.getString("c.descricao"));
               
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setStatus(rst.getString("b.status"));
                bairro.setDescricao(rst.getString("b.descricao"));
                
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                
                objeto.setEndereco(endereco);
                
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return objeto;
        }
    }

    @Override
    public List<Fornecedor> retrieve(String parString, String parParametro) {
       Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select objeto.*, e.*, c.*, b.* from fornecedor objeto left outer join endereco e on objeto.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id where nome like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Fornecedor> listaObjeto = new ArrayList<Fornecedor>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, parString+"%");
            
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Fornecedor objeto = new Fornecedor();
                Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                Endereco endereco = new Endereco();
                
                objeto.setId(rst.getInt("objeto.id"));
                objeto.setNome(rst.getString("objeto.nome"));
                objeto.setFone1(rst.getString("objeto.fone1"));
                objeto.setFone2(rst.getString("objeto.fone2"));                
                objeto.setComplementoEndereco(rst.getString("objeto.complementoEndereco"));
                objeto.setEmail(rst.getString("objeto.email"));
                objeto.setStatus(rst.getString("objeto.status"));
                
                objeto.setInscricaoestadual(rst.getString("objeto.inscricaoestadual"));
                objeto.setCnpj(rst.getString("objeto.cnpj"));
                
                endereco.setId(rst.getInt("e.id"));
                endereco.setCep(rst.getString("e.cep"));
                endereco.setLogradouro(rst.getString("e.logradouro"));
                endereco.setStatus(rst.getString("e.status"));
                
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("c.uf"));
                cidade.setStatus(rst.getString("c.status"));
                cidade.setDescricao(rst.getString("c.descricao"));
               
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setStatus(rst.getString("b.status"));
                bairro.setDescricao(rst.getString("b.descricao"));
                
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                
                objeto.setEndereco(endereco);
                
                listaObjeto.add(objeto);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaObjeto;
        }
    }
    
    public List<Fornecedor> retrieveCNPJ(String parString) {
       Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select objeto.*, e.*, c.*, b.* from fornecedor objeto left outer join endereco e on objeto.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id where cnpj like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Fornecedor> listaObjeto = new ArrayList<Fornecedor>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, parString+"%");
            
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Fornecedor objeto = new Fornecedor();
                Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                Endereco endereco = new Endereco();
                
                objeto.setId(rst.getInt("objeto.id"));
                objeto.setNome(rst.getString("objeto.nome"));
                objeto.setFone1(rst.getString("objeto.fone1"));
                objeto.setFone2(rst.getString("objeto.fone2"));                
                objeto.setComplementoEndereco(rst.getString("objeto.complementoEndereco"));
                objeto.setEmail(rst.getString("objeto.email"));
                objeto.setStatus(rst.getString("objeto.status"));
                
                objeto.setInscricaoestadual(rst.getString("objeto.inscricaoestadual"));
                objeto.setCnpj(rst.getString("objeto.cnpj"));
                
                endereco.setId(rst.getInt("e.id"));
                endereco.setCep(rst.getString("e.cep"));
                endereco.setLogradouro(rst.getString("e.logradouro"));
                endereco.setStatus(rst.getString("e.status"));
                
                cidade.setId(rst.getInt("cidade_id"));
                cidade.setUf(rst.getString("c.uf"));
                cidade.setStatus(rst.getString("c.status"));
                cidade.setDescricao(rst.getString("c.descricao"));
               
                bairro.setId(rst.getInt("bairro_id"));
                bairro.setStatus(rst.getString("b.status"));
                bairro.setDescricao(rst.getString("b.descricao"));
                
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                
                objeto.setEndereco(endereco);
                
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
    public void update(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "update fornecedor set nome=?, fone1=?, fone2=?, email=?, status=?, cnpj=?, inscricaoestadual=?, complementoEndereco=?, endereco_id=? where id=?;";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus());
            pstm.setString(6, objeto.getCnpj());
            pstm.setString(7, objeto.getInscricaoestadual());
            pstm.setString(8, objeto.getComplementoEndereco());
            pstm.setInt(9, objeto.getEndereco().getId());
            pstm.setInt(10, objeto.getId());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Fornecedor objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
