myApp.service('mensagemService', function($http) {
    this.getMensagens = function() {
        return $http.get('http://localhost:49756/api/mensagens');
    }
});