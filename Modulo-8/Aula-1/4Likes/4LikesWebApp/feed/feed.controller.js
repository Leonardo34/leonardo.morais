app.controller('feedController', function($scope, authService, postService, toastr) {
    $scope.pageSize = 2;
    carregarPostsFeed();

    function carregarPostsFeed() {
        postService.getPostsFeed(0, $scope.pageSize).then(res => {
            $scope.posts = res.data;
            console.log($scope.posts);
        }, error => {
            toastr.error("Erro carregando post do servidor");
        })
    }

    $scope.postCurtido = function(post) {
        if (typeof post === "undefined") {
            return false;
        }
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
        let novoComentario = { 
            conteudo : comentario.conteudo, 
            usuario : authService.getUsuario() 
        };
        postService.enviarComentario(comentario, post).then(() => carregarPostsFeed());
        post.comentarios.push(novoComentario);
    }

    function getIdLikeUsuarioLogado(post) {
        let usuario = authService.getUsuario();
        let like = post.likes.find(l => l.usuarioCurtida.id == usuario.id);
        return like.id;
    }

    $scope.proximaPagina = function() {
        $scope.pageSize += $scope.pageSize;
        carregarPostsFeed();
    }

    $scope.carregarLikes = function(postLikes) {
        $scope.likes = postLikes;
    }
});