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
<title>TP JEE Gestion - Ajout</title>
</head>
<body>
<h2 class="txtAccueil">Ajout de produits</h2>
<c:if test="${(requestScope.er!= null)}">
<div class="alert alert-danger addAlert" role="alert"><c:out value="${requestScope.er}"/></div>
</c:if>

<c:if test="${(sessionScope.User == null)}">
<div class="alert alert-danger addAlert" role="alert">Vous devez être connecté</div>

</c:if>
<c:if test="${(sessionScope.User != null)}">
<form class="formAdd" action="" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputReference">Reference</label>
      <input type="text" class="form-control" id="inputReference" name="inputReference" required="required" placeholder="Reference">
    </div>
    <div class="form-group col-md-6">
      <label for="inputLibelle">Libelle</label>
      <input type="text" class="form-control" id="inputLibelle" name="inputLibelle" required="required" placeholder="Libelle">
    </div>
  </div>
  <div class="form-row">
  <div class="form-group col-md-6">
    <label for="inputPrixHT">Prix HT (€)</label>
    <input type="number" class="form-control" id="inputPrixHT" name="inputPrixHT" required="required" placeholder="Prix HT">
  </div>
  <div class="form-group col-md-6">
    <label for="inputTVA">TVA (%)</label>
    <input type="number" class="form-control" id="inputTVA" name="inputTVA" required="required" placeholder="TVA">
  </div>
  </div>
    <div class="form-group">
      <label for="inputCB">Code barre</label>
      <input type="number" class="form-control" id="inputCB" name="inputCB" required="required" placeholder="Code Barre">
    </div>
  <button type="submit" class="btn btn-primary" name="btAdd">Valider</button>
</form>
</c:if>
</body>
</html>