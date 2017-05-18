var myApp = angular.module('dataApp', []);

myApp.controller('dataController', function($scope, $filter) {
    var alertFunction = (data) => {
        let info = data.split("/");
        let date = new Date(parseInt(info[2]), parseInt(info[1]) - 1, parseInt(info[0]));
        $scope.date = $filter('date')(date, 'shortDate');
        console.log($scope.date);
    };

    $scope.alert = alertFunction;
});