<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" ng-app="bookCase">
<head>
    <meta charset="UTF-8">
    <title>BookCase</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css" >
</head>
<body>

<jsp:include page="includes/nav_bar.jsp"/>

<hr>

<div class="container">
    <!-- dados do escritor -->
    <h5>Escritor: <span>${escritor.nome}</span> </h5>
    <h6>Contato: <span>${escritor.email}</span></h6>
    
    <!-- dados do artigo -->
    <div class="container div-artigo">
        <br>
        <h3 class="text-center">${artigo.titulo}</h3>
        <br>
        <div class="resumo text-center">
            ${artigo.resumo}
        </div>
        <br>
        <div class="texto-artigo">
            ${artigo.texto}
        </div>
        <br>
        <hr>
        <div class=" text-right">
            <span class="data-artigo">${artigo.data_publicacao}</span>
        </div>
        <br>
    </div>
</div>
</body>
</html>