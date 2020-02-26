<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<title>navbar</title>
</head>
<body>
 <ul>
  <li><a href="default.asp">Accueil</a></li>
    <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Articles</a><div class="arrow-down"></div>
    <div class="dropdown-content">
      <a href="#">Ajouter</a>
      <a href="#">Modifier</a>
      <a href="#">Supprimer</a>
    </div>
  </li>
  <li style="float:right"><a href="connection.asp">Se connecter</a></li>
</ul> 
</body>
</html>