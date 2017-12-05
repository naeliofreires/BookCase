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
    <link rel="stylesheet" href="/css/corpo-aplicacao.css">
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>

<jsp:include page="includes/nav_bar.jsp"/>

<hr>

<div class="container" ng-controller="comentarioController">
   
    <div class="container">
        <!-- dados do artigo -->
        <div class="container div-artigo">
            <!-- dados do escritor -->
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
            <div class=" text-right">
                <span class="data-artigo">Publicado por <a href="escritor?id=${escritor.id}">${escritor.nome}</a> em ${artigo.data_publicacao}</span><br>
                <c:if test="${ usuario.id == escritor.id}">
                    <a class="nav-link" href="excluir-artigo?id=${artigo.id}"> EXCLUIR </a>
                </c:if>
            </div>
            <br>
        </div>
        <br>
        <hr>
        <br>
        <!-- comentarios -->
        <div class="container">
            <!-- FORMULARIO RESPOSTA -->
            <div>
                <form>
                    <input id="userID" value="${escritor.id}" hidden="true">
                    <input id="artigoID" value="${artigo.id}" hidden="true">
                    <c:if test="${ logado == true}">
                        <input ng-model="comentario" type="text" class="form-control"
                               placeholder="Escreva o que achou...">
                        <span class="input-group-btn">
                              <button ng-click="adicionarComentario(comentario)" class="btn btn-secondary"
                                      type="button">Responder</button>
                        </span>
                    </c:if>

                </form>
            </div>


            <br><h6>Comentarios:</h6><br>

            <%--TODOS OS COMENTARIOS DO ARTIGO EXISTENTE--%>
            <div>
                <div ng-repeat="comentario in comentarios">
                    <div id="comentario-style" class="container">
                        <div id="comentario-caixa" class="container">
                            <h6 id="tituloComentario">{{comentario.escritor}}</h6>
                            <p id="tDextoComentario">{{comentario.texto}}</p>
                        </div>
                    </div>
                    <br>
                </div>
            </div>
        </div>
    </div>
</div>

<br><br><br>
<%--Imports JS--%>
<%--ANGULAR JS--%>
<script src="/js/angular/angular.min.js" type="text/javascript"></script>
<%--Controller--%>
<script src="/js/controller/bookCaseController.js" type="text/javascript"></script>
<%--Service--%>
<script src="/js/service/comentarioAPI.js" type="text/javascript"></script>
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