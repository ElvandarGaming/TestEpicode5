<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<link type="image/x-icon" href="./icon/BC112.png" rel="shortcut icon">
<meta charset="ISO-8859-1">
<title>Aggiungi Fornitore</title>
<style type="text/css">
.button {
	font: bold 11px Arial;
	text-decoration: none;
	background-color: #EEEEEE;
	color: #333333;
	padding: 2px 6px 2px 6px;
	border-top: 1px solid #CCCCCC;
	border-right: 1px solid #333333;
	border-bottom: 1px solid #333333;
	border-left: 1px solid #CCCCCC;
}

body {
	font: bold 11px Verdana;
}
</style>
</head>
<body  style="background-color: rgb(128, 128, 128)">

         <form method="POST" action="inserisciFornitore.do">
      
		<input <c:if test = "${!empty fornUpdate}">readonly</c:if> id ="id" type="text" name="id" value = "${fornUpdate.id}"><label for="id">Id</label><br>
		<input id= "codiceFornitore" type="text" name="codiceFornitore" value = "${fornUpdate.codiceFornitore}"><label for="codiceFornitore">Codice Fornitore</label><br>
		<input id = "nome"  type="text" name="nome" value = "${fornUpdate.nome}"><label for="nome">Nome</label><br>
		<input id= "indirizzo" type="text" name="indirizzo" value = "${fornUpdate.indirizzo}"><label for="indirizzo">Indirizzo</label><br>
		<input id= "citta" type="text" name="citta" value = "${fornUpdate.citta}"><label for="citta">Città</label><br>
		
		<input type="submit" value="Conferma">

	</form>

<a href="homePage.do" class="button">Annulla</a>








</body>
</html>