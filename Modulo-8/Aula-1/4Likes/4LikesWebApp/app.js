var app = angular.module("4LikesApp", ['ngRoute', 'ui.bootstrap', 'auth']);

app.config(function ($routeProvider) {
    $routeProvider
    .when('/login', {
      controller: 'loginController',
      templateUrl: 'login/login.html'
    })
    .when('/feed', {
      controller: 'feedController',
      templateUrl: 'feed/feed.html'
    })
    .when('/amigos', {
      controller: 'amigosController',
      templateUrl: 'amigos/amigos.html'
    })
    .when('/perfil/:id', {
      controller: 'perfilController',
      templateUrl: 'perfil/perfil.html'
    })
});

angular.module('4LikesApp').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:9090/usuarioLogado',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/feed',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/login'
}); 

app.directive('ngEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if(event.which === 13) {
                scope.$apply(function (){
                    scope.$eval(attrs.ngEnter);
                });

                event.preventDefault();
            }
        });
    };
});
