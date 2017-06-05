app.controller('adminController', function($scope, livrosService, toastr, $location, authService) { 
    $scope.url.path = $location.path();

    $scope.enviarLivro = function() {
        livrosService.salvarLivro($scope.novoLivro).then(res => {
            toastr.success("Livro Adicionado com sucesso");
            delete $scope.novoLivro;
        }, error => {
            toastr.error("Falha ao adicionar Livro");
        });
    }

    carregarLivros();

    function carregarLivros() {
        livrosService.getAllLivros($scope.paginacao).then(res => {
            $scope.livros = res.data.data;
            console.log($scope.livros);
        })
    }

    $scope.getUsuario = authService.getUsuario;
    $scope.possuiPermissao = authService.possuiPermissao;

    $scope.publicar = function(id) {
        livrosService.publicarLivro(id).then(res => {
            toastr.success("Livro publicado com sucesso");
        })
    }

    $scope.revisar = function() {

    }

    $scope.excluirLivro = function() {
        
    }
});
