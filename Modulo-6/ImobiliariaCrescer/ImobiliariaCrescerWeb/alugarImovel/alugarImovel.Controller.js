app.controller('alugarImovel.Controller', function($scope, authService, $location, locacaoService) {
    $scope.url.path = $location.path();
    $scope.pedido = {};
    $scope.step = 1;

    $scope.adicionarCliente = function() {
        locacaoService.buscarClientePorCpf($scope.cliente.Cpf)
            .then(res => {
                $scope.pedido.cliente = res.data.data;
                $scope.step++;
            }, error => {
                window.alert('Erro ao buscar usuario por CPF');
            });
    }

    $scope.previous = function() {
        if ($scope.step > 1) {
            $scope.step--;
        }
    }
});