<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp"></c:import>
	<div align="center">
		Contato ${param.nome} adicionado com sucesso...<br />
		<form action="/fj21-agenda/mvc">
			<input type="hidden" name="logica" value="ListaContatosLogic">
			<input type="submit" value="Lista Contatos">
		</form>
	</div>
<c:import url="rodape.jsp"></c:import>
</body>
</html>