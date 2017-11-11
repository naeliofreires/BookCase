angular.module("bookCase").service("artigoAPI", function ($http, config) {

    // adiciona um artigo
    this.adicionar_artigo = function (novo_artigo) {
        return $http.post(config.baseUrl + "/artigo", novo_artigo);
    };

    // traz todos os artigos existente
    this.listarArtigos = function () {
        return $http.get(config.baseUrl + "/artigo");
    }

});