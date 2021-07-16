<%@page import="it.epicode.web.mvc.model.Fornitore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link type="image/x-icon" href="./icon/BC112.png" rel="shortcut icon">

<meta charset="ISO-8859-1">
<title>Archivio fornitori</title>
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


<table style="width:100%">
 <caption>Lista Fornitori</caption>
  <tr>
    <th>Id</th>
    <th>Codice Fornitore</th>
    <th>Nome</th>
    <th>Indirizzo</th>
    <th>Citta</th>
    <th>Modifica</th>
    <th>Elimina</th>
  </tr>

	<c:forEach items="${LISTA_FORNITORI}" var="fornitore">
  <tr>
    <th>${fornitore.id}</th>
    <th>${fornitore.codiceFornitore}</th>
    <th>${fornitore.nome}</th>
    <th>${fornitore.indirizzo}</th>
    <th>${fornitore.citta}</th>
    <th><a href="showmodificafornitore.do?id=${fornitore.id}" class="button">Modifica</a></th>
     <th><a href="deleteFornitore.do?id=${fornitore.id}" class="button">Elimina</a></th>
  </tr>
  </c:forEach>
</table>
	
	
<hr>
<div style="text-align: center">
<a href="showInserisciFornitore.do" class="button">Aggiungi Fornitore</a>
</div>

</body>
</html>