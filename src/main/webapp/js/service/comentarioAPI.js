angular.module("bookCase").service("comentarioAPI", function ($http, $location) {

    /** ADICIONAR NOVO COMENTARIO **/
    this.adicionar_comentario = function (comentario) {
        return $http.post($location.protocol() + "://" + location.host + "/comentario", comentario);
    };

    /** LISTAR COMENTARIOS ARTIGO**/
    this.listarComentariosArtigo = function (artigoID) {
        return $http.get($location.protocol() + "://" + location.host + "/comentario/" + artigoID);
    };

    /** DELETAR UM COMENTARIO DE UM USUARIO**/
    this.deletarComentario = function (id) {
        return  $http.delete($location.protocol() + "://" + location.host + "/deletar/comentario/" + id);
    }

});