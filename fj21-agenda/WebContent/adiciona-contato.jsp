<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="wimmer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Agenda</title>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<style type="text/css">
form {
	margin: 5px;
}

input {
	margin: 5px;
}
</style>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<div align="center">
		<form action="adicionaContato" method="post" >
			<wimmer:campoTexto label="Nome" id="nome"></wimmer:campoTexto><br />
			<wimmer:campoTexto label="Email" id="email"></wimmer:campoTexto><br />
			<wimmer:campoTexto label="Endereco" id="endereco"></wimmer:campoTexto><br />
			Data Nascimento <wimmer:campoData id="dataNascimento" /><br />
			
			<input type="submit" value="Gravar" />
	    </form>
    </div>
    <c:import url="rodape.jsp"></c:import>
</body>
</html>