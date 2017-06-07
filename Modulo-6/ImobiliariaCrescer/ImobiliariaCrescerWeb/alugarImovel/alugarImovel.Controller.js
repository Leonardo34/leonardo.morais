app.controller('alugarImovel.Controller', function($scope, authService, $location, clientesService) {
    $scope.url.path = $location.path();
});