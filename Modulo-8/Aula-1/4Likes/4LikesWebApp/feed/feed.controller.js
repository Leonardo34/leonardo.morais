app.controller('feedController', function($scope, authService, postService, toastr) {
    carregarPostsFeed();

    function carregarPostsFeed() {
        postService.getPostsFeed().then(res => {
            $scope.posts = res.data;
            console.log($scope.posts);
        }, error => {
            window.alert("Erro");
        })
    }

    $scope.vai = function() {
        console.log("vai")
    }

    $scope.postCurtido = function(post) {
        let usuario = authService.getUsuario();
        return post.likes.some(l => l.usuarioCurtida.id == usuario.id);
    }

    $scope.likePost = function(post) {
        if ($scope.postCurtido(post)) {
            let idLike = getIdLikeUsuarioLogado(post);
            postService.descurtirPost(idLike).then(res => { 
                carregarPostsFeed();
                toastr.success("Post Descurtido");
            });
            let index = post.likes.findIndex(l => l.usuarioCurtida.id == authService.getUsuario());
            post.likes.splice(index, 1);
        } else {
            postService.curtirPost(post.id).then(res => { 
                carregarPostsFeed();
                toastr.success("Post Curtido");
            });
            post.likes.push({ usuarioCurtida : authService.getUsuario() })
        }
    }

    $scope.adicionarComentario = function(comentario, post) {
        console.log(comentario);
        postService.enviarComentario(comentario, post).then(() => carregarPostsFeed());
        comentario.usuario = authService.getUsuario();
        post.comentarios.push(comentario);
        delete $scope.comentario;
    }

    function getIdLikeUsuarioLogado(post) {
        let usuario = authService.getUsuario();
        let like = post.likes.find(l => l.usuarioCurtida.id == usuario.id);
        return like.id;
    }
});