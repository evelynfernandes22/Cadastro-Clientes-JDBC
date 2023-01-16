package cadastro_cliente_jdbc;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cadastro_cliente_jdbc.dao.ClienteDAO;
import cadastro_cliente_jdbc.dao.DAOFactory;
import cadastro_cliente_jdbc.model.Cliente;

public class SalvaCliente {

	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		Cliente cliente = new Cliente();
		
		String nome = JOptionPane.showInputDialog(null,"Nome do Cliente", "Cadastro de Cliente", JOptionPane.QUESTION_MESSAGE);
		if(nome != null) {
			cliente.setNome(nome);
			
			ClienteDAO clienteDAO = DAOFactory.pegarDAOFactory().pegarClienteDAO();
			clienteDAO.salvar(cliente);
			System.out.println("Cliente salvo com sucesso.");
		}
		
	}

}
