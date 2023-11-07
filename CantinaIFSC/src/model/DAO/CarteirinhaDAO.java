
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
import model.bo.Endereco;
import utilities.Utilities;

public class CarteirinhaDAO implements InterfaceDAO<Carteirinha>{

    @Override
    public void create(Carteirinha objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "insert into cantina.funcionario(nome, fone1, fone2, email, status, cpf, rg, dataNascimento, complementoEndereco, endereco_id, senha, usuario) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement pstm =null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            
            
            pstm.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm);
        }
    }

    @Override
    public List<Carteirinha> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Carteirinha retrieve(int parPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Carteirinha> retrieve(String parString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Carteirinha objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Carteirinha objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
