package br.com.caelum.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class ListaContatosLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection cf = (Connection) request.getAttribute("connection");
		List<Contato> contatos = new ContatoDao(cf).getLista();
		
		request.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}

}
