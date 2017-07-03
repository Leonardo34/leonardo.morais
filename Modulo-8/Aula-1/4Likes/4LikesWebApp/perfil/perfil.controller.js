app.controller('perfilController', function($scope, authService, postService, $routeParams, usuarioService, toastr, $route) {
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
            $route.reload();
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
            checarConvitePendente();
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

    $scope.isUsuarioLogado = function(usuario) {
        return usuario.id == authService.getUsuario().id;
    }

    function checarConvitePendente() {
        usuarioService.possuiConvitePendente($scope.usuario.id).then(res => {
            $scope.convitePendente = res.data;
        })
    }
});