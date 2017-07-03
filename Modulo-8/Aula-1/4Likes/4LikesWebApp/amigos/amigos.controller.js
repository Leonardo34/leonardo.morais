app.controller('amigosController', function($scope, authService, usuarioService) {
    carregarAmigos();

    function carregarAmigos() {
        usuarioService.carregarAmigos().then(res => {
            $scope.amigos = res.data;
        })
    }

    $scope.removerAmigo = function(id) {
        usuarioService.removerAmigo(id).then(res => {
            carregarAmigos();
        })
    }
});