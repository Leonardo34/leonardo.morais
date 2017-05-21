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
        if ($scope.cadastroInstrutor.$valid && !existeInstrutorComNome(instrutor.nome)) {
            instrutor.id = idInstrutorGenerator++;
            if (typeof instrutor.image === "undefined") {
                instrutor.image = "http://images.complex.com/complex/image/upload/c_limit,w_680/fl_lossy,pg_1,q_auto/t5vj46jc2ecyp2ptmcfo.jpg";
            }
            $scope.instrutores.push(instrutor);
            delete $scope.instrutor;
        } else {
            window.alert("O formulário contém problemas");
        }
    }

    $scope.removeInstrutor = (instrutor) => {
        if (!instrutor.dandoAula) {
            let indice = $scope.instrutores.indexOf(instrutor);
            $scope.instrutores.splice(indice, 1);
        } else {
            window.alert("Não é possível excluir este instrutor. Está dando aula.");
        }
    }

    $scope.updateInstrutor = (instrutor) => {
        if ($scope.editarInstrutor.$valid) {
            let index = getIndexInstrutorById(parseInt(instrutor.id));
            $scope.instrutores[index] = instrutor;
            delete $scope.editInstrutor;
        }
    }

    var getAulaById = (id) => {
        let index = $scope.aulas.findIndex(a => a.id === id);
        return $scope.aulas[index];
    }

    var getIndexInstrutorById = (id) => {
        return $scope.instrutores.findIndex(ins => ins.id === id);
    }

    var existeAulaComNome = (nome) => {
        return $scope.aulas.some(a => a.nome === nome);
    }

    var existeInstrutorComNome = (nome) => {
        return $scope.instrutores.some(ins => ins.nome === nome);
    }
});