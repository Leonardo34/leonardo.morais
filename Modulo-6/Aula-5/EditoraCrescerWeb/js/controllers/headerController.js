app.controller('headerController', function($scope, authService,  $location) { 
    $scope.url = {};
    $scope.url.path = $location.path();

    $scope.isAutenticado = authService.isAutenticado;
    $scope.logout = authService.logout;
});