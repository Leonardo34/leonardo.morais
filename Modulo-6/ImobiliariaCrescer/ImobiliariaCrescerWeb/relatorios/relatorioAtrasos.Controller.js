app.controller('relatorioAtrasos.Controller', function($scope, authService, $location, locacaoService) {
    $scope.url.path = $location.path();
    
    carregarPedidosAtrasados();

    function carregarPedidosAtrasados() {
        locacaoService.buscarPedidosAtrasados().then(res => {
            $scope.pedidos = res.data.data;
        })
    }
});