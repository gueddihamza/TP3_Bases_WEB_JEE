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
  <h5 class="card-header bg-primary text-white">Ajout avec succès !</h5>
  <div class="card-body">
  
      	<table class="table table-striped mt-5">
    			<tr>
    			<td>
    				ID : ${produit.id} </td></tr>
    			<tr><td>	Designation : ${produit.designation} </td></tr>
    			<tr><td>	Prix : ${produit.prix}</td></tr>
    			<tr><td>	Quantite : ${produit.quantite}</td> </tr>
    			

    	</table>
	
    	</div>

  </div>
</div>
</body>
</html>