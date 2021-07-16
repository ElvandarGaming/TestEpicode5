<%@page import="it.epicode.web.mvc.model.Fornitore"%>
<%@page import="it.epicode.web.mvc.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link type="image/x-icon" href="./icon/BC112.png" rel="shortcut icon">

<meta charset="ISO-8859-1">
<title>Archivio prodotti</title>
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
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  text-align: left;
   background-color: #eee;
}


</style>
</head>
<body  style="background-color: rgb(128, 128, 128)">

	<%
	List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("LISTA_PRODOTTI");
		out.print("<table style=\"width:100%\">");
		out.print("<caption>Lista Prodotti</caption>");
		out.print("<tr>");
		out.print("<th>Id</th>");
		out.print("<th>Codice Prodotto</th>");
		out.print("<th>Nome</th>");
		out.print("<th>Descrizione</th>");
		out.print("<th>Marca</th>");
		out.print("<th>Codice Fornitore</th>");
		out.print("<th>Prezzo</th>");
		out.print("<th>Modifica</th>");
		out.print("<th>Elimina</th>");
	
		out.print("</tr>");
		
	for (Prodotto prod : prodotti) {
		
		out.print("<tr>");
		out.print("<th>"+prod.getId()+"</th>");
		out.print("<th>"+prod.getCodiceProdotto()+"</th>");
		out.print("<th>"+prod.getNome()+"</th>");
		out.print("<th>"+prod.getDescrizione()+"</th>");
		out.print("<th>"+prod.getMarca()+"</th>");
		out.print("<th>"+prod.getFornitore().getCodiceFornitore()+"</th>");
		out.print("<th>"+prod.getPrezzo()+"</th>");
		out.print("<th>");
		out.print("<a href=\"showmodificaprodotto.do?id=");
		out.print(prod.getId());
		out.print("\" class=\"button\">Modifica</a>");
		out.print("</th>");
		
		out.print("<th>");
		out.print("<a href=\"deleteprodotto.do?id=");
		out.print(prod.getId());
		out.print("\" class=\"button\">Elimina</a>");
		out.print("</th>");
		
		
		out.print("</tr>");
	}
	out.print("</table>");
	%>

	
	
<hr>
<div style="text-align: center">
<a href="showinserisciprodotto.do" class="button">Aggiungi Prodotto</a>
<a href="homePage.do" class="button">HOME</a>
</div>

</body>
</html>