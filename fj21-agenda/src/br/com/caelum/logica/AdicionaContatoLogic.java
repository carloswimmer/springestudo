package br.com.caelum.logica;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class AdicionaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PrintWriter out = response.getWriter();
		Contato contato = new Contato();
		
		contato.setName(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		
		String idTexto = request.getParameter("id");
		
		String dataTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
			
			contato.setDataNascimento(dataNascimento);
			
		} catch (ParseException e) {
			out.println("<h1>Houve problema para converter a data</h1>");
		}
		
		Connection cf = (Connection) request.getAttribute("connection");
		ContatoDao dao = new ContatoDao(cf);
		
		try {
			if(idTexto.isEmpty()) {
				dao.adiciona(contato);	
				
				cf.close();
				
				return "/WEB-INF/jsp/contato-adicionado.jsp";
			} else {
				contato.setId(Long.parseLong(idTexto));
				dao.altera(contato);
				
				cf.close();
				
				return "/WEB-INF/jsp/contato-alterado.jsp";
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
