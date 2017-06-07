app.controller('cadastroCliente.Controller', function($scope, authService, $location, clientesService) {
    $scope.url.path = $location.path();

    $scope.cadastrarCliente = function() {
        clientesService.salvarCliente($scope.cliente).then(res => {
            window.alert('foi');
        })
    };
});