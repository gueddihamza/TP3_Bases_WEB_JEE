<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Saisie</title>
<link rel="stylesheet" type="text/css" href="resource/bootstrap/css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container col-md-10">
<div class="card m-5">
  <h5 class="card-header bg-primary text-white">Modifier un produit</h5>
  <div class="card-body">
	<form method="POST" action="confirme.php" >
	
	    	<div class="form-group" class="card-text">
    		<label for="id">ID</label>
    		<input type="text" name="id" value="${produit.id }"  id="id" class="form-control" readonly>
    	</div>
    	<div class="form-group" class="card-text">
    		<label for="des">Désignation</label>
    		<input type="text" name="des" value="${produit.designation }" placeholder="Veuillez entrer la désignation" id="des" class="form-control" required="required">
    	</div>
    	   <div class="form-group" class="card-text">
    		<label for="price">Prix</label>
    		<input type="text" name="price"  value="${produit.prix }"placeholder="Veuillez entrer le prix" id="price" class="form-control" required="required">
    	</div>
    	    	<div class="form-group" class="card-text">
    		<label for="quantity">Quantité</label>
    		<input type="text" name="quantity" value="${produit.quantite }" placeholder="Veuillez entrer la quantité" id="quantity" class="form-control" required="required">
    	</div>
    	<div>
    	<button type="submit" class="btn btn-primary">Modifier</button>
    	</div>
    	</form>
    	</div>

  </div>
</div>
</body>
</html>