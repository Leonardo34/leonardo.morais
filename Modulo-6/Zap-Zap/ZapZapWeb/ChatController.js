myApp.controller('chatController', function($scope, chatService) {
    $scope.chats = [];
    $scope.usuario = {Nome: prompt("Digite seu apelido"), UrlImagemPerfil: prompt("Url de sua foto de perfil")};
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