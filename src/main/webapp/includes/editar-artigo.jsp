<div class="container text-center">
    <form action="efetuar-update-artigo" method="POST" class="container form-group">
        <br>
        <!-- ID artigo -->
        <input id="id" name="id" type="text" class="form-control" value="${artigo.id}" hidden="true">
        <!-- Data publicação artigo -->
        <input id="data_publicacao" name="data_publicacao" type="text" value="${artigo.data_publicacao}" hidden="true">
        <!-- ID escritor -->
        <input id="userID" name="userID" type="text" value="${escritor.id}" hidden="true">
        <br>
        <input id="titulo" name="titulo" type="text" class="form-control" value="${artigo.titulo}">
        <br>
        <input  id="resumo" name="resumo" type="text" class="form-control" value="${artigo.resumo}" maxlength="100">
        <br>
        <textarea id="texto" name="texto" class="form-control">${artigo.texto}</textarea>
        <br>
        <button class="btn btn-outline-info btn-block"> ATUALIZAR ARTIGO </button>
    </form>
</div>