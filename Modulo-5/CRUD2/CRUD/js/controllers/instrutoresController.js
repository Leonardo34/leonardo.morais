myApp.controller('instrutoresController', function($scope, $rootScope, $location, toastr, instrutorService) {
    let defaultImage = "http://images.complex.com/complex/image/upload/c_limit,w_680/fl_lossy,pg_1,q_auto/t5vj46jc2ecyp2ptmcfo.jpg";
    $rootScope.url = $location.path();
    carregarInstrutores();

    function carregarInstrutores() {
        instrutorService.getInstrutores().then(response => {
            $rootScope.instrutores = response.data;
        })
    }

    $scope.saveInstrutor = (instrutor) => {
        checarImagem(instrutor);
        instrutorService.saveInstrutor(instrutor).then( success => {
            carregarInstrutores();
            delete $scope.instrutor;
            toastr.success("Instrutor incluído com sucesso");
        }, error => {
            toastr.error("Houve um problema");
        });
    }

    $scope.removeInstrutor = (instrutor) => {
        instrutorService.removeInstrutor(instrutor).then( success => {
            carregarInstrutores();
            toastr.success("Instrutor removido com sucesso");
        }, error => {
            toastr.error("Houve um problema");
        });
    }

    $scope.updateInstrutor = (instrutor) => {
        instrutor.id = parseInt(instrutor.id);
        checarImagem(instrutor);
        instrutorService.updateInstrutor(instrutor).then( success => {
            carregarInstrutores();
            delete $scope.editInstrutor;
            toastr.success("Instrutor atualizado com sucesso");
        }, error => {
            toastr.error("Houve um problema");
        });
    }

    var checarImagem = (instrutor) => {
        if (typeof instrutor.image === "undefined") {
            instrutor.image = defaultImage;
        }
    }

    $scope.getAulasByIds = (ids) => $scope.aulas.filter(a => ids.some(id => id == a.id));
})