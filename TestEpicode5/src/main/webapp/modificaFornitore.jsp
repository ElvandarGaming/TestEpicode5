<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<link type="image/x-icon" href="./icon/BC112.png" rel="shortcut icon">
<meta charset="ISO-8859-1">
<title>Modifica Fornitore</title>
</head>
<body>

         <form method="POST" action="updateFornitore.do">
      
		<input <c:if test = "${!empty fornUpdate}">readonly</c:if> id ="id" type="text" name="id" value = "${fornUpdate.id}"><label for="id">Id</label><br>
		<input id= "codiceFornitore" type="text" name="codiceFornitore" value = "${fornUpdate.codiceFornitore}"><label for="codiceFornitore">Codice Fornitore</label><br>
		<input id = "nome"  type="text" name="nome" value = "${fornUpdate.nome}"><label for="nome">Nome</label><br>
		<input id= "indirizzo" type="text" name="indirizzo" value = "${fornUpdate.indirizzo}"><label for="indirizzo">Indirizzo</label><br>
		<input id= "citta" type="text" name="citta" value = "${fornUpdate.citta}"><label for="citta">Città</label><br>
		
		<input type="submit" value="Conferma">

	</form>










</body>
</html>