package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi",
		initParams = @WebInitParam(name = "cor", value = "azul"))
public class OiMundo extends HttpServlet {
	private static final long serialVersionUID = 3426823051573616673L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Primeira Servlet</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>Oi mundo " + getServletConfig().getInitParameter("cor") + " Servlet!</h1>");
	    out.println("</body>");
	    out.println("</html>");
	    
	    out.close();

	}

}
