package br.com.caelum.jdbc.teste;

import java.sql.SQLException;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) throws SQLException {
		ContatoDao dao = new ContatoDao();

		Contato contato = dao.pesquisaId((long) 3);
		contato.setName("Ana Tania");

		ContatoDao daoAltera = new ContatoDao();
		daoAltera.altera(contato);
		
		System.out.println("Alterado");
	}

}
