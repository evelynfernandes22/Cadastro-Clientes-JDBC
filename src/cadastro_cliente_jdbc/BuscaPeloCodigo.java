package cadastro_cliente_jdbc;

import cadastro_cliente_jdbc.dao.ClienteDAO;
import cadastro_cliente_jdbc.dao.DAOFactory;
import cadastro_cliente_jdbc.model.Cliente;

public class BuscaPeloCodigo {

	public static void main(String[] args) {
		
	ClienteDAO clienteDAO = DAOFactory.pegarDAOFactory().pegarClienteDAO();

	Cliente cliente = clienteDAO.buscarPeloCodigo(2L);
	
	if (cliente != null) {
		System.out.println("------ Cliente encontrado ------");
		System.out.printf("Código: %d\n", cliente.getCodigo());
		System.out.printf("Nome: %s\n", cliente.getNome());
		System.out.println();
	} else {
		System.out.println("Nenhum cliente encontrado.");
	}
}
}
