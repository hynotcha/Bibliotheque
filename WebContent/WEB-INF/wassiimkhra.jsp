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
akhtiiiiniiiii <br/>

<c:forEach items="${livre}" var="li">

<c:out value="${li.id }"></c:out>
<c:out value="${li.auteur}"></c:out>
<c:out value="${li.titre}"></c:out>
<br/>

<c:out value="${bos}"></c:out><br/>
</c:forEach>



<embed src="../${fi}" width=800 height=50 type='application/pdf'/>



<%--<iframe src="" style="width:600px; height:500px;" frameborder="0"></iframe>


<iframe src="C:/Users/DELL/Downloads/monFichier"  width="100%" height="500px" ></iframe>

--%>

 <iframe src="${fi}" width="100%" height="500px"> </iframe>
 
 <iframe src="<c:out value="${pageContext.request.contextPath}/${fi}"></c:out>" width="100%" height="500px"> </iframe>
 
 
 <object data="${pageContext.request.contextPath}/ss" type="application/pdf" width="500" height="300"></object>

<c:out value="${fi}"/>







<object data="data:application/pdf;base64,${base}" type="application/pdf" height="300" width="500"  ></object>



<iframe src="http://docs.google.com/gview?url=${fi}&embedded=true" style=""></iframe>



<%-- <a href="data:application/pdf;base64,/${pdf1}"></a>. --%>
<c:out value=""/>


<c:out value =""/>












</body>
</html>