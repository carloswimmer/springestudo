package br.com.caelum.jdbc.teste;

import java.sql.SQLException;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaPesquisa {

	public static void main(String[] args) throws SQLException {
		ContatoDao dao = new ContatoDao();
		Contato contato;
		
		contato = dao.pesquisaId((long) 2);
		
		System.out.println(contato.getId() + " | " + contato.getName() + " | " + contato.getEmail() +
					" | " + contato.getEndereco() + " | " + contato.getDataNascimento().getTime());
		
		
	}

}
