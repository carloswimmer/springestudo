<%@page import="java.text.SimpleDateFormat,
		java.util.*,
    	br.com.caelum.modelo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"></jsp:useBean>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela de Contatos</title>
<style type="text/css">
thead {
	font-size: 1.5em;
	text-align: center;
}
body {
	max-height:80%;
    position:relative;
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
	<c:import url="cabecalho.jsp"></c:import>
	<table align="center">
		<thead>
			<tr>
				<td>Nome</td>
				<td>Email</td>
				<td>Endereco</td>
				<td>Nascimento</td>
			</tr>
		</thead>
		<c:forEach items="${dao.lista}" var="contato" varStatus="id">
			<tbody>
				<tr bgcolor="#${id.count % 2 == 0 ? 'fff' : 'ddd' }">
					<td>${contato.name}</td>
					<td>
						<c:choose>
							<c:when test="${!empty contato.email}">
								<a href="mailto:${contato.email}">${contato.email}</a>
							</c:when>
							<c:otherwise>
								Nao informado
							</c:otherwise>
						</c:choose>
					</td>
					<td>${contato.endereco}</td>
					<td align="center"><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
				</tr>		
			</tbody>
		</c:forEach>
		<tfoot>
			<tr>
				<td colspan="4">
					<form action="<c:url value='adiciona-contato.jsp' />">
						<input type="submit" value="Novo Contato">
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
	<br>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>