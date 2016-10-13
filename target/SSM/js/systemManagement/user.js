/**
 * Created by wuxueyou on 16/10/1.
 */
var userapp = angular.module('userapp', [], function ($httpProvider) {
    baseRequest($httpProvider);
});

userapp.controller('userController', function ($scope, $http) {
    $scope.test = "aabbcc";
});
