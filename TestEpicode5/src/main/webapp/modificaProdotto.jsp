<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<link type="image/x-icon" href="./icon/BC112.png" rel="shortcut icon">
<meta charset="ISO-8859-1">
<title>Modifica Prodotto</title>
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
<body style="background-color: rgb(128, 128, 128)">

         <form method="POST" action="updateProdotto.do">
      
		<input <c:if test = "${!empty prodUpdate}">readonly</c:if> id ="id" type="text" name="id" value = "${prodUpdate.id}"><label for="id">Id</label><br>
		<input id= "codiceProdotto" type="text" name="codiceProdotto" value = "${prodUpdate.codiceProdotto}"><label for="codiceProdotto">Codice Prodotto</label><br>
		<input id = "nome"  type="text" name="nome" value = "${prodUpdate.nome}"><label for="nome">Nome</label><br>
		<input id= "descrizione" type="text" name="descrizione" value = "${prodUpdate.descrizione}"><label for="descrizione">Descrizione</label><br>
		<input id= "marca" type="text" name="marca" value = "${prodUpdate.marca}"><label for="marca">Marca</label><br>
		<input <c:if test = "${!empty prodUpdate}">readonly</c:if> id= "fornitore" type="text" name="fornitore" value = "${xxx}"><label for="fornitore">Codice Fornitore</label><br>
		<input id= "prezzo" type="text" name="prezzo" value = "${prodUpdate.prezzo}"><label for="prezzo">Prezzo</label><br>
		
		<input type="submit" value="Conferma">

	</form>
	
	<a href="homePage.do" class="button">Annulla</a>

</body>
</html>