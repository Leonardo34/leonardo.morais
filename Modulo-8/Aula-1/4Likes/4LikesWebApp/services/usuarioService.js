app.service('usuarioService', function($http) {
 
    this.getAmigos = function() {
        return $http.get('http://localhost:9090/usuario/amigos');
    }
});