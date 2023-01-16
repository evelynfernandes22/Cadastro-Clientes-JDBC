package cadastro_cliente_jdbc;

import java.util.List;

import cadastro_cliente_jdbc.dao.ClienteDAO;
import cadastro_cliente_jdbc.dao.DAOFactory;
import cadastro_cliente_jdbc.model.Cliente;

public class BuscaTodosClientes {

	public static void main(String[] args) {

		ClienteDAO clienteDAO = DAOFactory.pegarDAOFactory().pegarClienteDAO();
		
		List<Cliente> clientes = clienteDAO.buscarTodos();
		
		for(Cliente cliente: clientes) {
			System.out.println("----------- Cliente ----------");
			System.out.printf("Código: %d\n", cliente.getCodigo());
			System.out.printf("Nome: %s\n", cliente.getNome());
			System.out.println();
		}
	}

}
