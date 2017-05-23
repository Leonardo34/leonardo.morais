myApp.controller('aulaController', function($scope, $rootScope, $location, toastr, aulaService) {
    $rootScope.url = $location.path();
    carregarAulas();

    function carregarAulas() {
        aulaService.getAulas().then(response => {
            $rootScope.aulas = response.data;
        })
    } 

    $scope.saveAula = (aula) => {
        aulaService.saveAula(aula).then( success => {
            carregarAulas();
            toastr.success("Aula inserida com sucesso");
            delete $scope.aula;
        }, error => {
            toastr.error("Houve um problema");
        });  
    }

    $scope.removeAula = (aula) => {
        aulaService.removeAula(aula).then( success => {
            carregarAulas();
            toastr.success("Aula removida com sucesso");
        }, error => {
            toastr.error("Houve um problema");
        });
    }

    $scope.updateAula = (aula) => {
        aula.id = parseInt(aula.id);
        aulaService.updateAula(aula).then( success => {
            carregarAulas();
            delete $scope.edit;
            toastr.success("Aula atualizada com sucesso");
        }, error => {
            toastr.error("Houve um problema");
        });
    }
});