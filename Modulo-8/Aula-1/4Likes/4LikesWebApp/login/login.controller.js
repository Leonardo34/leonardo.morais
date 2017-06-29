app.controller('loginController', function($scope, $location) { 

    $scope.login = function() {
        /*authService.login($scope.usuario).then(res => {
            alert('Login com sucesso!');
        }, error => {
            alert('Erro no Login!');
        })
        */
        console.log($scope.usuario);
    }
});