app.controller('relatorioMensal.Controller', function($scope, authService, $location, locacaoService) {
    $scope.url.path = $location.path();
    
    carregarRelatorio();

    function carregarRelatorio() {
        locacaoService.buscarRelatorioMensal().then(res => {
            $scope.pedidos = res.data.data;
            calcularRendaMensal($scope.pedidos);
        })
    }

    function calcularRendaMensal(pedidos) {
        $scope.rendaMensal = pedidos.reduce((sum, ped) => sum + ped.TotalPago, 0);
    }
});