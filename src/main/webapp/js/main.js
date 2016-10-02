/**
 * Created by wuxueyou on 16/10/1.
 */
var app = angular.module('myMain', [], function ($httpProvider) {
    baseRequest($httpProvider);
});

app.controller('myMainController', function ($scope, $http) {
    $scope.test="hello main.jsp";
});
