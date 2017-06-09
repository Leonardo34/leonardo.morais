var app = angular.module("imobiliariaCrescerApp", ['ngRoute', 'ui.bootstrap', 'auth']);

app.config(function ($routeProvider) {
    $routeProvider
    .when('/login', {
      controller: 'loginController',
      templateUrl: 'login/login.html',
      css: 'styless/styless.css'
    })
    .when('/cadastroCliente', {
      controller: 'cadastroCliente.Controller',
      templateUrl: 'cadastroCliente/cadastroCliente.html',
      css: 'styless/styless.css',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/devolverImovel', {
      controller: 'devolucao.Controller',
      templateUrl: 'devoluçaoImovel/devolucao.html',
      css: 'styless/styless.css',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/relatorioMensal', {
      controller: 'relatorioMensal.Controller',
      templateUrl: 'relatorios/relatorioMensal.html',
      css: 'styless/styless.css',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/alugarImovel', {
      controller: 'alugarImovel.Controller',
      templateUrl: 'alugarImovel/alugarImovel.html',
      css: 'styless/styless.css',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    });
});

angular.module('imobiliariaCrescerApp').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:50573/api/acessos/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/alugarImovel',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/login'
}); 