myApp.service('aulaService', function($http) {
    this.getAulas = function() {
        return $http.get('http://localhost:3000/aulas');
    }

    this.saveAula = function(aula) {
        return $http.post('http://localhost:3000/aulas', aula);
    }

    this.updateAula = function(aula) {
        return $http.put('http://localhost:3000/aulas/' + aula.id, aula);
    }

    this.removeAula = function(aula) {
        return $http.delete('http://localhost:3000/aulas/' + aula.id);
    }
});

myApp.service('instrutorService', function($http) {
    this.getInstrutores = function() {
        return $http.get('http://localhost:3000/instrutores');
    }

    this.saveInstrutor = function(instrutor) {
        return $http.post('http://localhost:3000/instrutores', instrutor);
    }

    this.updateInstrutor = function(instrutor) {
        return $http.put('http://localhost:3000/instrutores/' + instrutor.id, instrutor);
    }

    this.removeInstrutor = function(instrutor) {
        return $http.delete('http://localhost:3000/instrutores/' + instrutor.id);
    }
})