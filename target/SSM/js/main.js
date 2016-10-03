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
    $scope.goUserAdd = function(){
        $scope.menuURL = BASE_URL + '/web/useradd';
    };
    $scope.goFileUpload = function () {
       $scope.menuURL = BASE_URL + "/web/common/fileupload";
    }
});
