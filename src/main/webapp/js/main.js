/**
 * Created by wuxueyou on 16/10/1.
 */
var app = angular.module('myMain', [], function ($httpProvider) {
    baseRequest($httpProvider);
});

/*app.config(['$routeProvider', '$stateProvider', '$urlRouterProvider', function ($routeProvider, $stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when("", "/404");
    $stateProvider
        .state('/', {template: 'hello world'})
        .state('/ttt',{
            templateUrl:'/ttt/ttt.html',
            controller:'tttController'
        })
}]);*/

app.controller('myMainController', function ($scope, $http){
    $scope.menuURL =BASE_URL + '/web/welcome';
    $scope.goPage = function(pageUrl){
        $scope.menuURL = BASE_URL + pageUrl;
    }
});
