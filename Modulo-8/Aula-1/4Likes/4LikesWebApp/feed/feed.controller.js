app.controller('feedController', function($scope, authService, postService, toastr, $location) {
    $scope.url.path = $location.path();
    $scope.pageSize = 2;
    carregarPostsFeed();
    $scope.flagLike = false;


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
            postService.descurtirPost(parseInt(idLike)).then(res => { 
                carregarPostsFeed();
                //toastr.success("Post Descurtido");
            }, err => {
                //toastr.error(err.data.message);
            });
            let index = post.likes.findIndex(l => l.usuarioCurtida.id == authService.getUsuario().id);
            post.likes.splice(index, 1);
        } else {
            $scope.flagLike = true;
            post.likes.push( { usuarioCurtida : authService.getUsuario() })
            postService.curtirPost(post.id).then(res => {
                carregarPostsFeed();
                let index = post.likes.findIndex(l => l.usuarioCurtida.id == authService.getUsuario().id);
                post.likes.splice(index, 1);
                post.likes.push(res.data);
                $scope.flagLike = false;
                //toastr.success("Post Curtido");
            });
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