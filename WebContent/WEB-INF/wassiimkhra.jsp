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
akhtiiiiniiiii

<c:forEach items="${livre}" var="li">

<c:out value="${li.id }"></c:out>
<c:out value="${li.auteur}"></c:out>
<c:out value="${li.pdf }"></c:out>
</c:forEach>
<c:out value=""/>


<c:out value =""/>
</body>
</html>