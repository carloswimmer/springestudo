package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection con;

	public ContatoDao() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) throws SQLException {
		String sql = "INSERT INTO contatos" + " (nome, email, endereco, dataNascimento)" + " VALUES(?, ?, ?, ?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, contato.getName());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
	}

	public List<Contato> getLista() throws SQLException {
		try {
			List<Contato> contatos = new ArrayList<Contato>();

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}
			rs.close();
			stmt.close();

			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}

	}

	public Contato pesquisaId(Long id) throws SQLException {
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM contatos WHERE id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			Contato contato = new Contato();

			while (rs.next()) {
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}

			rs.close();
			stmt.close();

			return contato;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}

	}

	public void altera(Contato contato) throws SQLException {

		String sql = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, contato.getName());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
	}

	public void remove(Contato contato) throws SQLException {

		String sql = "DELETE FROM contatos WHERE id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
	}
}
