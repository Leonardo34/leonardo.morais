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
        return post.likes.some(l => l.usuarioCurtida.id = usuario.id);
    }

    $scope.likePost = function(post) {

        if ($scope.postCurtido(post)) {
            let idLike = getIdLikeUsuarioLogado(post);
            postService.descurtirPost(idLike).then(res => { 
                carregarPostsFeed();
                toastr.success("Post Descurtido");
            });
        } else {
            postService.curtirPost(post.id).then(res => { 
                carregarPostsFeed();
                toastr.success("Post Curtido");
            });
        }
    }

    $scope.adicionarComentario = function(comentario, post) {
        console.log(comentario);
        postService.enviarComentario(comentario, post).then(() => carregarPostsFeed());
    }

    function getIdLikeUsuarioLogado(post) {
        let usuario = authService.getUsuario();
        let like = post.likes.find(l => l.usuarioCurtida.id == usuario.id);
        return like.id;
    }
});