app.service('postService', function($http) {
 
    this.getPostsFeed = function(page = 0, size = 5) {
        return $http.get('http://localhost:9090/posts/feed?page=' + page + '&size=' + size);
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

    this.getPostsByUser = function(id) {
        return $http.get('http://localhost:9090/posts/' + id);
    }

    this.enviarPost = function(post) {
        return $http.post('http://localhost:9090/post', post);
    }
});