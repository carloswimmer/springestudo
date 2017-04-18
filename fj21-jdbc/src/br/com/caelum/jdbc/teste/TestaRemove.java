package br.com.caelum.jdbc.teste;

import java.sql.SQLException;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaRemove {

	public static void main(String[] args) throws SQLException {
		ContatoDao dao = new ContatoDao();

		Contato contato = dao.pesquisaId((long) 3);

		ContatoDao daoRemove = new ContatoDao();
		daoRemove.remove(contato);
		
		System.out.println("Removido");
	}

}
