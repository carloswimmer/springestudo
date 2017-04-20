package br.com.caelum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novoContato")
public class NovoContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1375435961736262496L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/adiciona-contato.jsp").forward(request, response);
	}
}
