angular.module("bookCase", []);

angular.module("bookCase").controller("artigoController", function ($scope, artigoAPI) {

    $scope.aplicacao = "Book Case";
    $scope.artigos = [];

    getArtigos = function () {
        artigoAPI.listarArtigos()
            .then(
            function (response) {
                $scope.artigos = response.data;
                console.log($scope.artigos);
            }, function (response) {
                console.log("[getArtigos] Response: " + response);
            }
            );
    };

    getArtigos();

    $scope.adicionarArtigo = function (novo_artigo) {
        artigoAPI.adicionar_artigo(novo_artigo)
            .then(
            function (response) {
                delete $scope.novo_artigo;
                alert("adicionado!");
                getArtigos();
            }, function (response) {
                console.log("[adicionarArtigo] Response: " + response);
            }
            );
    };

});

angular.module("bookCase").controller("comentarioController", function ($scope, comentarioAPI) {

    $scope.comentarios = [];

    /** CARREGANDO TODOS OS COMENTARIOS DO ARTIGO **/
    getComentariosArtigo = function (artigoID) {
        comentarioAPI.listarComentariosArtigo(artigoID).then(
            function (response) {
                $scope.comentarios = response.data;
                console.log($scope.comentarios);
            },function () {
                console.log("[getComentariosArtigo] Response: " + response);
            }
        );
    };

    /** ADICIONAR COMENTARIO **/
    $scope.adicionarComentario = function (texto) {
		
        //Montando comentário.
        $scope.comentario = {};
        $scope.comentario.escritor =  $("#userID").val();
        $scope.comentario.artigo = $("#artigoID").val();
        $scope.comentario.nomeEscritor = $("#escritorNome").val();
        $scope.comentario.texto  = texto;

        comentarioAPI.adicionar_comentario($scope.comentario)
            .then(
                function (response) {
                    $scope.text = "";
                    getComentariosArtigo($("#artigoID").val());
                    alert("Comentario Adicionado");
                }, function (response) {
                    console.log("[adicionarArtigo] Response: " + response);
                }
            );
    };


    /** CHAMADA DE FUNÇÕES **/

    getComentariosArtigo($("#artigoID").val());

});
