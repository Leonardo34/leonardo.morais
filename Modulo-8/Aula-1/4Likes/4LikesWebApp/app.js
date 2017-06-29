var app = angular.module("4LikesApp", ['ngRoute', 'ui.bootstrap']);

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
});
