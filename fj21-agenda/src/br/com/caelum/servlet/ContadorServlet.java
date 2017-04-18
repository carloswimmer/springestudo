package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class ContadorServlet extends HttpServlet {

	private static final long serialVersionUID = 6926558076895488358L;

	int contador = 0;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Servlet iniciado!");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Servlet destruido!");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contador ++;
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
        out.println("<body>");
        out.println("Contador agora é: " + contador);
        out.println("</body>");
        out.println("</html>");
        
        destroy();
	}
}
