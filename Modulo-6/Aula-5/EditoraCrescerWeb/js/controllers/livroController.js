app.controller('livroController', function($scope, livrosService, $routeParams) { 
    carregarLivro();

    function carregarLivro() {
        livrosService.getLivroById($routeParams.id).then(res => {
            $scope.livro = res.data.data;
            console.log(res);
        })
    }
});