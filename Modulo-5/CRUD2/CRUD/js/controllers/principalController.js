myApp.controller('principalController', function($scope, $rootScope, $location) {
    $rootScope.aulas = [];
    $rootScope.instrutores = [];
    $rootScope.url = $location.path();
});
