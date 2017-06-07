app.service('locacaoService', function($http) {
 
    this.buscarClientePorCpf = function(cpf) {
        return $http.get('http://localhost:50573/api/clientes?cpf=' + cpf);
    }

    this.buscarImoveis = function() {
        return $http.get('http://localhost:50573/api/imoveis');
    }

    this.buscarCombos = function() {
        return $http.get('http://localhost:50573/api/combos');
    }

    this.buscarAdicionais = function() {
        return $http.get('http://localhost:50573/api/adicionais');
    }
});