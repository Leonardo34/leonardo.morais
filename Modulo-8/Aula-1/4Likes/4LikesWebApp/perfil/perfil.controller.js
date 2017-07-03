app.controller('perfilController', function($scope, authService, postService, $routeParams, usuarioService, toastr) {
    carregarDadosUsuario($routeParams.id);
    carregarPostsUsuario($routeParams.id);
    carregarAmigosPerfil($routeParams.id);

    $scope.isAmigos = function() {
        let usuarioLogado = authService.getUsuario();
        console.log(usuarioLogado);
        console.log($scope.amigos);
        return $scope.amigos.some(a => a.id == usuarioLogado.id);
    }

    $scope.enviarConvite = function(id) {
        usuarioService.enviarConvite(id).then(res => {
            toastr.success("Convite enviado para " + $scope.usuario.nome);
        })
    }

    function carregarPostsUsuario(id) {
        postService.getPostsByUser(id).then(res => {
            $scope.posts = res.data;
            console.log(res.data);
        });
    }

    function carregarDadosUsuario(id) {
        usuarioService.carregarDadosUsuario(id).then(res => {
            $scope.usuario = res.data;
            console.log(res.data);
        });
    }

    function carregarAmigosPerfil(id) {
        usuarioService.carregarAmigosByIdUsuario(id).then(res => {
            $scope.amigos = res.data;
            console.log(res.data);
        })
    }

    $scope.abrirPost = function(post) {
        $scope.postAtual = post;
    };

});