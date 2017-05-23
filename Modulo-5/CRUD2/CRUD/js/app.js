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
