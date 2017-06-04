app.controller('editoraController', function($scope, livrosService, $location) { 
    const livrosPorPagina = 6;
    console.log($scope.url);
    $scope.url.path = $location.path();
    $scope.paginacao = {
        take: 6,
        skip: 0,
    };

    carregarLancamentos();
    carregarLivros();

    function carregarLivros() {
        livrosService.getLivros($scope.paginacao).then(res => {
            $scope.livros = res.data.data;
            $scope.paginacao.take += livrosPorPagina;
            $scope.paginacao.skip += livrosPorPagina;
        })
    }

    function carregarLancamentos() {
        livrosService.getLancamentos().then(res => {
            $scope.lancamentos = res.data.data;
        })
    }
});
