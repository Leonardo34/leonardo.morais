app.controller('perfilController', function($scope, authService, postService, $routeParams, usuarioService, toastr, $route) {
    carregarDadosUsuario($routeParams.id);
    carregarPostsUsuario($routeParams.id);
    carregarAmigosPerfil($routeParams.id);

    $scope.isAmigos = function() {
        let usuarioLogado = authService.getUsuario();
        return $scope.amigos.some(a => a.id == usuarioLogado.id);
    }

    $scope.enviarConvite = function(id) {
        usuarioService.enviarConvite(id).then(res => {
            toastr.success("Convite enviado para " + $scope.usuario.nome);
            $route.reload();
        })
    }

    function carregarPostsUsuario(id) {
        postService.getPostsByUser(id).then(res => {
            $scope.posts = res.data;
        });
    }

    function carregarDadosUsuario(id) {
        usuarioService.carregarDadosUsuario(id).then(res => {
            $scope.usuario = res.data;
            checarConvitePendente();
        });
    }

    function carregarAmigosPerfil(id) {
        usuarioService.carregarAmigosByIdUsuario(id).then(res => {
            $scope.amigos = res.data;
        })
    }

    $scope.abrirPost = function(post) {
        $scope.postAtual = post;
    };

    $scope.isUsuarioLogado = function(usuario) {
        return usuario.id == authService.getUsuario().id;
    }

    $scope.editarInformacoes = function(usuario) {
        usuarioService.updateUsuario(usuario).then(res => {
            $route.reload();
        })
    }

    function checarConvitePendente() {
        usuarioService.possuiConvitePendente($scope.usuario.id).then(res => {
            $scope.convitePendente = res.data;
        })
    }
});