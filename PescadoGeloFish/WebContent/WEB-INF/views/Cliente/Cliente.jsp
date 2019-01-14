<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar cliente</title>
</head>
<body>
<form action="servico" id="formulario">

		<h2>Adicionar aluno:</h2>
		<label>Nome </label> <input type="text" name="nome" maxlength="11" value="${cliente.nome }"/><br/>
		<label>RG </label> <input type="text" name="rg" maxlength="11" value="${cliente.rg }"/><br/>
		<label>Endereço </label> <input type="text" name="endereco" maxlength="11" value="${cliente.endereco }"/><br/>
		<label>Data de Nascimento: </label> <input type="text" name="dataNascimento" value="<fmt:formatDate value='${aluno.dataNascimento.time }' pattern='dd/MM/yyyy'/>" /><br/>
		<label>Login </label> <input type="text" name="login" maxlength="11" value="${cliente.login }"/><br/>

		<input type="hidden" name="comandos" value="AdicionarCliente">
		<c:choose>
			<c:when test="${not empty cliente}">
				<input type="hidden" name="id" value="${cliente.id }">
			</c:when>
		</c:choose>
		<button type="submit">Adicionar Cliente</button>
	</form>
	<br/>
	<form action="servico">
		<input type="hidden" name="comandos" value="BuscarCliente">
		<button type="submit">Listar Todos</button>
		
	</form>

</body>
</html>