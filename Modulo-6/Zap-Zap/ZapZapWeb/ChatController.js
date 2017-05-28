myApp.controller('chatController', function($scope, chatService) {
    $scope.chats = [];
    carregarChats();

    function carregarChats() {
        chatService.getMensagens().then(response => {
            $scope.chats = response.data;
            console.log($scope.chats);
        })
    }

    $scope.carregarChats = function(chat) {
        $scope.chatAtual = chat;
    }
});