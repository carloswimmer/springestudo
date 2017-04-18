package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) throws SQLException {
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = new ArrayList<Contato>();
		
		contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println(contato.getId() + " | " + contato.getName() + " | " + contato.getEmail() +
					" | " + contato.getEndereco() + " | " + contato.getDataNascimento().getTime());
		}
		
	}

}
