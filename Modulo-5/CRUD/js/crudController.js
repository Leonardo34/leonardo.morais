var myApp = angular.module('crudApp', []);

myApp.controller('crudController', function($scope) {
    let idGenerator = 0;

    $scope.aulas = [];
    $scope.instrutores = [];

    $scope.saveAula = (aula) => {
        if ($scope.cadastroAula.$valid && !existeAulaComNome(aula.nome)) {
            aula.id = idGenerator++;
            $scope.aulas.push(aula);
            delete $scope.aula;
        }
    }

    $scope.removeAula = (aula) => {
        let indice = $scope.aulas.indexOf(aula);
        $scope.aulas.splice(indice, 1);
    }

    $scope.updateAula = (aula) => {
        if ($scope.alterarAula.$valid && !existeAulaComNome(aula.nome)) {
            let aulaUpdate = getAulaById(parseInt(aula.id));
            aulaUpdate.nome = aula.nome;
            delete $scope.edit;
        }
    }

    var getAulaById = (id) => {
        let index = $scope.aulas.findIndex(a => a.id === id);
        return $scope.aulas[index];
    }

    var existeAulaComNome = (nome) => {
        return $scope.aulas.some(a => a.nome === nome);
    }
});