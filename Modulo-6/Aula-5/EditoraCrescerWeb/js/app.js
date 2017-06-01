var app = angular.module("editoraCrescerApp", ['toastr', 'ngRoute']);

app.config(function ($routeProvider) {
  $routeProvider
    .when('/livros', {
      controller: 'editoraController',
      templateUrl: 'livros.html'
    })
    .when('/livro/{id}', {
      controller: 'livroController',
      templateUrl: 'detalhe.html'
    });
    //.otherwise({redirectTo: '/livros'});
}); 