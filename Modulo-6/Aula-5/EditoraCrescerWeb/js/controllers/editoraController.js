app.controller('editoraController', function($scope, livrosService, toastr, $location) { 
    const livrosPorPagina = 6;
    $scope.url.path = $location.path();

    $scope.paginacao = {
        take: livrosPorPagina,
        skip: 0,
    };

    $scope.previous = function() {
        $scope.paginacao.skip -= livrosPorPagina;
        carregarLivros();
    }

    $scope.next = function() {
        $scope.paginacao.skip += livrosPorPagina;
        carregarLivros();
    }

    carregarLancamentos();
    carregarLivros();

    function carregarLivros() {
        livrosService.getLivros($scope.paginacao).then(res => {
            $scope.livros = res.data.data;
        })
    }

    function carregarLancamentos() {
        livrosService.getLancamentos().then(res => {
            $scope.lancamentos = res.data.data;
        })
    }
});
