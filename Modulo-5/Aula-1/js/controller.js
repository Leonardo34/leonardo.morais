var myApp = angular.module('tutorialAngularJS', []);

myApp.controller('TutorialController', function($scope) {
    $scope.pokemons = [
        {nome: "Pikachu", id: 25},
        {nome: "Mewtwo", id: 150},
        {nome: "Mew", id: 151},
    ]
});