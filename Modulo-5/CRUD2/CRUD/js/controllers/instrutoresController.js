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
        if (!existeInstrutorComNome(instrutor.nome, instrutor.sobrenome) &&
                !existeInstrutorComEmail(instrutor.email)) {
            checarImagem(instrutor);
            instrutorService.saveInstrutor(instrutor).then(() => carregarInstrutores());
            delete $scope.instrutor;
            toastr.success("Instrutor incluído com sucesso");
        } else if (existeInstrutorComNome(instrutor.nome, instrutor.sobrenome)) {
            toastr.error("Instrutor já cadastrado.");
        } else {
            toastr.error("Email já está sendo utilizado.");
        }
    }

    $scope.removeInstrutor = (instrutor) => {
        if (!instrutor.dandoAula) {
            instrutorService.removeInstrutor(instrutor).then(() => carregarInstrutores());
            toastr.success("Instrutor removido com sucesso");
        } else {
            toastr.error("Não é possível excluir este instrutor. Está dando aula.");
        }
    }

    $scope.updateInstrutor = (instrutor) => {
        instrutor.id = parseInt(instrutor.id);
        if (!existeInstrutorComNome(instrutor.nome, instrutor.sobrenome, instrutor.id) &&
                !existeInstrutorComEmail(instrutor.email, instrutor.id)) {
            checarImagem(instrutor);
            instrutorService.updateInstrutor(instrutor).then(() => carregarInstrutores());
            delete $scope.editInstrutor;
            toastr.success("Instrutor atualizado com sucesso");
        } else if (existeInstrutorComNome(instrutor.nome, instrutor.sobrenome, instrutor.id)) {
            toastr.error("Instrutor já cadastrado.");
        } else {
            toastr.error("Email já está sendo utilizado.");
        }
    }

    var existeInstrutorComNome = (nome, sobrenome, id = -1) => {
        return $scope.instrutores.some(ins => 
                ins.nome === nome && 
                ins.sobrenome === sobrenome &&
                ins.id !== id);
    }

    var existeInstrutorComEmail = (email, id = -1) => {
        return $scope.instrutores.some(ins => ins.email === email && ins.id !== id);
    }

    var checarImagem = (instrutor) => {
        if (typeof instrutor.image === "undefined") {
            instrutor.image = defaultImage;
        }
    }

    var getIndexInstrutorById = (id) => {
        return $scope.instrutores.findIndex(ins => ins.id === id);
    }

    $scope.getAulasByIds = (ids) => $scope.aulas.filter(a => ids.some(id => id == a.id));
})