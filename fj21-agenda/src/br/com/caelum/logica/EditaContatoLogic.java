package br.com.caelum.logica;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class EditaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long id = Long.parseLong(request.getParameter("id"));
		
		ContatoDao dao = new ContatoDao();
		Contato contato = new Contato();
		
		contato = dao.pesquisaId(id);
		String dataNascimento = new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime());
		request.setAttribute("contato", contato);
		request.setAttribute("dataNascimento", dataNascimento);
		
		return "/WEB-INF/jsp/edita-contato.jsp";
	}

}
