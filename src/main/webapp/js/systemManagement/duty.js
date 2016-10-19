/**
 * Created by wuxueyou on 16/10/1.
 */
var dutyapp = angular.module('dutyapp', [], function ($httpProvider) {
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

dutyapp.controller('dutyController', function ($scope, $http) {
    $('#mytree').tree({
        loadFilter: function (rows) {
            return convert(rows);
        }
    });

    var nowSelectedDepID = '';
    $scope.departmentList = [];
    $scope.loadTreeData = function () {
        $http.post(BASE_URL + '/app/departmentlist', {}).success(function (data) {
                if (data != null && data.list.length > 0) {
                    $scope.departmentList = data.list;
                    $('#mytree').tree('loadData', $scope.departmentList);

                    $('#parentdepcombotree').combotree({
                        data: $scope.departmentList,
                        loadFilter: function (rows) {
                            return convert(rows);
                        }
                    });

                    $('#dg').datagrid({
                            nowrap: false,
                            striped: true,
                            collapsible: true,
                            idField: 'DUTYID',
                            singleSelect: true,
                            rownumbers: true,
                            columns: [[
                                {field: 'ID', title: '岗位ID', width: 300, align: 'center'},
                                {field: 'DUTYNAME', title: '岗位名称', width: 200, align: 'center'},
                                {field: 'MEMO', title: '岗位描述', width: 200, align: 'center'}
                            ]],
                            data:[],
                            onClickRow: function (index, data) {
                            }
                        }
                    )
                    ;
                }
                else {
                    $scope.departmentList = [];
                }
            }
        ).
            error(function (data) {

            });
    };
    $scope.loadTreeData();

    var refreshdatagrid = function (depid) {
        $('#dg').datagrid('clearSelections');
        $.ajax({
            type: 'post',
            dataType: 'json',
            data: {
                depid: depid
            },
            url: BASE_URL + '/app/dutylist',
            success: function (data) {
                if (data != null && data.list.length > 0) {
                    $('#dg').datagrid('loadData', data.list);
                } else {
                    $('#dg').datagrid('loadData', []);
                }
            },
            error: function (data) {

            }
        });
    };

    $('#mytree').tree({
        onClick: function (node) {
            if ($('#mytree').tree('isLeaf', node.target)) {
                nowSelectedDepID = node.id;
                $('#parentdepcombotree').combotree('setValue', node.id);
                refreshdatagrid(node.id);
            }
            //alert(node.id + '----' + node.text + '----' + node.memo);  // alert node text property when clicked
        }
    });
    $('#mytree').tree({
        'border': false
    });


//添加弹框
    $scope.add = function () {
        var selectedNode = $('#mytree').tree('getSelected');
        if (selectedNode != null) {
            $('#dlg').dialog('open');
            $('#depid').textbox('setValue',selectedNode.id);
            $('#dutyname').textbox('setValue','');
            $('#memo').textbox('setValue','');
            $('#ordernumber').textbox('setValue','');
        } else {
            alert('请先选中节点');
        }
    };

//refresh
    $scope.refresh = function () {
        refreshdatagrid(nowSelectedDepID);
    };

//delete
    $scope.delete = function () {
        var row = $('#dg').datagrid('getSelected');
        if(row != null){
            $.ajax({
                type:'post',
                dataType:'json',
                data:{
                    dutyid:row.ID
                },
                url:BASE_URL + '/app/dutydelete',
                success: function (data) {
                    if(data != null && data.resCode > 0){
                        alert('删除成功');
                    }else{
                        alert('删除失败');
                    }
                },
                error: function (data) {

                }
            });
        }else{
            alert('请先选择岗位');
        }

    };
//edit
    $scope.edit = function () {
        var row = $('#dg').datagrid('getSelected');
        if(row != null){
            $('#dlgedit').dialog('open');
            $('#depid').textbox('setValue',row.DUTYNAME);
            $('#dutynameedit').textbox('setValue',row.DUTYNAME);
            $('#memoedit').textbox('setValue',row.MEMO);
            $('#ordernumberedit').textbox('setValue',row.ORDERNUMBER);
            $('#nowid').textbox('setValue',row.ID);
        }else{
            alert('请先选择岗位');
        }
    };


});

var executeadd = function () {
    var params = {
        dutyname:$('#dutyname').textbox('getValue'),
        memo:$('#memo').textbox('getValue'),
        depid:$('#depid').textbox('getValue'),
        orderNumber:$('#ordernumber').textbox('getValue')
    };
    $.ajax({
        type:'post',
        dataType:'json',
        url:BASE_URL + '/app/dutyadd',
        data:params,
        success: function (data) {
            if(data != null && data.resCode > 0){
                alert('添加成功');
                $('#dlg').dialog('close');
            }else{
                alert('添加失败');
            }
        },
        error: function (data) {

        }
    })
};

var executeedit = function () {
    var params = {
        dutyname:$('#dutynameedit').textbox('getValue'),
        memo:$('#memoedit').textbox('getValue'),
        depid:$('#parentdepcombotree').combotree('getValue'),
        orderNumber:$('#ordernumberedit').textbox('getValue'),
        dutyid:$('#nowid').textbox('getValue')
    };
    $.ajax({
        type:'post',
        dataType:'json',
        data:params,
        url:BASE_URL + '/app/dutyupdate',
        success: function (data) {
            if(data != null && data.resCode > 0){
                alert('修改成功');
                $('#dlgedit').dialog('close');
            }else{
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
