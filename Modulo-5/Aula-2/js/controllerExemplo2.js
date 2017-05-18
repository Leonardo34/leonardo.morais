var myApp = angular.module('exemplo02App', []);

myApp.filter('mascada', function() {
    return function(input) {
        return input.toLowerCase() == "nunes" ? "$ " + input + " $" : input;
    }
});

myApp.controller('exemplo02Controller', function($scope) {

    let instrutores = [{
        nome: 'Bernardo',
        aula: [{
            numero: 1,
            nome: 'OO'
        },
        {
            numero: 4,
            nome: 'Javascript'
        }]
    },
    {
        nome: 'Nunes',
        aula: [{
            numero: 2,
            nome: 'Banco de Dados I'
        }]
    },
    {
        nome: 'Pedro (PHP)',
        aula: [{
            numero: 3,
            nome: 'HTML e CSS'
        }]
    },
    {
        nome: 'Zanatta',
        aula: [{
            numero: 5,
            nome: 'AngularJS'
        }]
    }];

    $scope.instrutores = instrutores;
});