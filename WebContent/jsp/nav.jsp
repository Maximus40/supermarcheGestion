<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="./css/style.css" />

<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css" />
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<title>TP JEE Gestion</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand">Gestion commerce</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="./listArticle">Accueil<span class="sr-only">(current)</span></a>
      </li>
      <c:if test="${(sessionScope.User != null)}">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Articles
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="./addArticle">Ajouter</a>
          <a class="dropdown-item" href="./upArticle">Modifier</a>
          <a class="dropdown-item" href="./delArticle">Supprimer</a>
        </div>
      </li>
      </c:if>
      <li class="nav-item">
        <a class="nav-link" href="./panier">Panier</a>
      </li>
    </ul>
       <c:if test="${(sessionScope.User != null)}">
         <div class="txtConnecter">Connecté en tant que <c:out value="${sessionScope.User}" /></div>
         <a class="nav-link" style="color:white;" href="./deconnection">Se deconnecter</a>
       </c:if>
       <c:if test="${(sessionScope.User == null)}">
        <a class="nav-link" style="color:white;" href="./connection">Se connecter</a>
        </c:if>
      
    
  </div>
</nav>
</body>
</html>