<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Java EE</title>
  </head>
  <body>
	<div>Votre inscription a bien été prise en compte le 
		 <fmt:formatDate type="date" dateStyle="long" value="${inscription.date}"/> à 
		 <fmt:formatDate type="time" value="${inscription.date}"/> 
		 pour l'adresse mail <c:out value="${inscription.email}"/>.
	</div>
	<div>
	  	<a href="<c:url value="/"/>">Retour à l'accueil</a>  
	</div>
  </body>
</html>
