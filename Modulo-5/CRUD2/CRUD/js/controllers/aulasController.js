myApp.controller('aulaController', function($scope, $rootScope, $location, toastr, aulaService) {
    $rootScope.url = $location.path();
    carregarAulas();

    function carregarAulas() {
        aulaService.getAulas().then(response => {
            $rootScope.aulas = response.data;
        })
    } 

    $scope.saveAula = (aula) => {
        aulaService.saveAula(aula).then(function(success) {
            carregarAulas();
            toastr.success("Aula inserida com sucesso");
            delete $scope.aula;
        }, function(error) {
            toastr.error("Houve um problema");
        });  
    }

    $scope.removeAula = (aula) => {
        aulaService.removeAula(aula).then(function(success) {
            carregarAulas();
            toastr.success("Aula removida com sucesso");
        }, function(error) {
            toastr.error("Houve um problema");
        });
    }

    $scope.updateAula = (aula) => {
        aula.id = parseInt(aula.id);
        aulaService.updateAula(aula).then(function(success) {
            carregarAulas();
            delete $scope.edit;
            toastr.success("Aula atualizada com sucesso");
        }, function(error) {
            toastr.error("Houve um problema");
        });
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