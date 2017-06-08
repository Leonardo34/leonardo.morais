app.service('locacaoService', function($http) {
 
    this.buscarClientePorCpf = function(cpf) {
        return $http.get('http://localhost:50573/api/clientes?cpf=' + cpf);
    }

    this.buscarImoveis = function() {
        return $http.get('http://localhost:50573/api/imoveis');
    }

    this.buscarCombos = function(idImovel) {
        return $http.get('http://localhost:50573/api/combos/disponiveis/' + idImovel);
    }

    this.buscarAdicionais = function() {
        return $http.get('http://localhost:50573/api/adicionais');
    }

    this.confirmarLocacao = function(pedido) {
        console.log(pedido);
        return $http.post('http://localhost:50573/api/pedidos', pedido);
    }
});