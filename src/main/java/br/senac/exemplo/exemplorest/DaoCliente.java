package br.senac.exemplo.exemplorest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoCliente {
		
    public Cliente inserir(Cliente cliente) throws Exception {
    	
        String sql = "INSERT INTO cliente (nome, cpf) "
                + " VALUES (?, ? )";
        
        try (Connection con = DB.connect();
            	PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            
            ps.execute();
            
            ResultSet gkeys = ps.getGeneratedKeys();
            
            if (gkeys.next()) {
                cliente.setId(gkeys.getInt(1));
            }
            
        }
        
        return cliente;
    }

    public Cliente atualizar(Cliente cliente) throws Exception {
        
        String sql = "UPDATE cliente SET nome=?, cpf=? "
            + "WHERE cliente_id=?";
        
        try (Connection con = DB.connect();
            	PreparedStatement ps = con.prepareStatement(sql)) {
            
        	ps.setString(1, cliente.getNome());
        	ps.setString(2, cliente.getCpf());
        	ps.setInt(3, cliente.getId());
            
        	ps.execute();
            
        }
        
        return cliente;
    }

    public void excluir(Integer id) throws Exception {
    	
        String sql = "DELETE FROM cliente WHERE cliente_id=?";
        
        try (Connection con = DB.connect();
            	PreparedStatement ps = con.prepareStatement(sql)) {
            
        	ps.setInt(1, id);
            
        	ps.execute();
            
        }        
    }

    public List<Cliente> listar() throws Exception {
    	
        String sql = "SELECT * FROM cliente";   
        
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        
        try (Connection con = DB.connect();
            	PreparedStatement ps = con.prepareStatement(sql)) {
            
        	ResultSet result = ps.executeQuery();
            
            while (result.next()) {                
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("cliente_id"));
                cliente.setNome(result.getString("nome"));
                cliente.setCpf(result.getString("cpf"));
                
                listaClientes.add(cliente);                
            }
            
        }
        
        return listaClientes;
        
    }

    public List<Cliente> procurar(String valor) throws Exception {
    	
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        
        try (Connection con = DB.connect();
            	PreparedStatement ps = con.prepareStatement(sql)) {
            
        	ps.setString(1, "%" + valor + "%");
            
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {                
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("cliente_id"));
                cliente.setNome(result.getString("nome"));
                cliente.setCpf(result.getString("cpf"));
                
                listaClientes.add(cliente);                
            }
            
        }
        
        return listaClientes;
        
    }

    public Cliente obter(Integer id) throws Exception {
    	
        String sql = "SELECT * FROM cliente WHERE cliente_id=?";
        
        try (Connection con = DB.connect();
            	PreparedStatement ps = con.prepareStatement(sql)) {
        	ps.setInt(1, id);
            
            ResultSet result = ps.executeQuery();
            
            if (result.next()) {            	
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("cliente_id"));
                cliente.setNome(result.getString("nome"));
                cliente.setCpf(result.getString("cpf"));
                
                return cliente;                
            }
            
        }

        return null;        
    }
    
}