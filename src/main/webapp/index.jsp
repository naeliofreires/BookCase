<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" ng-app="bookCase">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
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

<div ng-controller="artigoController">


    <c:if test="${ usuario != null}">
        <%--FORMULARIO PARA POSTAR ARTIGO--%>
        <div class="container text-center">
            <h4 class="text-center">{{aplicacao}}</h4>
            <form class="container form-group">
                <input ng-model="artigo.titulo" type="text" class="form-control" placeholder="Titulo">
                <input ng-model="artigo.resumo" type="text" class="form-control" placeholder="Resumo" maxlength="100">
                <textarea ng-model="artigo.texto" class="form-control" placeholder="Digite algo aqui.."> </textarea>
                <br>
                <button ng-click="adicionarArtigo(artigo)" class="btn btn-success btn-block">
                    Postar Artigo
                </button>

            </form>
        </div>
    </c:if>

    <br><br>

    <div class="row container" style="margin: 0 auto;">
        <div ng-repeat="artigo in artigos">
                <div class="card container " style="width: 20rem; margin: 25px">
                    <div class="card-body">
                        <h4 class="card-title text-center">{{artigo.titulo}}</h4>
                        <p class="card-text">{{artigo.resumo}}</p>
                        <h6 class="card-subtitle mb-2 text-muted">{{artigo.nome_autor}} {{artigo.data_publicacao}}</h6>
                        <a href="ler-artigo?id={{artigo.id}}" class="card-link">ler artigo</a>
                    </div>
                </div>
        </div>
    </div>
</div>

</div>
<%--Imports JS--%>
<%--ANGULAR JS--%>
<script src="/js/angular/angular.min.js" type="text/javascript"></script>
<%--Controller--%>
<script src="/js/controller/bookCaseController.js" type="text/javascript"></script>
<%--Service--%>
<script src="/js/service/artigoAPI.js" type="text/javascript"></script>
<!-- Bootstrap -->
<!-- jQuery first, then Tether, then Bootstrap JS. -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
        integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
        integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
        crossorigin="anonymous"></script>
</body>
</html>