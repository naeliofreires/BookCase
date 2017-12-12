<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BookCase</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/corpo-aplicacao.css">
</head>
<body>
<%--NAV BAR--%>
<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="">BookCase</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Página Inicial <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="email" placeholder="E-Mail">
            <input class="form-control mr-sm-2" type="password" placeholder="Password">
            <button class="btn align-middle btn-outline-secondary my-2 my-sm-0" type="submit">Sign in</button>
        </form>
    </div>
</nav>

<hr>

<%--MESAGEM DE ERRO CASO O CADASTRO NÃO OCORRA--%>
<c:if test = "${ mensagem != null}">
    <div class="alert alert-danger container text-center" role="alert">
        <strong> ${mensagem}</strong>
    </div>
</c:if>

<%--FORMULARIO DE CADASTRO USUARIO--%>
<div class="container">
    <form action="efetuar-cadastro-usuario" method="POST">
        <div class="form-group row">
            <label for="nome" class="col-sm-2 col-form-label">Nome</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
            </div>
        </div>
        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" name="email" placeholder="Email">
            </div>
        </div>
        <div class="form-group row">
            <label for="trabalho" class="col-sm-2 col-form-label">Profissão</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="trabalho" name="trabalho" placeholder="Trabalho">
            </div>
        </div>
        <div class="form-group row">
            <label for="senha" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="senha" name="senha" placeholder="Password">
            </div>
        </div>
        <%--BUTTON--%>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Get started</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
