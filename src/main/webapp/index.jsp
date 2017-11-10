<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" ng-app="bookCase">
<head>
    <meta charset="UTF-8">
    <title>BookCase</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
</head>
<body>

<jsp:include page="includes/nav_bar.jsp"/>

<hr>

<%--MENSAGEM CASO O CADASTRO DO NOVO USUARIO DE TUDO CERTO--%>
<c:if test="${ mensagem != null}">
    <div class="alert alert-success container text-center" role="alert">
        <strong> ${mensagem}</strong>
    </div>
</c:if>


<c:if test="${ usuario != null}">
    <%--FORMULARIO PARA POSTAR ARTIGO--%>
    <div class="container text-center"  ng-controller="artigoController">
        <h4 class="text-center">{{aplicacao}}</h4>
        <form class="container">
            <textarea ng-model="artigo.texto" style="width: 600px"> </textarea>
            <center>
                <button ng-click="adicionarArtigo(artigo)" class="btn btn-success btn-block" style="width: 600px">
                    Postar Artigo
                </button>
            </center>
        </form>

    </div>
</c:if>

<%--Imports JS--%>
<%--ANGULAR JS--%>
<script src="/js/angular/angular.min.js" type="text/javascript"></script>
<%--Controller--%>
<script src="/js/controller/bookCaseController.js" type="text/javascript"></script>
<%--Service--%>
<script src="/js/service/artigoAPI.js" type="text/javascript"></script>
<%--Value--%>
<script src="/js/value/configValue.js" type="text/javascript"></script>
</body>
</html>