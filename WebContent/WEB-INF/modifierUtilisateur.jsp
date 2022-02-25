<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/Biblio/ModiefierUtilisateur" method="post">
		<label>${error }</label> <label>ancienMotdepass</label><input
			type="password" name="ancienMotdepass"> <label>nouveauMotdepass</label><input
			type="password" name="nouveauMotdepass"> <input type="submit">
	</form>
</body>
</html>