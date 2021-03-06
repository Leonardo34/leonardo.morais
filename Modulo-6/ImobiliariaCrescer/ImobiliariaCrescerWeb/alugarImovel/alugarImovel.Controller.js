app.controller('alugarImovel.Controller', function($scope, authService, $location, locacaoService) {
    $scope.url.path = $location.path();
    $scope.pedido = {};
    $scope.step = 1;

    $scope.adicionarCliente = function() {
        locacaoService.buscarClientePorCpf($scope.cliente.Cpf)
            .then(res => {
                $scope.pedido.Cliente = res.data.data;
                $scope.step++;
                obterImoveisDisponiveis();
            }, error => {
                window.alert('Erro ao buscar usuario por CPF');
            });
    }

    $scope.selecionarImovel = function(tipoImovel) {
        $scope.step++;
        $scope.pedido.Imovel = JSON.parse(tipoImovel);
        obterCombosDisponiveis($scope.pedido.Imovel.Id);
    }

    $scope.selecionarCombo = function(combo) {
        $scope.step++;
        $scope.pedido.Combo = JSON.parse(combo);
        obterAdicionaisDisponiveis();
    }

    $scope.adicionarAdicionais = function(adicionais) {
        $scope.step++;
        $scope.pedido.Adicionais = adicionais.map(a => JSON.parse(a));
        console.log($scope.pedido);
    }

    $scope.confirmarPedido = function(diasAluguel) {
        $scope.pedido.diasAluguel = parseInt(diasAluguel);
        console.log($scope.pedido);
        locacaoService.confirmarLocacao($scope.pedido).then(res => {
            $scope.step = 1;
            delete $scope.cliente;
            delete $scope.tipoImovel;
            delete $scope.Combo;
            delete $scope.AdicionaisSelecionados;
            delete $scope.diasAluguel;
            window.alert("Pedido confirmado com sucesso");
        }, err => {
            window.alert("Problema ao realizar confirmação da locação");
        });
    }

    $scope.previous = function() {
        if ($scope.step > 1) {
            $scope.step--;
        }
    }

    function obterImoveisDisponiveis() {
        locacaoService.buscarImoveis().then(res => {
            $scope.imoveis = res.data.data;
        }) 
    }

    function obterCombosDisponiveis(idImovel) {
        locacaoService.buscarCombos(idImovel).then(res => {
            $scope.combos = res.data.data;
        })
    }

    function obterAdicionaisDisponiveis() {
        locacaoService.buscarAdicionais().then(res => {
            $scope.adicionais = res.data.data;
        })
    }
});