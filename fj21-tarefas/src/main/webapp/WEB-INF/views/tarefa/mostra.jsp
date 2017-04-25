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
	<h3><a href="listaTarefas">Altera tarefa</a></h3>
	<form action="alteraTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id}" /> 
		Descricao <br>
		<textarea name="descricao" cols="50" rows="5" value="${tarefa.descricao}">${tarefa.descricao}</textarea><br />
		Finalizado <input type="checkbox" name="finalizado" value="${tarefa.finalizado ? 'checked' : ''}" /><br />
		<input type="submit" value="Gravar">
	</form>
	
</body>
</html>