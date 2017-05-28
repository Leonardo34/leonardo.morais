myApp.controller('chatController', function($scope, chatService) {
    $scope.chats = [];
    $scope.usuario = {Nome: "Leonardo", UrlImagemPerfil: "https://avatars1.githubusercontent.com/u/14354193?v=3&s=400"};
    carregarChats();

    function carregarChats() {
        chatService.getChats().then(response => {
            $scope.chats = response.data;
        })
    }
    
    function carregarChatAtual() {
        chatService.getChatById($scope.chatAtual.Id).then(res => {
            $scope.chatAtual = res.data[0];
        })
    }

    $scope.abrirChat = function(chat) {
        $scope.chatAtual = chat;
    }

    $scope.enviarMensagem = function(mensagem) {
        mensagem.Autor = $scope.usuario;
        chatService.saveMensagem(mensagem, $scope.chatAtual.Id).then(response => {
            carregarChats();
            carregarChatAtual();
        });
        delete $scope.novaMensagem;
    }

    window.setInterval(() => {
        carregarChats();
        carregarChatAtual();
    }, 1000);
});