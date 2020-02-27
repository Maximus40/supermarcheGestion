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
<h2 class="txtAccueil">Panier</h2>
<c:if test="${(requestScope.erPanier!= null)}">
<div class="alert alert-danger addAlert" role="alert"><c:out value="${requestScope.erPanier}"/></div>

</c:if>
<form class="formAddPanier" action="" method="post">
<div class="form-groupPanier">
      <label for="inputCBPanier"></label>
      <input type="number" class="form-control" id="inputCBPanier" name="inputCBPanier" required="required" placeholder="Code Barre">
        <button type="submit" class="btn btn-primary btPanier" name="btAddPanier">Valider</button>
    </div>
    </form>
    <c:if test="${(sessionScope.listPanier!= null)}">
    <div class="totalTTC"><B>Total TTC : <c:out value="${requestScope.totalTTC}"></c:out> €</B></div>
    <div class="totalTTC"><B>Total TVA : <c:out value="${requestScope.totalTVA}"></c:out> €</B></div>
    
    <table class="table">
 <tr>
        <th scope="col">Libelle</th>
        <th scope="col">References</th>
        <th scope="col">Prix TTC</th>
        <th scope="col">TVA</th>
        <th scope="col">Code barre</th>
        <th></th>
    </tr>
<c:forEach items="${sessionScope.listPanier}" var="item">
<tr>
  <td scope="row"><c:out value="${item.libelle}" /></td>
  <td><c:out value="${item.reference}" /></td>
  <td><c:out value="${item.prixHT + item.prixHT * item.tauxTVA / 100}" />€</td>
  <td><c:out value="${item.tauxTVA}" />%</td>
  <td><c:out value="${item.codeBarre}" /></td>
  <td><form action="" method="post">
  <button type="submit" class="btn btn-danger" name="btDeletePanier" value="${item.codeBarre}" id="${item.codeBarre}">Supprimer</button>
  </form>
  </td>
</tr>
</c:forEach>
</table>
</c:if>
<c:if test="${(sessionScope.listPanier== null)}">
<div class="alert alert-danger addAlert" role="alert"><c:out value="Aucun article dans le panier"/></div>

</c:if>
</body>
</html>