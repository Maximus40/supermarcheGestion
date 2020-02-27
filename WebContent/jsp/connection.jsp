<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="./css/style.css" />
<link type="text/css" rel="stylesheet" href="./css/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"> 
<jsp:include page="../jsp/nav.jsp" />
<title>TP JEE Gestion - Connexion</title>
</head>
<body>
<h2 class="txtAccueil">Se connecter</h2>
<c:if test="${(requestScope.erCo!= null)}">
<div class="alert alert-danger addAlert" role="alert"><c:out value="${requestScope.erCo}"/></div>
</c:if>
<c:if test="${(sessionScope.User != null)}">
<div class="alert alert-danger addAlert" role="alert">Vous êtes déja connecté</div>

</c:if>
<c:if test="${(sessionScope.User == null)}">
<form class="formCo" action="" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputUserName">Nom</label>
      <input type="text" class="form-control" id="inputUserName" name="inputUserName" required="required" placeholder="Nom">
    </div>
    <div class="form-group col-md-6">
      <label for="inputUserPasswd">Mot de passe</label>
      <input type="text" class="form-control" id="inputUserPasswd" name="inputUserPasswd" required="required" placeholder="Mot de passe">
    </div>
  </div>
    <button type="submit" class="btn btn-primary" name="btCo">Valider</button>
  
  </form>
  </c:if>
</body>
</html>