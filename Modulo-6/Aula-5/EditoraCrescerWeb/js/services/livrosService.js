app.service('livrosService', function($http) {
    this.getLivros = function() {
        return $http.get('http://localhost:49707/api/livros');
    }

    this.getLivroById = function(id) {
        return $http.get('http://localhost:49707/api/livros/' + id);
    } 
});