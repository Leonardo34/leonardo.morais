myApp.controller('aulaController', function($scope, $rootScope, $location, toastr, aulaService) {
    $rootScope.url = $location.path();
    carregarAulas();

    function carregarAulas() {
        aulaService.getAulas().then(response => {
            $rootScope.aulas = response.data;
        })
    } 

    $scope.saveAula = (aula) => {
        if (!existeAulaComNome(aula.nome)) {
            aulaService.saveAula(aula).then(() => carregarAulas());
            delete $scope.aula;
            toastr.success("Aula inserida com sucesso");
        } else {
            toastr.error("Aula já cadastrada.");
        }
    }

    $scope.removeAula = (aula) => {
        if (!aulaEstaSendoUtilizada(aula)) {
            aulaService.removeAula(aula).then(() => carregarAulas());
            toastr.success("Aula removida com sucesso");
        } else {
            toastr.error("Não é possível excluir esta aula. Está sendo utilizada.");
        }
    }

    $scope.updateAula = (aula) => {
        if (!existeAulaComNome(aula.nome)) {
            aula.id = parseInt(aula.id);
            aulaService.updateAula(aula).then(() => carregarAulas());
            delete $scope.edit;
            toastr.success("Aula atualizada com sucesso");
        } else {
            toastr.error("Aula já cadastrada.");
        }
    }

    var getAulaById = (id) => {
        let index = $scope.aulas.findIndex(a => a.id === id);
        return $scope.aulas[index];
    }

    var aulaEstaSendoUtilizada = (aula) => {
        return $scope.instrutores.some(ins => ins.aula.some(a => a == aula.id));
    }

    var existeAulaComNome = (nome) => {
        return $scope.aulas.some(a => a.nome === nome);
    }
});