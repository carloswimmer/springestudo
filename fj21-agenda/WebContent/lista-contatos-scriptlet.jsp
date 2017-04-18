<%@page import="java.text.SimpleDateFormat,
		java.util.*,
    	br.com.caelum.jdbc.dao.*,
    	br.com.caelum.modelo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela de Contatos</title>
<style type="text/css">
thead {
	font-size: 1.5em;
}
td {
	border-bottom-style: solid;
	border-bottom-width: 1px;
	border-color: gray;
}
td {
	padding: 5px;
}	
tfoot {
	text-align: center;
}
</style>
</head>
<body>
	<table align="center">
		<thead>
			<tr>
				<td>Nome</td>
				<td>Email</td>
				<td>Endereco</td>
				<td>Data de Nascimento</td>
			</tr>
		</thead>
		<% 
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			
			for(Contato contato : contatos) {
		%>
				<tbody>
					<tr>
						<td><%= contato.getName() %></td>
						<td><%= contato.getEmail() %></td>
						<td><%= contato.getEndereco() %></td>
						<td><%= new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento()
								.getTime()) %></td>
					</tr>		
				</tbody>
		<%
			}
		%>
		<tfoot>
			<tr>
				<td colspan="4">
					<a href="/fj21-agenda/adiciona-contato.html">Novo Contato</a>
				</td>
			</tr>
		</tfoot>
	</table>
	<br>
</body>
</html>