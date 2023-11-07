
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Funcionario;
import utilities.Utilities;

public class FuncionarioDAO implements InterfaceDAO<Funcionario>{

    @Override
    public void create(Funcionario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "insert into cantina.funcionario(nome, fone1, fone2, email, status, cpf, rg, dataNascimento, complementoEndereco, endereco_id, senha, usuario) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus());
            pstm.setString(6, objeto.getCpf());
            pstm.setString(7, objeto.getRg());
            pstm.setDate(8, Utilities.stringToDate(objeto.getDataNascimento()));
            pstm.setString(9, objeto.getComplementoEndereco());
            pstm.setInt(10, objeto.getEndereco().getId());
            pstm.setString(11, objeto.getSenha());
            pstm.setString(12, objeto.getUsuario());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }
    
    public void UsuarioESenha (String senha, String usuario, int id){
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "update cantina.funcionario set senha=?, usuario=? where id=?;";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, senha);
            pstm.setString(2, usuario);
            pstm.setInt(3, id);
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Funcionario> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select objeto.*, e.*, c.*, b.* from funcionario objeto  left outer join endereco e on objeto.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Funcionario> listaObjeto = new ArrayList<Funcionario>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Funcionario objeto = new Funcionario();
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
                objeto.setCpf(rst.getString("objeto.cpf"));
                
                objeto.setSenha(rst.getString("objeto.senha"));
                objeto.setUsuario(rst.getString("objeto.usuario"));
                
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
    public Funcionario retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select objeto.*, e.*, c.*, b.* from funcionario objeto  left outer join endereco e on objeto.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id where objeto.id=?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Funcionario objeto = new Funcionario();
        

        
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
                objeto.setCpf(rst.getString("objeto.cpf"));
                
                objeto.setSenha(rst.getString("objeto.senha"));
                objeto.setUsuario(rst.getString("objeto.usuario"));
                
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
    public List<Funcionario> retrieve(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select objeto.*, e.*, c.*, b.* from funcionario objeto  left outer join endereco e on objeto.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id where objeto.nome like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Funcionario> listaObjeto = new ArrayList<Funcionario>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, parString+"%");
            
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Funcionario objeto = new Funcionario();
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
                objeto.setCpf(rst.getString("objeto.cpf"));
                
                objeto.setSenha(rst.getString("objeto.senha"));
                objeto.setUsuario(rst.getString("objeto.usuario"));
                
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
    
    public List<Funcionario> retrieveCPF(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select objeto.*, e.*, c.*, b.* from funcionario objeto  left outer join endereco e on objeto.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id where objeto.cpf like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Funcionario> listaObjeto = new ArrayList<Funcionario>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString+"%");
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Funcionario objeto = new Funcionario();
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
                objeto.setCpf(rst.getString("objeto.cpf"));
                
                objeto.setSenha(rst.getString("objeto.senha"));
                objeto.setUsuario(rst.getString("objeto.usuario"));
                
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
    public void update(Funcionario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "update funcionario set nome=?, fone1=?, fone2=?, email=?, status=?, cpf=?, rg=?, dataNascimento=?, complementoEndereco=?, endereco_id=? where id=?;";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getStatus());
            pstm.setString(6, objeto.getCpf());
            pstm.setString(7, objeto.getRg());
            pstm.setDate(8, Utilities.stringToDate(objeto.getDataNascimento()));
            pstm.setString(9, objeto.getComplementoEndereco());
            pstm.setInt(10, objeto.getEndereco().getId());
            pstm.setInt(11, objeto.getId());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
