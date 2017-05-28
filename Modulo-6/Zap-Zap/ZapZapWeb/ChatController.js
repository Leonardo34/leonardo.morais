myApp.controller('chatController', function($scope, mensagemService) {
    $scope.mensagens = [];
    carregarMensagens();

    function carregarMensagens() {
        mensagemService.getMensagens().then(response => {
            $scope.mensagens = response.data;
            console.log($scope.mensagens);
        })
    }
});