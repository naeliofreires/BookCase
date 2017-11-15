angular.module("bookCase").service("artigoAPI", function ($http, $location) {

    // adiciona um artigo
    this.adicionar_artigo = function (novo_artigo) {
        return $http.post($location.protocol() + "://" +location.host + "/artigo", novo_artigo);
    };

    // traz todos os artigos existente
    this.listarArtigos = function () {
        return $http.get($location.protocol() + "://" +location.host + "/artigo");
    }

});