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
                memo: row.memo,
                parentName: row.parentName,
                orderNumber: row.ordernumber,
                parentId: row.parentId
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
                var child = {
                    id: row.id,
                    text: row.name,
                    memo: row.memo,
                    parentName: row.parentName,
                    orderNumber: row.ordernumber,
                    parentId: row.parentId
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
}

//某一节点下的所有子节点
function getChildren(id/*节点ID*/){
    var $tree = $('#mytree');
    var node = $tree.tree('find',id);
    var childrenNodes = $tree.tree('getChildren',node.target);
    return childrenNodes;
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
            //alert(node.id + '----' + node.text + '----' + node.memo);  // alert node text property when clicked
        }
    });

    //添加弹框
    $scope.add = function () {
        var selectedNode = $('#mytree').tree('getSelected');
        if (selectedNode != null) {
            $('#dlg').dialog('open');
            $('#nodename').textbox('setValue', '');
            $('#parentnodecode').textbox('setValue', selectedNode.id);
            $('#parentnode').textbox('setValue', selectedNode.text);
            $('#memo').textbox('setValue', '');
            $('#order').textbox('setValue', '');
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
        var selectedNode = $('#mytree').tree('getSelected');
        if (selectedNode != null) {
            var nodeid = selectedNode.id;
            if (!$('#mytree').tree('isLeaf', selectedNode.target)) {
                if (confirm('删除该部门,可能会删除其中的子部门,确认删除?')) {
                    var childnodes = getChildren(nodeid);
                    var childnodesidarray = [];
                    childnodesidarray.push(nodeid);
                    angular.forEach(childnodes, function (data,index,array) {
                        childnodesidarray.push(data.id);
                    });
                    $http.post(BASE_URL + '/app/departmentdeletecascade', {depid: JSON.stringify(childnodesidarray)}).success(function (data) {
                        if (data != null && data.resCode > 0) {
                            alert('删除成功');
                            $scope.loadTreeData();
                        } else {
                            alert('删除失败');
                        }
                    }).error(function (data) {

                    });
                } else {
                }
                return;
            }
            $http.post(BASE_URL + '/app/departmentdelete', {depid: nodeid}).success(function (data) {
                if (data != null && data.resCode > 0) {
                    alert('删除成功');
                    $scope.loadTreeData();
                } else {
                    alert('删除失败');
                }
            }).error(function (data) {

            });
        } else {
            alert('请先选中节点');
        }
    };
    //edit
    $scope.edit = function () {
        var selectedNode = $('#mytree').tree('getSelected');
        if (selectedNode != null) {
            $('#dlgedit').dialog('open');
            $('#nowid').textbox('setValue', selectedNode.id);
            $('#nodenameedit').textbox('setValue', selectedNode.text);
            $('#parentnodecodeedit').textbox('setValue', selectedNode.parentId);
            $('#memoedit').textbox('setValue', selectedNode.memo);
            $('#orderedit').textbox('setValue', selectedNode.orderNumber);

            $('#parentdepcombotree').combotree({
                data: $scope.departmentList,
                loadFilter: function (rows) {
                    return convert(rows);
                },
                value: selectedNode.parentName,
                onSelect: function (node) {
                    //alert(node.id + '   ' + node.text);
                    $('#parentnodecodeedit').textbox('setValue', node.id);
                }
            });
        } else {
            alert('请先选中节点');
        }
    };

    //new root
    $scope.newRoot = function () {
        $http.post(BASE_URL + '/app/departmentnewroot', {}).success(function (data) {
            if (data != null && data.resCode > 0) {
                alert('添加成功');
                $scope.loadTreeData();
            } else {
                alert('添加失败');
            }
        }).error(function (data) {

        });
    }

});

var executeadd = function () {
    var nodetext = $('#nodename').textbox('getValue');
    var parentid = $('#parentnodecode').textbox('getValue');
    var memo = $('#memo').textbox('getValue');
    var order = $('#order').textbox('getValue');
    $.ajax({
        type: 'post',
        data: {
            nodename: nodetext,
            parentid: parentid,
            memo: memo,
            order: order
        },
        url: BASE_URL + '/app/departmentadd',
        success: function (data) {
            if (data != null && data.resCode != 0) {
                if (data.resCode == '9999') {
                    alert('当前部门已存在,请重新输入.');
                } else {
                    alert('添加成功');
                    $('#dlg').dialog('close');

                }
            } else {
                alert('添加失败');
            }
        },
        error: function (data) {

        }
    });
};

var executeedit = function () {
    var nodeid = $('#nowid').textbox('getValue');
    var parentId = $('#parentnodecodeedit').textbox('getValue');
    if (nodeid == parentId) {
        alert('不能选择当前部门作为上级部门');
        return;
    }
    var nodetext = $('#nodenameedit').textbox('getValue');
    var memo = $('#memoedit').textbox('getValue');
    var order = $('#orderedit').textbox('getValue');
    $.ajax({
        type: 'post',
        data: {
            nodeid: nodeid,
            nodename: nodetext,
            parentid: parentId,
            memo: memo,
            order: order
        },
        url: BASE_URL + '/app/departmentedit',
        success: function (data) {
            if (data != null && data.resCode != 0) {
                if (data.resCode == '9999') {
                    alert('当前部门已存在,请重新输入.');
                } else {
                    alert('修改成功');
                    $('#dlgedit').dialog('close');

                }
            } else {
                alert('修改失败');
            }
        },
        error: function (data) {

        }
    });
};

var executecancel = function () {
    $('#dlg').dialog('close');
    $('#dlgedit').dialog('close');
};
