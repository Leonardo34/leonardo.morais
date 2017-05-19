var myApp = angular.module('exemplo02App', []);

myApp.filter('mascada', function() {
    return function(input) {
        return input.toLowerCase() == "nunes" ? "$ " + input + " $" : input;
    }
});

myApp.filter('aula', function() {
    return function(input) {
        return "00" + input.numero + " - " + input.nome.toUpperCase();
    }
});

myApp.controller('exemplo02Controller', function($scope) {

    $scope.instrutores = [];

    $scope.update = (instrutor) => {
        if ($scope.cadastroInstrutor.$valid) {
            $scope.instrutores.push(instrutor);
            delete $scope.instrutor;
        }
    };
});