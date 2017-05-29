myApp.controller('chatController', function($scope, chatService) {
    $scope.chats = [];
    carregarUsuarioSessao();
    carregarChats();
    $scope.usuario = {Nome: localStorage.getItem("nomeUsuario"), UrlImagemPerfil: localStorage.getItem("urlImagem")};

    function carregarChats() {
        chatService.getChats().then(response => {
            $scope.chats = response.data;
        })
    }
    
    function carregarChatAtual(procurarMensagemNaoLida = false) {
        chatService.getChatById($scope.chatAtual.Id).then(res => {
            $scope.chatAtual = res.data[0];
        })
    }

    function recebeuNovaMensagem(newChat, oldChat) {
        return newChat.Mensagens.length > oldChat.Mensagens.length;
    }

    function carregarUsuarioSessao() {
        if (typeof localStorage.usuario === "undefined") {
            localStorage.setItem("nomeUsuario", prompt("Digite seu apelido"));
            localStorage.setItem("urlImagem", prompt("Digite o endereço da sua foto de perfil"));
        }
    }

    function buscarNovasMensagens(id) {
        chatService.getChatById(id).then(res => {
            if (recebeuNovaMensagem(res.data[0], $scope.chatAtual)) {
                var audio = new Audio('audio/alert.mp3');
                audio.play();
            }
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
        if (typeof $scope.chatAtual !== "undefined") {
            buscarNovasMensagens($scope.chatAtual.Id);
        }
    }, 1000);
});