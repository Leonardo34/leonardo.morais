app.service('livrosService', function($http) {
    this.getLivros = function(parametros) {
        return $http({
          url: 'http://localhost:49707/api/livros',
          method: 'GET',
          params: parametros
        });
    }

    this.getLivroById = function(id) {
        return $http.get('http://localhost:49707/api/livros/' + id);
    }

    this.getLancamentos = function() {
        return $http.get('http://localhost:49707/api/livros/lancamentos');
    } 

    this.salvarLivro = function(livro) {
        return $http.post('http://localhost:49707/api/livros/', livro);
    }

    this.getAllLivros = function() {
        return $http.get('http://localhost:49707/api/livros/todosLivros');
    }

    this.publicarLivro = function(id) {
        return $http.post('http://localhost:49707/api/livros/publicar/' + id);
    }
});