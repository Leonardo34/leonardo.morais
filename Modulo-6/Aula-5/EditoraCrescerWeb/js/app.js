var app = angular.module("editoraCrescerApp", ['toastr', 'ngRoute', 'ui.bootstrap', 'auth']);

app.config(function ($routeProvider) {
  $routeProvider
    .when('/livros', {
      controller: 'editoraController',
      templateUrl: 'livros.html'
    })
    .when('/livro/:id', {
      controller: 'livroController',
      templateUrl: 'detalhes.html'
    })
    .when('/login', {
      controller: 'loginController',
      templateUrl: 'login.html'
    })
    .when('/administrativo', {
      controller: 'adminController',
      templateUrl: 'administrativo.html',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/novoLivro', {
      controller: 'adminController',
      templateUrl: 'novoLivro.html',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .otherwise({redirectTo: '/livros'});
}); 

angular.module('editoraCrescerApp').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:49707/api/acessos/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/administrativo',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/livros'
});