app.service('clientesService', function($http) {
 
    this.salvarCliente = function(cliente) {
        return $http.post('http://localhost:50573/api/clientes', cliente);
    }
});