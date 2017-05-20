var myApp = angular.module('crudApp', []);

myApp.controller('crudController', function($scope) {
    let idGenerator = 0;

    $scope.aulas = [];

    $scope.update = (aula) => {
        if ($scope.cadastroAula.$valid) {
            aula.id = idGenerator++;
            $scope.aulas.push(aula);
            delete $scope.aula;
        }
    }

    $scope.remove = (aula) => {
        let indice = $scope.aulas.indexOf(aula);
        $scope.aulas.splice(indice, 1);
    }

    $scope.alter = (aula) => {
        if ($scope.alterarAula.$valid) {
            let index = $scope.aulas.findIndex(a => a.id === parseInt(aula.id));
            $scope.aulas[index].nome = aula.nome;
            delete $scope.edit;
        }
    }
});