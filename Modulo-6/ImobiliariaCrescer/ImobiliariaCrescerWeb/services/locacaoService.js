app.service('locacaoService', function($http) {
 
    this.buscarClientePorCpf = function(cpf) {
        return $http.get('http://localhost:50573/api/clientes?cpf=' + cpf);
    }
});