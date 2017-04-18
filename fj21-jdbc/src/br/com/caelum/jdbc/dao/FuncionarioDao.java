package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {

	private Connection con;

	public FuncionarioDao() {
		con = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario funcionario) throws SQLException {
		String sql = "INSERT INTO funcionarios (nome, usuario, senha) VALUES (?, ?, ?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
	}
}
