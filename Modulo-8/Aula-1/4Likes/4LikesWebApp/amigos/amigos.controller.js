app.controller('amigosController', function($scope, authService, usuarioService, $location) {
    $scope.url.path = $location.path();
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