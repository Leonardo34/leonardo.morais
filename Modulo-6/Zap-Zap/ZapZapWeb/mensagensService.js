myApp.service('chatService', function($http) {
    this.getChats = function() {
        return $http.get('http://localhost:49756/api/chat');
    }

    this.saveMensagem = function(mensagem, chatId) {
        $http.post('http://localhost:49756/api/chat/' + chatId, mensagem);
    }
});