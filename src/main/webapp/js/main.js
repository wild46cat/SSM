/**
 * Created by wuxueyou on 16/10/1.
 */
//官方平滑树
function convert(rows) {
    function exists(rows, parentId) {
        for (var i = 0; i < rows.length; i++) {
            if (rows[i].ID == parentId) return true;
        }
        return false;
    }

    var nodes = [];
    // get the top level nodes
    for (var i = 0; i < rows.length; i++) {
        var row = rows[i];
        if (!exists(rows, row.PID)) {
            nodes.push({
                ID: row.ID,
                PID: row.PID,
                STATUS: row.STATUS,
                URL: row.URL,
                NAME: row.NAME
            });
        }
    }

    var toDo = [];
    for (var i = 0; i < nodes.length; i++) {
        toDo.push(nodes[i]);
    }
    while (toDo.length) {
        var node = toDo.shift();    // the parent node
        // get the children nodes
        for (var i = 0; i < rows.length; i++) {
            var row = rows[i];
            if (row.PID == node.ID) {
                var child = {
                    ID: row.ID,
                    PID: row.PID,
                    STATUS: row.STATUS,
                    URL: row.URL,
                    NAME: row.NAME
                };
                if (node.children) {
                    node.children.push(child);
                } else {
                    node.children = [child];
                }
                toDo.push(child);
            }
        }
    }
    return nodes;
};

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

app.controller('myMainController', function ($scope, $http) {
    $scope.menuURL = BASE_URL + '/web/welcome';
    $scope.goPage = function (pageUrl) {
        $scope.menuURL = BASE_URL + pageUrl;
    };

    $scope.menulist = [];

    $http.post(BASE_URL + '/app/getmenulist', {}).success(function (data) {
        if (data != null && data.list.length > 0) {
            $scope.menulist = convert(data.list);
        }
    }).error(function (data) {

    });
});
