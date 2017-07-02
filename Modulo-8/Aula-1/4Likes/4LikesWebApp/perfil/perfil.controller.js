app.controller('perfilController', function($scope, authService, postService, $routeParams, usuarioService) {
    carregarDadosUsuario($routeParams.id);
    carregarPostsUsuario($routeParams.id);
    carregarAmigosPerfil($routeParams.id);

    $scope.isAmigos = function() {
        
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
});