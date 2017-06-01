app.service('livrosService', function($http) {
    this.getLivros = function() {
        return $http.get('http://localhost:49707/api/livros');
    }
});