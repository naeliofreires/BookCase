<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>BookCase</title>
<!-- Bootstrap -->
	<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<!-- CSS -->
	<link rel="stylesheet" href="/css/HomeUsuarioStyle.css">
	<link rel="stylesheet" href="/css/corpo-aplicacao.css">
</head>
<body>
	<!-- NAV BAR -->
	<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="">BookCase</a>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="/">Pagina Inicial</a>
				</li>
				<li class="nav-item">
					<a class="nav-link disabled" href="#">Olá, ${usuario.nome}</a>
				</li>
			</ul>
		</div>
	</nav>
	
	<div class="row">
		<!-- Meus dados -->
		<div class="col-2 container">
			<div id="dados-perfil-mostrar">
				<br>
				<div class="container">
					<span class="dados-usuario">Nome </span><br>
					<span>${usuario.nome}</span><br>

					<span class="dados-usuario">E-Mail</span><br>
					<span>${usuario.email}</span><br>

					<span class="dados-usuario">Artigos Publicado</span><br>
					<span>${quantidade_artigos}</span>

					<hr>
					<button id="button-editar-perfil" class="btn btn-outline-primary">Editar Perfil</button>
				</div>
			</div>
		</div>

		<!-- Meus artigos -->
		<div class="col-10">
            <div id="dados-perfil-editar" class="form-editar-perfil">
                <jsp:include page="../includes/editar-perfil.jsp"/>
            </div>
			<div id="meu-artigos" class="container meus-artigos-container">
				<div class="row">
					<br>
                    <c:forEach var="artigo" items="${meus_artigos}">
                        <div class="col-12">
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
                        </div>
                    </c:forEach>
					<br>
				</div>
			</div>
		</div>

	</div>

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

<%--Ações da Página--%>
	<script src="/js/HomeUsuarioStyle.js" type="text/javascript"></script>
</body>
</html>
