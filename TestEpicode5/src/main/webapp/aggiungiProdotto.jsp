<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.epicode.web.mvc.model.data.FornitoreDAO"%>
   <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<link type="image/x-icon" href="./icon/BC112.png" rel="shortcut icon">
<meta charset="ISO-8859-1">
<title>Aggiungi Prodotto</title>
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

         <form method="POST" action="inserisciProdotto.do">
      
		<input id ="id" type="text" name="id" ><label for="id">Id</label><br>
		<input id= "codiceProdotto" type="text" name="codiceProdotto" ><label for="codiceProdotto">Codice Prodotto</label><br>
		<input id = "nome"  type="text" name="nome" ><label for="nome">Nome</label><br>
		<input id= "descrizione" type="text" name="descrizione" ><label for="descrizione">Descrizione</label><br>
		<input id= "marca" type="text" name="marca" ><label for="marca">Marca</label><br>
		
				
		<label for="fornitore" id= "fornitore">Codice Fornitore</label>
		<select name="fornitore" id="fornitore">
   			
<%  FornitoreDAO x = new FornitoreDAO(); 
	List<String> codici = x.getAllCodici();
	
	for(String str: codici){
		out.print("<option value=\"");
		out.print(str);
		out.print("\">");
		out.print(str);
		out.print("</option>");
	}
		%>
  		</select><br>
		<input id= "prezzo" type="text" name="prezzo" value = "${prodUpdate.prezzo}"><label for="prezzo">Prezzo</label><br>
		
		<input type="submit" value="Conferma">

	</form>

<a href="homePage.do" class="button">Annulla</a>


</body>
</html>