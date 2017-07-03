app.service('usuarioService', function($http) {
 
    this.getAmigos = function() {
        return $http.get('http://localhost:9090/usuario/amigos');
    }

    this.carregarDadosUsuario = function(id) {
        return $http.get('http://localhost:9090/usuario/' + id);
    }

    this.carregarAmigos = function() {
        return $http.get('http://localhost:9090/usuario/amigos');
    }

    this.carregarAmigosByIdUsuario = function(id) {
        return $http.get('http://localhost:9090/usuario/amigos/' + id);
    }

    this.enviarConvite = function(id) {
        return $http.post('http://localhost:9090/usuario/convite/' + id);
    }

    this.aceitarConvite = function(id) {
        return $http.post('http://localhost:9090/usuario/aceitar/' + id);
    }

    this.rejeitarConvite = function(id) {
        return $http.post('http://localhost:9090/usuario/rejeitar/' + id);
    }

    
    this.carregarConvites = function() {
        return $http.get('http://localhost:9090/usuario/convites');
    }

    this.carregarUsuariosPorNome = function(nome) {
        return $http.get('http://localhost:9090/usuario/name?nome=' + nome);
    }

    this.registrarUsuario = function(usuario) {
        return $http.post('http://localhost:9090/usuario', usuario);
    }

    this.possuiConvitePendente = function(id) {
        return $http.get('http://localhost:9090/usuario/convite/pendente/' + id);
    }
});