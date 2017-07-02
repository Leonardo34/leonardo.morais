app.service('postService', function($http) {
 
    this.getPostsFeed = function() {
        return $http.get('http://localhost:9090/posts/feed');
    }

    this.curtirPost = function(idPost) {
        return $http.post('http://localhost:9090/like/' + idPost, {});
    }

    this.descurtirPost = function(idLike) {
        return $http.post('http://localhost:9090/deslike/' + idLike, {});
    }

    this.enviarComentario = function(comentario, post) {
        return $http.post('http://localhost:9090/comentario/' + post.id, comentario);
    }
});