package br.com.caelum.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class RemoveContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		Connection cf = (Connection) request.getAttribute("connection");
		
		ContatoDao dao = new ContatoDao(cf);
		dao.remove(contato);
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
