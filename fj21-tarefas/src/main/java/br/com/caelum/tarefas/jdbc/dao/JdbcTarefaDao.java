package br.com.caelum.tarefas.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.tarefas.jdbc.ConnectionFactory;
import br.com.caelum.tarefas.model.Tarefa;

public class JdbcTarefaDao {
	private Connection connection;
	
	public JdbcTarefaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public JdbcTarefaDao(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona(Tarefa tarefa) {
		String sql = "INSERT INTO tarefas (descricao) VALUE (?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tarefa.getDescricao());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<Tarefa> lista() {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		String sql = "SELECT * FROM tarefas";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
//				Calendar data = Calendar.getInstance();
//				data.setTime(rs.getDate("dataFinalizacao"));
//				tarefa.setDataFinalizacao(data);
				
				tarefas.add(tarefa);
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 		
		
		return tarefas;
	}
	
	public void remove(Tarefa tarefa) {
		String sql = "DELETE FROM tarefas WHERE id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, tarefa.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
				
	}

	public Tarefa buscaPorId(Long id) {
		String sql = "SELECT * FROM tarefas WHERE id=?";
		Tarefa tarefa = null;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
			}
			
			rs.close();
			stmt.close();
			
			return tarefa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void altera(Tarefa tarefa) {
		String sql = "UPDATE tarefas SET descricao=?, finalizado=? WHERE id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setLong(3, tarefa.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
