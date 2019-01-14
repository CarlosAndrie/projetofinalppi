package pescado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pescado.models.Cliente;

public class ClienteDAO{

	private Connection connection;
	
	public ClienteDAO() {
		connection = ConnectionFactory.getConnection();
	}
	public boolean inserir(Cliente cliente) {
		
		String sql = "insert into clientes (rg, endereco, dataNascimento, nome, login, senha)" + "values(?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cliente.getRg());
			stmt.setString(2, cliente.getEndereco());
			stmt.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(4, cliente.getNome());
			stmt.setString(5, cliente.getLogin());
			stmt.setString(6, cliente.getSenha());
		} catch (SQLException e){
			//Reparar erro
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	public boolean atualizar(Cliente cliente) {

		String sql = "update clientes set rg=?, endereco=?, dataNascimento=?, nome=?, login=?, senha=? where id = ?";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cliente.getRg());
			stmt.setString(2, cliente.getEndereco());
			stmt.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(4, cliente.getNome());
			stmt.setString(5, cliente.getLogin());
			stmt.setString(6, cliente.getSenha());
			stmt.setLong(7, cliente.getId());
			stmt.execute();
			stmt.close();
			
		
		} catch (SQLException e){
			//Reparar erro
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<Cliente> getLista() {
		List<Cliente> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setRg(rs.getString("rg"));
				cliente.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				cliente.setDataNascimento(data);
				cliente.setNome(rs.getString("nome"));
				cliente.setLogin(rs.getString("login"));

				result.add(cliente);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Cliente getAlunoById(long id) {
		Cliente cliente = new Cliente();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				cliente.setRg(rs.getString("rs"));
				cliente.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				cliente.setDataNascimento(data);
				cliente.setNome(rs.getString("nome"));
				cliente.setLogin(rs.getString("login"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	public boolean remover(Cliente cliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from Clientes where id=?");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
