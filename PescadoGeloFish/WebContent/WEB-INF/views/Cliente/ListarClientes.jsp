<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de clientes</title>
</head>
<body>

		<table border="2">
		<h1>Lista de clientes</h1>
		<tr>
			<th>Nome</th>
			<th>RG</th>
			<th>Endereco</th>
			<th>Data de Nascimento</th>
			<th>Login</th>
		</tr>
		
		<c:forEach var="cliente" items="${clientes}">

			<tr>
				<td>${cliente.nome}</td>
				<td>${cliente.rg}</td>
				<td>${cliente.endereco}</td>
				<td><fmt:formatDate value="${cliente.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
				
<%-- 				<td> <a href="servico?comandos=RemoverAluno&id='${aluno.id }'">Remover</a></td> --%>
<%-- 				<td> <a href="servico?comandos=AlterarAluno&id='${aluno.id }'">Alterar</a></td> --%>
			</tr>
			
		</c:forEach>

</body>
</html>