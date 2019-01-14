<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de peixes</title>
</head>
<body>

		<table border="2">
		<h1>Lista de Livros</h1>
		<tr>
			<th>Nome</th>
			<th>Preco</th>
		</tr>
		
		<c:forEach var="peixe" items="${peixes}">

			<tr>
				<td>${peixe.nome}</td>
				<td>${peixe.preco}</td>
				
<%-- 				<td> <a href="servico?comandos=RemoverLivro&id=${livro.id }" >Remover</a></td> --%>
<%-- 				<td> <a href="servico?comandos=AlterarLivro&id=${livro.id }" >Alterar</a></td> --%>
<%-- 				<td> <a href="Venda.jsp?nome=${peixe.nome }&idPeixe=${peixe.id }" >Vender</a></td> --%>
			</tr>
			
		</c:forEach>

</body>
</html>