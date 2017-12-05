<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="">BookCase</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Página Inicial <span class="sr-only">(current)</span></a>
            </li>
            <li>
                <c:if test="${ logado == null}">
                    <a class="nav-link disabled" href="#">Seja Bem Vindo!</a>
                </c:if>
            </li>
            <li>
                <c:if test="${ logado != null}">
                    <a style="color: blue" class="nav-link" href="usuario">Meu Perfil</a>
                </c:if>
            </li>
        </ul>

        <%--SE USUARIO ESTIVER LOGADO, APARECER OPÇÃO DESLOGAR--%>
        <c:choose>
            <c:when test="${ logado != null}">
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