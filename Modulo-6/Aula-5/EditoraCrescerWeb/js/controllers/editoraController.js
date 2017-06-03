app.controller('editoraController', function($scope, livrosService) { 
    $scope.title = 'Editora Crescer'; 
    $scope.promo = '#EuSeiJavascript';
    carregarLancamentos();
    carregarLivros();

    function carregarLivros() {
        livrosService.getLivros().then(res => {
            $scope.livros = res.data.data;
        })
    }

    function carregarLancamentos() {
        livrosService.getLancamentos().then(res => {
            $scope.lancamentos = res.data.data;
        })
    }
});
