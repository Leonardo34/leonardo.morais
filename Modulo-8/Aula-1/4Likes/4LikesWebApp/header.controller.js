app.controller('headerController', function($scope, authService,  $location, postService, usuarioService, toastr) { 
    $scope.url = {};
    $scope.url.path = $location.path();
    console.log(authService.getUsuario());
    $scope.isAutenticado = authService.isAutenticado;
    $scope.logout = authService.logout;
    $scope.getUsuario = authService.getUsuario;

    carregarConvitesAmizade();

    $scope.enviarPost = function() {
        postService.enviarPost($scope.post);
    }

    function carregarConvitesAmizade() {
        usuarioService.carregarConvites().then(res => {
            $scope.convites = res.data;
            console.log(res.data);
        })
    }

    $scope.aceitarConvite = function(id) {
        usuarioService.aceitarConvite(id).then(res => {
            toastr.success("Usuario adicionado com sucesso");
            carregarConvitesAmizade();
        })
    }

    $scope.rejeitarConvite = function(id) {
        usuarioService.rejeitarConvite(id).then(res => {
            carregarConvitesAmizade();
        })
    }

    $scope.buscarUsuariosPorNome = function(nome) {
        console.log(nome);
        usuarioService.carregarUsuariosPorNome(nome).then(res => {
            $scope.usuariosEncontrados = res.data;
            console.log("resposta");
            console.log(res.data);
        })
    }
});