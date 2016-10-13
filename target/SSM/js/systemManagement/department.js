/**
 * Created by wuxueyou on 16/10/1.
 */
var departmentapp = angular.module('departmentapp', [], function ($httpProvider) {
    baseRequest($httpProvider);
});

//官方平滑树
function convert(rows) {
    function exists(rows, parentId) {
        for (var i = 0; i < rows.length; i++) {
            if (rows[i].id == parentId) return true;
        }
        return false;
    }

    var nodes = [];
    // get the top level nodes
    for (var i = 0; i < rows.length; i++) {
        var row = rows[i];
        if (!exists(rows, row.parentId)) {
            nodes.push({
                id: row.id,
                text: row.name,
                memo: row.memo
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
            if (row.parentId == node.id) {
                var child = {id: row.id, text: row.name, memo: row.memo};
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
}

departmentapp.controller('departmentController', function ($scope, $http) {
    $('#mytree').tree({
        loadFilter: function (rows) {
            return convert(rows);
        }
    });

    $scope.departmentList = [];
    $scope.loadTreeData = function () {
        $http.post(BASE_URL + '/app/departmentlist', {}).success(function (data) {
            if (data != null && data.list.length > 0) {
                $scope.departmentList = data.list;
                $('#mytree').tree('loadData', $scope.departmentList);
            } else {
                $scope.departmentList = [];
            }
        }).error(function (data) {

        });
    };
    $scope.loadTreeData();

    $('#mytree').tree({
        onClick: function (node) {
            alert(node.id + '----' + node.text + '----' + node.memo);  // alert node text property when clicked
        }
    });

    $scope.add = function () {
        var selectedNode = $('#mytree').tree('getSelected');
        if (selectedNode != null) {
            alert(selectedNode.id);
            $('#dlg').dialog('open');
        } else {
            alert('请先选中节点');
        }
    };

    //refresh
    $scope.refresh = function () {
        $scope.loadTreeData();
    };
    //delete
    $scope.delete = function () {
        alert(123);
    };
    $scope.edit = function(){
        alert(222);
    };

});

var executeadd = function () {
    alert(123);
};

var executecancel = function () {
    $('#dlg').dialog('close');
};
