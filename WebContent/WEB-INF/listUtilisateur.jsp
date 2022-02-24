<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>nom</th>
			<th>prenom</th>
			<th>email</th>
			<th>role</th>

		</tr>
		<c:forEach items="${utilisateurList}" var="utilisateur">
			<tr>
				<td>${utilisateur.getId()}</td>
				<td>${utilisateur.getNom()}</td>
				<td>${utilisateur.getPrnom()}</td>
				<td>${utilisateur.getEmail()}</td>
				<td>${utilisateur.getRole()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>