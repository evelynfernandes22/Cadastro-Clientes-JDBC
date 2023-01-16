package cadastro_cliente_jdbc.dao;

import cadastro_cliente_jdbc.jdbc.JdbcDAOFactory;
/**
 * Implementa a interface clienteDAO.
 * @author evelyn
 *
 */
public abstract class DAOFactory {
	
	public static DAOFactory pegarDAOFactory() {
		return new JdbcDAOFactory();
	}

	public abstract ClienteDAO pegarClienteDAO();
}
