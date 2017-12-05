<br>
<div class="container">
    <form action="efetuar-update-usuario" method="POST">
        <input type="text" class="form-control" id="id" name="id" value="${usuario.id}" hidden="true">
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nome" name="nome" value="${usuario.nome}">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" name="email" value="${usuario.email}">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="text" class="form-control" id="trabalho" name="trabalho" value="${usuario.trabalho}">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-10">
                <input type="password2" class="form-control" id="nova_senha" name="nova_senha" placeholder="Nova Senha">
            </div>
        </div>
        <span>Confirme:</span>
        <div class="form-group row">
            <div class="col-sm-8">
                <input type="password" class="form-control" id="senha" name="senha" placeholder="********">
            </div>
            <div class="col-sm-2">
                <button type="submit" class="btn btn-primary btn-block">ALTERAR</button>
            </div>
        </div>

    </form>
</div>
<br>