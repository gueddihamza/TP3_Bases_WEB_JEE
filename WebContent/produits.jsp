<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits</title>
<link rel="stylesheet" type="text/css" href="resource/bootstrap/css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container col-md-10">
<div class="card m-5">
  <h5 class="card-header bg-primary text-white">Recherche des produits</h5>
  <div class="card-body">
    <p class="card-text">
    	<form action="chercher.php" method="get">
    		<label>Mot clé</label>
    		<input type="text" name="keyword" value="${model.keyword }">
    		<button type="submit" class="btn btn-primary">Chercher</button>
    	</form>
    	
    	<table class="table table-striped mt-5">
    		<tr>
    			<th>ID</th>
    			<th>Designation</th>
    			<th>Prix</th>
    			<th>Quantite</th>
    			<th colspan="2">Actions</th>
    		
    		</tr>
    		<c:forEach items="${model.produits}" var="p">
    			<tr>
    				<td>${p.id}</td>
    				<td>${p.designation}</td>
    				<td>${p.prix}</td>
    				<td>${p.quantite}</td>
    				<td><a href="edit.php?id=${p.id}">Edit</a></td>
    				<td><a onclick="return confirm('Etes-vous sur de supprimer ce produit?')" href="delete.php?id=${p.id}">Delete</a></td>
    			</tr>
    		
    		</c:forEach>
    	</table>
  </div>
</div>
			</div>
</body>
</html>