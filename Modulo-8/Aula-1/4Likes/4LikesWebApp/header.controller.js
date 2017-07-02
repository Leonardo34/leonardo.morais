app.controller('headerController', function($scope, authService,  $location, postService) { 
    $scope.url = {};
    $scope.url.path = $location.path();
    console.log(authService.getUsuario());
    $scope.isAutenticado = authService.isAutenticado;
    $scope.logout = authService.logout;
    $scope.getUsuario = authService.getUsuario;

    $scope.enviarPost = function() {
        postService.enviarPost($scope.post);
    }
});