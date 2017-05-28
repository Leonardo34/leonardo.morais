myApp.controller('chatController', function($scope, chatService) {
    $scope.chats = [];
    $scope.usuario = {Nome: "Leonarfo", UrlImagemPerfil: "agsuasuahs"};
    carregarChats();

    function carregarChats() {
        chatService.getChats().then(response => {
            $scope.chats = response.data;
            console.log($scope.chats);
        })
    }

    $scope.abrirChat = function(chat) {
        $scope.chatAtual = chat;
    }

    $scope.enviarMensagem = function(mensagem) {
        mensagem.Autor = $scope.usuario;
        chatService.saveMensagem(mensagem, $scope.chatAtual.Id);
        carregarChats();
    }
});