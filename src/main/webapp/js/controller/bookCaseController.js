angular.module("bookCase", []);

angular.module("bookCase").controller("artigoController", function ($scope, artigoAPI) {

    $scope.aplicacao = "Book Case";
    $scope.artigos = [];

    $scope.adicionarArtigo = function (novo_artigo) {
        artigoAPI.adicionar_artigo(novo_artigo)
            .then(
                function (response) {
                    delete $scope.novo_artigo;
                    alert("adicionado!")
                }, function (response) {
                    console.log("[adicionarArtigo] Response: " + response);
                }
            );
    };

    getArtigos = function () {
        artigoAPI.listarArtigos()
            .then(
                function (response) {
                    $scope.artigos = response.data;
                    console.log($scope.artigos);
                },function (response) {
                    console.log("[getArtigos] Response: " + response);
                }
            );
    };

    console.log("Oi");
    getArtigos();

});
