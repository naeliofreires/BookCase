angular.module("bookCase", []);

angular.module("bookCase").controller("artigoController", function ($scope, artigoAPI) {

    $scope.aplicacao = "Book Case";

    $scope.adicionarArtigo = function (novo_artigo) {
        artigoAPI.adicionar_artigo(novo_artigo)
            .then(
                function (response) {
                    delete $scope.novo_artigo;
                    alert("adicionado!")
                }, function (response) {
                    console.log("[Erro] Response: " + response);
                });
    }

});
