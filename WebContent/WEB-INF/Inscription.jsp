<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/AppDiitribue/bootstrap-4.6.1-dist/css/bootstrap.min.css" >
<title>Inscription</title>

</head>
<body>



<form action="Inscription" method="post">
<fieldset  id="carre">
<legend>Veuillez vous inscrire </legend>

<label>Nom</label> 
<input type="text" id="nom" value="<c:out value="#{}"/>"   />
<label>Prenom</label>
<input type="text" id="prenom" value="<c:out value="#{}"/>"   />
<label>Adresse Email</label>
<input type="email" id="email" value="<c:out value="#{}"/>"   />
<label>Mot de passe</label>
<input type="password" id="password" name=""value="<c:out value="#{}"/>"   />
<label>Confirmation mot de passe</label>
<input type="password" id="password" name=""value="<c:out value="#{}"/>"   />
<label>Type compte</label>
<input type="radio" id="typecompte" name="typecompte" value="Auteur"   />
<input type="radio" id="typecompte" name="typrecompte" value="Lecteur"   />
<input type="submit" id="sub" value="Inscription"   />
</fieldset>
</form>






<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>