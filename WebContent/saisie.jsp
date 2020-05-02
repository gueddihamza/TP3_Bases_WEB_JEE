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
  <h5 class="card-header bg-primary text-white">Saisir un produit</h5>
  <div class="card-body">
	<form method="POST" action="confirmationsaisie.php" >
    	<div class="form-group" class="card-text">
    		<label for="des">Désignation</label>
    		<input type="text" name="des" placeholder="Veuillez entrer la désignation" id="des" class="form-control" required="required">
    	</div>
    	   <div class="form-group" class="card-text">
    		<label for="price">Prix</label>
    		<input type="text" name="price" placeholder="Veuillez entrer le prix" id="price" class="form-control" required="required">
    	</div>
    	    	<div class="form-group" class="card-text">
    		<label for="quantity">Quantité</label>
    		<input type="text" name="quantity" placeholder="Veuillez entrer la quantité" id="quantity" class="form-control" required="required">
    	</div>
    	<div>
    	<button type="submit" class="btn btn-primary">Ajouter</button>
    	</div>
    	</form>
    	</div>

  </div>
</div>
</body>
</html>