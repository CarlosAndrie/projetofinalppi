<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar peixes</title>
</head>
<body>

	<div id="formulario">
	<h2>Cadastrar peixe: </h2>
	<form action="servico">
		<label>Nome </label> <input type="text" name="nome" value="${peixe.nome }"/><br/>
		<label>Preço </label> <input type="text" name="preco" value="${cliente.preco }"/><br/>
		<input type="hidden" name="comandos" value="AdicionarPeixe">
		<c:choose>
			 <c:when test="${not empty peixe}">
			 <input type="hidden" name="id" value="${peixe.id }">
			</c:when>
		</c:choose>
		<button type="submit">Adicionar peixe</button>
	</form>
	
	<div id="busca">
		<h2>Buscar peixe:</h2>
		<form action="servico">
			<input type="text" name="nome" placeholder="Nome...">
			<input type = "hidden" value="BuscarPeixe">
			<br><br><br>
			<button type="enviar">Pesquisar</button>
		</form>
		<br><br>
		
		<form action="servico">
    		<input type = "hidden" name="comandos" value="BuscarPeixe">
    		<button type="submit" >Listar Todos</button>
		</form>
		
		<br>
	</div>
	
</body>
</html>