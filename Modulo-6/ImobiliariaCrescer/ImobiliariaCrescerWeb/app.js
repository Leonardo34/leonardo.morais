var app = angular.module("imobiliariaCrescerApp", ['ngRoute', 'ui.bootstrap', 'auth']);

app.config(function ($routeProvider) {
    $routeProvider
    .when('/login', {
      controller: 'loginController',
      templateUrl: 'login/login.html'
    })
    .when('/cadastroCliente', {
      controller: 'cadastroCliente.Controller',
      templateUrl: 'cadastroCliente/cadastroCliente.html'
    })
    .when('/alugarImovel', {
      controller: 'alugarImovel.Controller',
      templateUrl: 'alugarImovel/alugarImovel.html'
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