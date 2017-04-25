<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarefas FJ21</title>
</head>
<body>
	<h3><a href="novaTarefa">Nova tarefa</a></h3>
	<table>
		<thead>
			<tr>
				<td>Id</td>
				<td>Descricao</td>
				<td>Finalizado</td>
				<td>&nbsp;</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tarefas}" var="tarefa">
				<tr>
					<td>${tarefa.id}</td>
					<td>${tarefa.descricao}</td>
					<td>${tarefa.finalizado}</td>
					<td><a href="removeTarefa?id=${tarefa.id}" >Deletar</a></td>
					<td><a href="mostraTarefa?id=${tarefa.id}" >Alterar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>