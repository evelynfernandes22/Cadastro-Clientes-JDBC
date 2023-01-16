package cadastro_cliente_jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cadastro_cliente_jdbc.dao.ClienteDAO;
import cadastro_cliente_jdbc.dao.DAOFactory;
/**
 * Classe onde faz a conexão com o banco
 * @author evelyn
 *
 */
public class JdbcDAOFactory extends DAOFactory {

	private Connection connection;
	
	public JdbcDAOFactory() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/cadastro-cliente-tst", "root", "mysql");
		} catch (Exception e) {
			throw new RuntimeException("Erro recuperando conexão com o banco", e);
		} 
		
	}

	@Override
	public ClienteDAO pegarClienteDAO() {
		return new JdbcClienteDAO(connection);
	}
}
