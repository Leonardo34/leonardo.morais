var myApp = angular.module('crudApp', ['toastr', 'ngRoute']);

myApp.config(function ($routeProvider) {
  $routeProvider
    .when('/aulas', {
      controller: 'aulaController',
      templateUrl: 'aula.html'
    })
    .when('/instrutores', {
      controller: 'instrutoresController',
      templateUrl: 'instrutor.html'
    })
    .otherwise({redirectTo: '/aulas'});
});

myApp.filter('statusAula', function() {
    return function(input) {
        return input ? "Sim" : "Não";
    }
});

myApp.controller('principalController', function($scope) {
    $scope.aulas = [];
    $scope.instrutores = [];
    $scope.idAulaGenerator = {id: 0};
    $scope.idInstrutorGenerator = {id: 0};
});

myApp.controller('aulaController', function($scope, toastr) {

    $scope.saveAula = (aula) => {
        if (!existeAulaComNome(aula.nome)) {
            aula.id = $scope.idAulaGenerator.id++;
            $scope.aulas.push(aula);
            delete $scope.aula;
            toastr.success("Aula inserida com sucesso");
        } else {
            toastr.error("Aula já cadastrada.");
        }
    }

    $scope.removeAula = (aula) => {
        if (!aulaEstaSendoUtilizada(aula)) {
            let indice = $scope.aulas.indexOf(aula);
            $scope.aulas.splice(indice, 1);
            toastr.success("Aula removida com sucesso");
        } else {
            toastr.error("Não é possível excluir esta aula. Está sendo utilizada.");
        }
    }

    $scope.updateAula = (aula) => {
        if (!existeAulaComNome(aula.nome)) {
            aula.id = parseInt(aula.id);
            let aulaUpdate = getAulaById(aula.id);
            aulaUpdate.nome = aula.nome;
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

myApp.controller('instrutoresController', function($scope, toastr) {
    let defaultImage = "http://images.complex.com/complex/image/upload/c_limit,w_680/fl_lossy,pg_1,q_auto/t5vj46jc2ecyp2ptmcfo.jpg";

    $scope.saveInstrutor = (instrutor) => {
        if (!existeInstrutorComNome(instrutor.nome, instrutor.sobrenome) &&
                !existeInstrutorComEmail(instrutor.email)) {
            instrutor.id = $scope.idInstrutorGenerator.id++;
            checarImagem(instrutor);
            $scope.instrutores.push(instrutor);
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
            let indice = $scope.instrutores.indexOf(instrutor);
            $scope.instrutores.splice(indice, 1);
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
            let index = getIndexInstrutorById(instrutor.id);
            $scope.instrutores[index] = instrutor;
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