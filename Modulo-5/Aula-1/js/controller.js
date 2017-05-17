var myApp = angular.module('tutorialAngularJS', []);

myApp.controller('TutorialController', function($scope) {
    $scope.pokemon = {nome: "Pikachu", id: 25};
});