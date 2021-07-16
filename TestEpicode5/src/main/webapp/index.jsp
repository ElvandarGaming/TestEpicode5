<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

<link type="image/x-icon" href="./icon/BC112.png" rel="shortcut icon">

<meta charset="ISO-8859-1">
<title>HOME</title>
<style type="text/css">

body {
	font: bold 14px Verdana;
}

</style>
</head>

<body style="background-color: rgb(128, 128, 128)">
	<div style="text-align: center">
		<h1>Home</h1>
		<hr>
		<h3>Gestionale prodotti</h3>
		<hr>
		<form action="archivioFornitore.do">
			<input type="submit" value="Archivio Fornitore" />
		</form>
		<hr>
		<form action="archivioProdotto.do">
			<input type="submit" value="Archivio Prodotto" />
		</form>
		<hr>
	</div>
</body>

</html>