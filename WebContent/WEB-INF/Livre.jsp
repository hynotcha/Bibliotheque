<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="/AppDiitribue/bootstrap-4.6.1-dist/css/bootstrap.min.css" >
<title>Ajouter un livre</title>

</head>
<body>



<div class="container rounded-lg pt-4 bg-light">

<h1>Ajouter un livre <small>via ce formulaire </small></h1>

<form action="AjoutDuLivre" method="post"  enctype="multipart/form-data">

<%-- -----------------Tiitre Du livre--------------------------------------------------------------------------------------------------------- --%>

<div class="form-group">
<label class="font-weight-normal">Titre</label>
<input type="text" id="titre" class="form-control shadow-lg" name="titre" value="<c:out value="#{}"/>" placeholder="Entrez le titre du livre " required >
</div>

<%-- --------------------------Auteur du livre-------------------------------------------------------------------------------------------------- --%>

<div class="form-group">
<label>Auteur</label>
<input type="text" id="auteur" class="form-control  shadow-lg" name="auteur" value="<c:out value="#{}"/>" placeholder="Entrez le nom de l'auteur " required >
</div>

<%-- ----------------------------Date de sortie du livre----------------------------------------------------------------------------------------- --%>

<div class="form-group">
<label >Date de publication</label>

<input type="datetime" id="datesortie" class="form-control w-25 shadow-lg" name="datesortie" placeholder="jj/mm/aa" value="<c:out value="#{}"/>"   />

</div>



<%-- ------------------------------Nombre de page---------------------------------------------------------------------------------------------- --%>
 
<div class="form-group">
<label>Nombre de page</label>
<input type="number" id="nombrepage" class="form-control w-25 shadow-lg " name="nombrepage" placeholder="Entrez le nombre de pages" value="<c:out value="#{}"/>"   />
</div>



<%-- -------------------------------------Prix------------------------------------------------------------------------------------------------- --%>

<div class="form-group">
<label for="prix">Prix</label>
<input type="range" id="prix" class="custom-range w-25 " name="prix" max="1000" value="<c:out value="#{}"/>"   />
</div>

<%-- -----------------------------------------Type du livre----------------------------------------------------------------------------------- --%>

<div class="form-group">
<label>Type</label>

<div class="custom-control custom-checkbox ">
    <input type="checkbox" class="custom-control-input" id="action" name="type" value="action">
    <label class="custom-control-label" for="action"> Action</label>
    
  </div>

<div class="custom-control custom-checkbox ">
    <input type="checkbox" class="custom-control-input" id="documentaire" name="documentaire" value="documentaire">
    <label class="custom-control-label" for="documentaire"> Documentaire</label>
    
  </div>
  
 <div class="custom-control custom-checkbox ">
    <input type="checkbox" class="custom-control-input" id="dictionnaire" name="dictionnaire" >
    <label class="custom-control-label" for="dictionnaire"> Dictionnaire</label>  
  </div> 
  
   <div class="custom-control custom-checkbox ">
    <input type="checkbox" class="custom-control-input" id="encyclopedie" name="encyclopedie">
    <label class="custom-control-label" for="encyclopedie"> Encyclopedie</label>  
  </div> 
  
 
   <div class="custom-control custom-checkbox ">
    <input type="checkbox" class="custom-control-input" id="fantaisie" name="fantaisie">
    <label class="custom-control-label" for="fantaisie"> Fantaisie</label>  
  </div> 
  
  <div class="custom-control custom-checkbox ">
    <input type="checkbox" class="custom-control-input" id="fiction" name="type" value="fiction">
    <label class="custom-control-label" for="fiction"> Fiction</label>  
  </div>
  
  <div class="custom-control custom-checkbox ">
    <input type="checkbox" class="custom-control-input" id="policier" name="type" value="policier">
    <label class="custom-control-label" for="policier"> Policier</label>
    
  </div>
  
</div>



<%-- ------------------------------------Edition---------------------------------------------------------------------------------------------  --%>
<div class="form-group">
<label>Edition</label>
<input type="text" id="edition" class="form-control" name="edition" value="<c:out value="#{}"/>"   />
</div>


<%-- ---------------------------------------Consultation--------------------------------------------------------------------------------------- --%>
<div class="form-group">
<label>Consultation</label>
<div class="custom-control custom-radio  custom-control-inline">
 
    <input type="radio" class="custom-control-input" id="consultnon" name="consult" value="non" checked>
   <label class="custom-control-label" for="consultnon">Non</label>
</div>
<div class="custom-control custom-radio custom-control-inline">
  
    <input type="radio" class="custom-control-input" id="consultoui" name="consult" value="Oui">
    <label class="custom-control-label" for="consultoui">Oui</label>
  
</div>
</div> 



<%-- ------------------------------Couverture du livre ---------------------------------------------------------------------------------------- --%>

<div class="form-group">
<label>Couverture</label>
<div class="custom-file">
<input type="file" id="couverture" class="custom-file-input w-25" name="couverture" value="<c:out value="#{}"/>"   />
<label class="custom-file-label" for="couverture">Choisir couverture </label>

</div>
</div>

<%-----------------------------------------PDF------------------------------------------------------------------------------------------------- --%>
<div class="form-group">
<label>PDF</label>
<div class="custom-file">
<input type="file" id="pdf" class="custom-file-input " name="pdf" value="<c:out value="#{}"/>"   />
<label class="custom-file-label w-30" for="pdf">Ajouter livre version pdf</label>
</div>
</div>




<button type="submit" class="btn btn-danger">Ajouter</button>

</form>





</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>