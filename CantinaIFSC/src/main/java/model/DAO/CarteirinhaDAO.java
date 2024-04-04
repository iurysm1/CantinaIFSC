
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Bairro;
import model.bo.Carteirinha;
import model.bo.Cidade;
import model.bo.Cliente;
import model.bo.Endereco;
import service.EnderecoService;
import utilities.Utilities;

public class CarteirinhaDAO implements InterfaceDAO<Carteirinha>{

    @Override
    public void create(Carteirinha objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "insert into carteirinha(codigobarra, datageracao, datacancelamento, cliente_id, status) values (?, ?, ?, ?, ?);";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, objeto.getCodigobarra());
            pstm.setDate(2, Utilities.stringToDate(objeto.getDatageracao()));
            pstm.setDate(3, Utilities.stringToDate(objeto.getDatacancelamento()));
            pstm.setInt(4, objeto.getCliente().getId());
            pstm.setString(5, objeto.getStatus());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Carteirinha> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cli.*, crt.*, date_format(cli.dataNascimento, '%d/%m/%Y') as data_formatada_cli, date_format(crt.datageracao, '%d/%m/%Y')as data_geracao, date_format(crt.datacancelamento, '%d/%m/%Y')as data_cancelamento from carteirinha crt left outer join cliente cli on crt.cliente_id = cli.id";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Carteirinha> listaObjeto = new ArrayList<Carteirinha>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Carteirinha carteirinha = new Carteirinha();
                Cliente objeto = new Cliente();
                
                carteirinha.setId(rst.getInt("crt.id"));
                carteirinha.setStatus(rst.getString("crt.status"));
                carteirinha.setCodigobarra(rst.getString("crt.codigobarra"));
                carteirinha.setDatageracao(rst.getString("data_geracao"));
                carteirinha.setDatacancelamento(rst.getString("data_cancelamento"));
                
                
                objeto.setId(rst.getInt("cli.id"));
                objeto.setNome(rst.getString("cli.nome"));
                objeto.setFone1(rst.getString("cli.fone1"));
                objeto.setFone2(rst.getString("cli.fone2"));
                objeto.setCpf(rst.getString("cli.cpf"));
                objeto.setComplementoEndereco(rst.getString("cli.complementoEndereco"));
                objeto.setEmail(rst.getString("cli.email"));
                objeto.setRg(rst.getString("cli.rg"));
                objeto.setMatricula(rst.getString("cli.matricula"));
                objeto.setDataNascimento(rst.getString("data_formatada_cli"));
                objeto.setStatus(rst.getString("cli.status"));
                objeto.setEndereco(EnderecoService.carregar(rst.getInt("cli.endereco_id")));
                carteirinha.setCliente(objeto);
                
                listaObjeto.add(carteirinha);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaObjeto;
        }
    }

    @Override
    public Carteirinha retrieve(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cli.*, crt.*, date_format(cli.dataNascimento, '%d/%m/%Y') as data_formatada_cli, date_format(crt.datageracao, '%d/%m/%Y')as data_geracao,  date_format(crt.datacancelamento, '%d/%m/%Y')as data_cancelamento from carteirinha crt left outer join cliente cli on crt.cliente_id = cli.id where crt.id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Carteirinha carteirinha = new Carteirinha();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setInt(1, parPK);

            rst = pstm.executeQuery();
            
            
            if(rst.next()){
                
                Cliente objeto = new Cliente();
                
                carteirinha.setId(rst.getInt("crt.id"));
                carteirinha.setStatus(rst.getString("crt.status"));
                carteirinha.setCodigobarra(rst.getString("crt.codigobarra"));
                carteirinha.setDatageracao(rst.getString("data_geracao"));
                carteirinha.setDatacancelamento(rst.getString("data_cancelamento"));
                
                
                objeto.setId(rst.getInt("cli.id"));
                objeto.setNome(rst.getString("cli.nome"));
                objeto.setFone1(rst.getString("cli.fone1"));
                objeto.setFone2(rst.getString("cli.fone2"));
                objeto.setCpf(rst.getString("cli.cpf"));
                objeto.setComplementoEndereco(rst.getString("cli.complementoEndereco"));
                objeto.setEmail(rst.getString("cli.email"));
                objeto.setRg(rst.getString("cli.rg"));
                objeto.setMatricula(rst.getString("cli.matricula"));
                objeto.setDataNascimento(rst.getString("data_formatada_cli"));
                objeto.setStatus(rst.getString("cli.status"));
                objeto.setEndereco(EnderecoService.carregar(rst.getInt("cli.endereco_id")));
                carteirinha.setCliente(objeto);
                
                
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return carteirinha;
        }
    }
    
    public Carteirinha retrieveIdCliente(int parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cli.*, crt.*, date_format(cli.dataNascimento, '%d/%m/%Y') as data_formatada_cli, date_format(crt.datageracao, '%d/%m/%Y')as data_geracao,  date_format(crt.datacancelamento, '%d/%m/%Y')as data_cancelamento from carteirinha crt left outer join cliente cli on crt.cliente_id = cli.id where cli.id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Carteirinha carteirinha = new Carteirinha();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setInt(1, parPK);

            rst = pstm.executeQuery();
            
            
            if(rst.next()){
                
                Cliente objeto = new Cliente();
                
                carteirinha.setId(rst.getInt("crt.id"));
                carteirinha.setStatus(rst.getString("crt.status"));
                carteirinha.setCodigobarra(rst.getString("crt.codigobarra"));
                carteirinha.setDatageracao(rst.getString("data_geracao"));
                carteirinha.setDatacancelamento(rst.getString("data_cancelamento"));
                
                
                objeto.setId(rst.getInt("cli.id"));
                objeto.setNome(rst.getString("cli.nome"));
                objeto.setFone1(rst.getString("cli.fone1"));
                objeto.setFone2(rst.getString("cli.fone2"));
                objeto.setCpf(rst.getString("cli.cpf"));
                objeto.setComplementoEndereco(rst.getString("cli.complementoEndereco"));
                objeto.setEmail(rst.getString("cli.email"));
                objeto.setRg(rst.getString("cli.rg"));
                objeto.setMatricula(rst.getString("cli.matricula"));
                objeto.setDataNascimento(rst.getString("data_formatada_cli"));
                objeto.setStatus(rst.getString("cli.status"));
                objeto.setEndereco(EnderecoService.carregar(rst.getInt("cli.endereco_id")));
                carteirinha.setCliente(objeto);
                
                
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return carteirinha;
    }
    }
    
    public Carteirinha retrieveCodigoBarras(String parPK) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cli.*, crt.*, date_format(cli.dataNascimento, '%d/%m/%Y') as data_formatada_cli, date_format(crt.datageracao, '%d/%m/%Y')as data_geracao,  date_format(crt.datacancelamento, '%d/%m/%Y')as data_cancelamento from carteirinha crt left outer join cliente cli on crt.cliente_id = cli.id where codigobarra = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Carteirinha carteirinha = new Carteirinha();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, parPK);

            rst = pstm.executeQuery();
            
            
            if(rst.next()){
                
                Cliente objeto = new Cliente();
                
                carteirinha.setId(rst.getInt("crt.id"));
                carteirinha.setStatus(rst.getString("crt.status"));
                carteirinha.setCodigobarra(rst.getString("crt.codigobarra"));
                carteirinha.setDatageracao(rst.getString("data_geracao"));
                carteirinha.setDatacancelamento(rst.getString("data_cancelamento"));
                
                
                objeto.setId(rst.getInt("cli.id"));
                objeto.setNome(rst.getString("cli.nome"));
                objeto.setFone1(rst.getString("cli.fone1"));
                objeto.setFone2(rst.getString("cli.fone2"));
                objeto.setCpf(rst.getString("cli.cpf"));
                objeto.setComplementoEndereco(rst.getString("cli.complementoEndereco"));
                objeto.setEmail(rst.getString("cli.email"));
                objeto.setRg(rst.getString("cli.rg"));
                objeto.setMatricula(rst.getString("cli.matricula"));
                objeto.setDataNascimento(rst.getString("data_formatada_cli"));
                objeto.setStatus(rst.getString("cli.status"));
                objeto.setEndereco(EnderecoService.carregar(rst.getInt("cli.endereco_id")));
                carteirinha.setCliente(objeto);
                
                
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return carteirinha;
    }
    }
    
    

    @Override
    public List<Carteirinha> retrieve(String parString, String parParametro) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "select cli.*, crt.*, date_format(cli.dataNascimento, '%d/%m/%Y') as data_formatada_cli, date_format(crt.datageracao, '%d/%m/%Y')as data_geracao,  date_format(crt.datacancelamento, '%d/%m/%Y')as data_cancelamento from carteirinha crt left outer join cliente cli on crt.cliente_id = cli.id where cli.nome like ?";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Carteirinha> listaObjeto = new ArrayList<Carteirinha>();
        

        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, parString+"%");
            rst = pstm.executeQuery();
            
            
            while(rst.next()){
                Carteirinha carteirinha = new Carteirinha();
                Cliente objeto = new Cliente();
                
                carteirinha.setId(rst.getInt("crt.id"));
                carteirinha.setStatus(rst.getString("crt.status"));
                carteirinha.setCodigobarra(rst.getString("crt.codigobarra"));
                carteirinha.setDatageracao(rst.getString("data_geracao"));
                carteirinha.setDatacancelamento(rst.getString("data_cancelamento"));
                
                
                objeto.setId(rst.getInt("cli.id"));
                objeto.setNome(rst.getString("cli.nome"));
                objeto.setFone1(rst.getString("cli.fone1"));
                objeto.setFone2(rst.getString("cli.fone2"));
                objeto.setCpf(rst.getString("cli.cpf"));
                objeto.setComplementoEndereco(rst.getString("cli.complementoEndereco"));
                objeto.setEmail(rst.getString("cli.email"));
                objeto.setRg(rst.getString("cli.rg"));
                objeto.setMatricula(rst.getString("cli.matricula"));
                objeto.setDataNascimento(rst.getString("data_formatada_cli"));
                objeto.setStatus(rst.getString("cli.status"));
                objeto.setEndereco(EnderecoService.carregar(rst.getInt("cli.endereco_id")));
                carteirinha.setCliente(objeto);
                
                listaObjeto.add(carteirinha);
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaObjeto;
        }
    }

    @Override
    public void update(Carteirinha objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "update carteirinha set codigobarra=?, datageracao=?, datacancelamento=?, cliente_id=?, status=? where id=?";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, objeto.getCodigobarra());
            pstm.setDate(2, Utilities.stringToDate(objeto.getDatageracao()));
            pstm.setDate(3, Utilities.stringToDate(objeto.getDatacancelamento()));
            pstm.setInt(4, objeto.getCliente().getId());
            pstm.setString(5, objeto.getStatus());
            pstm.setInt(6, objeto.getId());
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public void delete(Carteirinha objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
