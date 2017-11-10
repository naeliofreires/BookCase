angular.module("bookCase").service("artigoAPI", function ($http, config) {

    this.adicionar_artigo = function (novo_artigo) {
        return $http.post(config.baseUrl + "/artigo", novo_artigo);
    };

});