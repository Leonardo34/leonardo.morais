var myApp = angular.module('crudApp', []);

myApp.controller('crudController', function($scope) {
    let idGenerator = 0;

    $scope.aulas = [];

    $scope.update = (aula) => {
        if ($scope.cadastroInstrutor.$valid) {
            aula.id = idGenerator++;
            $scope.aulas.push(aula);
            delete $scope.aula;
        }
    }

    $scope.remove = (aula) => {
        let indice = $scope.aulas.indexOf(aula);
        $scope.aulas.splice(indice, 1);
    }
});