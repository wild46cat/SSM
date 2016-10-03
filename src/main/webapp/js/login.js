/**
 * Created by wuxueyou on 16/10/1.
 */
var app = angular.module('myLogin', [], function ($httpProvider) {
    baseRequest($httpProvider);
});

app.controller('myLoginController', function ($scope, $http) {
    $scope.myLoginParams = {
        username: 'a',
        password: '1'
    };
    $scope.goLogin = function () {
        var param = {
            username: $scope.myLoginParams.username,
            password: $scope.myLoginParams.password
        };
        $http.post(BASE_URL + '/login/ssmlogin', param).success(function (data) {
            if(data != null){
                if(data.resCode == 1){
                    //alert(MSG_LOGINSUCCESS);
                    window.location.replace(BASE_URL + '/web/main');
                }else{
                    alert(MSG_LOGINERROR);
                }
            }
        }).error(function (data) {
            alert(MSG_ERROR);
        });
    };
    $scope.goClean = function(){
        $scope.myLoginParams = {
            username: '',
            password: ''
        };
    }

});
