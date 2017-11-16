angular.module("bookCase").service("comentarioAPI", function ($http, $location) {

    // adicionar um comentario
    this.adicionar_comentario = function (comentario) {
        return $http.post($location.protocol() + "://" +location.host + "/comentario", comentario);
    };

    // traz todos os comentarios existente
    this.listarComentarios = function () {
        return $http.get($location.protocol() + "://" +location.host + "/comentario");
    };

    this.listarComentariosArtigo = function (artigoID) {
        return $http.get($location.protocol() + "://" +location.host + "/comentario/" + artigoID);
    };

});