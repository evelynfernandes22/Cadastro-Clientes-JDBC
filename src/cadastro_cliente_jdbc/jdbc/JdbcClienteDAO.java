package cadastro_cliente_jdbc.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cadastro_cliente_jdbc.dao.ClienteDAO;
import cadastro_cliente_jdbc.dao.DAOException;
import cadastro_cliente_jdbc.model.Cliente;

public class JdbcClienteDAO implements ClienteDAO {
	
	private Connection connection;
		
	public JdbcClienteDAO(Connection connection) {
		this.connection = connection;
	}


	@Override
	public void salvar(Cliente cliente) {
		try {
			String sql = String.format("insert into cliente (nome) values ('%s')", cliente.getNome());
			
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new DAOException("Erro salvando cliente", e);
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public Cliente buscarPeloCodigo(Long codigo) {
		Cliente cliente = null;

		try {
			String sql = String.format(
					"select * from cliente where codigo = %d", codigo);
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
			}

		} catch (SQLException e) {
			throw new DAOException("Erro buscando cliente", e);
		} finally {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}

		return cliente;
	}


	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			String sql = "Select * from cliente";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getLong("codigo"));
				cliente.setNome(rs.getString("nome"));
				
				clientes.add(cliente);
			}
					
		} catch (SQLException e) {
			throw new DAOException("Erro buscando cliente", e);
		}finally {
			try {
				this.connection.close();
			} catch (Exception e) {}
		}
		return clientes;
	}


	
}
