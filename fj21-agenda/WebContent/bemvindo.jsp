<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<c:import url="/cabecalho.jsp"></c:import>
		<div align="center">
		<%-- comentario em JSP aqui: nossa primeira pagina em JSP --%>
		<%
			String message = "Bem vindo ao sistema de agenda do FJ-21!";
		%>
		<% out.println(message); %>
		<br>
		<% 
			String autor = "Desenvolvido por FranzFerdinant";
		%>
		<%= autor %>
			<div  style="padding: 10px">
				<form action="/fj21-agenda/lista-contatos.jsp">
					<input type="submit" value="Lista Contatos" />
				</form>
			</div>
		</div>
	<c:import url="/rodape.jsp"></c:import>
</body>
</html>