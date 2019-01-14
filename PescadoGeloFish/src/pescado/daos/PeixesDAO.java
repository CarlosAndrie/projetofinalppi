package pescado.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pescado.models.Peixe;


public class PeixesDAO {

	private Connection connection;
	
	public PeixesDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean inserir(Peixe peixe) {

		String sql = "insert into peixe (nome, preco) " + "values (?, ?);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, peixe.getNome());
			stmt.setInt(2, peixe.getPreco());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	public List<Peixe> getLista() {
		List<Peixe> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from peixe");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Peixe peixe = new Peixe();
				peixe.setNome(rs.getString("nome"));
				peixe.setPreco(rs.getInt("id"));
				result.add(peixe);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Peixe getLivroById(long id) {
		Peixe peixe = new Peixe();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from peixe where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				peixe.setNome(rs.getString("nome"));
				peixe.setPreco(rs.getInt("preco"));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peixe;
	}
	public boolean atualizar(Peixe peixe) {
		String sql = "update peixe set nome=?, preco=?" + "where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, peixe.getNome());
			stmt.setInt(2, peixe.getPreco());
			stmt.setLong(3, peixe.getId());

			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean remover(Peixe peixe) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete" + "from peixe where id=?");
			stmt.setLong(1, peixe.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Peixe getPeixesById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
