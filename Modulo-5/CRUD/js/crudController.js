var myApp = angular.module('crudApp', []);

myApp.controller('crudController', function($scope) {
    let idAulaGenerator = 0;
    let idInstrutorGenerator = 0;

    $scope.aulas = [];
    $scope.instrutores = [];

    $scope.saveAula = (aula) => {
        if ($scope.cadastroAula.$valid && !existeAulaComNome(aula.nome)) {
            aula.id = idAulaGenerator++;
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

    $scope.saveInstrutor = (instrutor) => {
        if ($scope.cadastroInstrutor.$valid) {
            instrutor.id = idInstrutorGenerator++;
            $scope.instrutores.push(instrutor);
            delete $scope.instrutor;
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