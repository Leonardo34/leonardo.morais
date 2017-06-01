app.controller('editoraController', function($scope, livrosService) { 
    $scope.title = 'Editora Crescer'; 
    $scope.promo = '#EuSeiJavascript';
    carregarLivros();

    function carregarLivros() {
        livrosService.getLivros().then(res => {
            $scope.livros = res.data;
        })
    }
});
