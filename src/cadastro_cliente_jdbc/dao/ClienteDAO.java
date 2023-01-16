package cadastro_cliente_jdbc.dao;


import java.util.List;

import cadastro_cliente_jdbc.model.Cliente;

public interface ClienteDAO {
	
	public void salvar(Cliente cliente);

	public Cliente buscarPeloCodigo(Long codigo);

	public List<Cliente> buscarTodos();
}
