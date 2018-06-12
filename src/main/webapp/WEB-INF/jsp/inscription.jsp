<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Java EE</title>
    <style type="text/css">
    	form > div {
    		padding: .5em;
    	}
    	
    	div > label:first-child {
    		display: inline-block;
			min-width: 18em;
		}
		
		.error {
			color: red;
		}
    </style>
  </head>
  <body>

	<form method="post" accept-charset="utf-8">
		<div>
			<label for="email">Email : </label>
			<input id="email" name="email" type="text" value="<c:out value="${param['email']}" />"> 
			<span class="error"><c:out value="${errors['email']}"/></span>
		</div>
		<div>
			<label for="motDePasse">Mot de passe : </label>
			<input id="motDePasse" name="motDePasse" type="password">
			<span class="error"><c:out value="${errors['motDePasse']}"/></span>
		</div>
		<div>
			<label for="confirmationMotDePasse">Confirmation du mot de passe : </label>
			<input id="confirmationMotDePasse" name="confirmationMotDePasse" type="password">
			<span class="error"><c:out value="${errors['confirmationMotDePasse']}"/></span>
		</div>
		<div>
			<input id="approbation" name="approbation" value="true" type="checkbox">
			<label for="approbation">J'ai lu et approuvé les conditions générales de ce site</label>
			<span class="error"><c:out value="${errors['approbation']}"/></span>
		</div>
		<div>
			<button type="submit">S'inscrire</button>
		</div>
	</form>

	<div>
	  	<a href="<c:url value="/"/>">Retour à l'accueil</a>  
	</div>
  
  </body>
</html>