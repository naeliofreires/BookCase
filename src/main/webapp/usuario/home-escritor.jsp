<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/corpo-aplicacao.css">
    <link rel="stylesheet" href="/css/style-perfil-escritor.css">
</head>
<body>
<!-- NAV BAR -->
<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
        
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
        </button>

        <a class="navbar-brand" href="">BookCase</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                                <a class="nav-link" href="/">Pagina Inicial</a>
                        </li>
                </ul>
                <%--SE USUARIO N ESTIVER LOGADO, APARECER OPÇÕES DE LOGIN E CADASTRO--%>
                <c:choose>
                    <c:when test="${ usuario != null}">
                        <a href="deslogar">Sign out</a>
                    </c:when>
                    <c:otherwise>
                        <a href="cadastroUsuario" class="btn btn-outline-success" style="margin-right:10px">Get started</a>
        
                        <form action="efetuar-login" method="POST" class="form-inline my-2 my-lg-0">
                            <input id="email" name="email" class="form-control mr-sm-2" type="email" placeholder="E-Mail">
                            <input id="senha" name="senha" class="form-control mr-sm-2" type="password" placeholder="Password">
                            <button class="btn align-middle btn-outline-secondary my-2 my-sm-0" type="submit">Sign in</button>
                        </form>
                    </c:otherwise>
                </c:choose>
        </div>
</nav>

<div class="container">
        <div class="container-escritor">
                <h5>${escritor.nome}</h5>
                <span>Desenvolvedor Android</span>
                
                <br><br>
      
                <hr>

                <span>Featured</span><br><br>

                <div class="artigos-escritor container row">
                        <c:forEach var="artigo" items="${artigos_escritor}">
                                <div class="card-style col-12">
                                        <div class="card">
                                                <div class="card-block">
                                                        <h4 class="card-title">${artigo.titulo}</h4>
                                                        <span>Resumo:</span>
                                                        <p class="card-text">${artigo.resumo}</p>
                                                        <a href="ler-artigo?id=${artigo.id}" class="btn btn-outline-primary">Visualizar</a>
                                                </div>
                                        </div>
                                </div>
                                <br>
                                <hr>
                        </c:forEach>
                </div>
        </div>
</div>

<%--Imports JS--%>
<%--ANGULAR JS--%>
<script src="/js/angular/angular.min.js" type="text/javascript"></script>
<%--Controller--%>
<script src="/js/controller/bookCaseController.js" type="text/javascript"></script>

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