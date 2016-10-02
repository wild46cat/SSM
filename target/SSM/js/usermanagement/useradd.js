/**
 * Created by wuxueyou on 16/10/1.
 */
var useraddapp = angular.module('useradd', [], function ($httpProvider) {
    baseRequest($httpProvider);
});

useraddapp.controller('useraddController', function ($scope, $http) {
    $scope.test = "aabbcc";
});
