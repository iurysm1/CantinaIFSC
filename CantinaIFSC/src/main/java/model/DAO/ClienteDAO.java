
package model.DAO;

import model.bo.Cliente;
import java.util.List;
import model.bo.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bo.Bairro;
import model.bo.Cidade;
import utilities.Utilities;


public class ClienteDAO implements InterfaceDAO<Cliente>{

    @Override
    public void create(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "insert into cantina.cliente(nome, fone1, fone2, email, status, cpf, rg, matricula, dataNascimento, complementoEndereco, endereco_id) values (?,?,?,?,?,?,?,?,?,?,?)";
        
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
            pstm.setString(8, objeto.getMatricula());
            pstm.setDate(9, Utilities.stringToDate(objeto.getDataNascimento()));
            pstm.setString(10, objeto.getComplementoEndereco());
            pstm.setInt(11, objeto.getEndereco().getId());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Cliente> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cli.*, e.*, c.*, b.* from cliente cli  left outer join endereco e on cli.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> listaObjeto = new ArrayList<Cliente>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Cliente objeto = new Cliente();
                Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                Endereco endereco = new Endereco();
                
                objeto.setId(rst.getInt("cli.id"));
                objeto.setNome(rst.getString("cli.nome"));
                objeto.setFone1(rst.getString("cli.fone1"));
                objeto.setFone2(rst.getString("cli.fone2"));
                objeto.setCpf(rst.getString("cli.cpf"));
                objeto.setComplementoEndereco(rst.getString("cli.complementoEndereco"));
                objeto.setEmail(rst.getString("cli.email"));
                objeto.setRg(rst.getString("cli.rg"));
                objeto.setMatricula(rst.getString("cli.matricula"));
                objeto.setDataNascimento(rst.getString("cli.dataNascimento"));
                objeto.setStatus(rst.getString("cli.status"));
                
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
    public Cliente retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cli.*,e.*, c.*, b.*, date_format(cli.dataNascimento, '%d/%m/%Y') as data_formatada from cliente cli  left outer join endereco e on cli.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id where cli.id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Cliente objeto = new Cliente();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setInt(1, parPK);
            
            rst = pstm.executeQuery();
            
            
            if(rst.next()){
                Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                Endereco endereco = new Endereco();
                
                
                
                objeto.setId(rst.getInt("cli.id"));
                objeto.setNome(rst.getString("cli.nome"));
                objeto.setFone1(rst.getString("cli.fone1"));
                objeto.setFone2(rst.getString("cli.fone2"));
                objeto.setCpf(rst.getString("cli.cpf"));
                objeto.setComplementoEndereco(rst.getString("cli.complementoEndereco"));
                objeto.setEmail(rst.getString("cli.email"));
                objeto.setRg(rst.getString("cli.rg"));
                objeto.setMatricula(rst.getString("cli.matricula"));
                objeto.setDataNascimento(rst.getString("data_formatada"));
                objeto.setStatus(rst.getString("cli.status"));
                
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
    public List<Cliente> retrieve(String parString, String parParametro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cli.*, e.*, c.*, b.* from cliente cli  left outer join endereco e on cli.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id where cli.nome like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> listaObjeto = new ArrayList<Cliente>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, parString+'%');
            
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Cliente objeto = new Cliente();
                Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                Endereco endereco = new Endereco();
                
                objeto.setId(rst.getInt("cli.id"));
                objeto.setNome(rst.getString("cli.nome"));
                objeto.setFone1(rst.getString("cli.fone1"));
                objeto.setFone2(rst.getString("cli.fone2"));
                objeto.setCpf(rst.getString("cli.cpf"));
                objeto.setComplementoEndereco(rst.getString("cli.complementoEndereco"));
                objeto.setEmail(rst.getString("cli.email"));
                objeto.setRg(rst.getString("cli.rg"));
                objeto.setMatricula(rst.getString("cli.matricula"));
                objeto.setDataNascimento(rst.getString("cli.dataNascimento"));
                objeto.setStatus(rst.getString("cli.status"));
                
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
    
    
    
    public List<Cliente> retrieveCPF(String parString) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cli.*, e.*, c.*, b.* from cliente cli  left outer join endereco e on cli.endereco_id = e.id left outer join cidade c on e.cidade_id = c.id left outer join bairro b on e.bairro_id = b.id where cli.cpf like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> listaObjeto = new ArrayList<Cliente>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, parString+'%');
            
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Cliente objeto = new Cliente();
                Cidade cidade= new Cidade();
                Bairro bairro = new Bairro();
                Endereco endereco = new Endereco();
                
                objeto.setId(rst.getInt("cli.id"));
                objeto.setNome(rst.getString("cli.nome"));
                objeto.setFone1(rst.getString("cli.fone1"));
                objeto.setFone2(rst.getString("cli.fone2"));
                objeto.setCpf(rst.getString("cli.cpf"));
                objeto.setComplementoEndereco(rst.getString("cli.complementoEndereco"));
                objeto.setEmail(rst.getString("cli.email"));
                objeto.setRg(rst.getString("cli.rg"));
                objeto.setMatricula(rst.getString("cli.matricula"));
                objeto.setDataNascimento(rst.getString("cli.dataNascimento"));
                objeto.setStatus(rst.getString("cli.status"));
                
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
    public void update(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "update cliente set nome=?, fone1=?, fone2=?, email=?, status=?, cpf=?, rg=?, matricula=?, dataNascimento=?, complementoEndereco=?, endereco_id=? where id=?;";
        
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
            pstm.setString(8, objeto.getMatricula());
            pstm.setDate(9, Utilities.stringToDate(objeto.getDataNascimento()));
            pstm.setString(10, objeto.getComplementoEndereco());
            pstm.setInt(11, objeto.getEndereco().getId());
            pstm.setInt(12, objeto.getId());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
