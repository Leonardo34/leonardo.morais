app.controller('devolucao.Controller', function($scope, authService, $location, locacaoService) {
    $scope.url.path = $location.path();
    $scope.step = 1;

    $scope.adicionarCliente = function() {
        locacaoService.buscarClientePorCpf($scope.Cpf)
            .then(res => {
                $scope.cliente = res.data.data;
                $scope.step++;
                obterPedidosCliente($scope.cliente.Id);
            }, error => {
                window.alert('Erro ao buscar usuario por CPF');
            });
    }

    $scope.previous = function() {
        if ($scope.step > 1) {
            $scope.step--;
        }
    }

    $scope.entregar = function(pedido) {
        pedido = JSON.parse(pedido);
        locacaoService.entregarLocacao(pedido.Id).then(res => {
            window.alert("Pedido entregue, valor total: " + res.data.data);
            $scope.step = 1;
            delete $scope.Cpf;
            delete $scope.cliente;
            delete $scope.pedidoFinalizar;
        })
    }

    function obterPedidosCliente(idCliente) {
        locacaoService.buscarPedidosCliente(idCliente).then(res => {
            console.log(res.data.data);
            $scope.pedidos = res.data.data;
        })
    }
});