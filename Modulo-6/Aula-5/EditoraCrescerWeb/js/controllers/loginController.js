app.controller('loginController', function($scope, authService) { 
    $scope.login = function() {
        console.log("opa");
        authService.login($scope.usuario).then(res => {
            console.log(res);
            alert('Login com sucesso!');
        }, error => {
            console.log(error);
            alert('Erro no Login!');
        })
    }
});