/**
 * Created by wuxueyou on 16/10/1.
 */
var userapp = angular.module('userapp', [], function ($httpProvider) {
    baseRequest($httpProvider);
});

userapp.controller('userController', function ($scope, $http) {
    $scope.test = "aabbcc";

    $('#dg').datagrid({
        nowrap: false,
        striped: true,
        collapsible: true,
        singleSelect: true,
        rownumbers: true,
        idField:'id',
        columns: [[
            {field: 'id', title: 'ID', width: 200, align: 'center'},
            {field: 'loginId', title: '登录ID', width: 150, align: 'center'},
            {field: 'password', title: '密码', width: 150, align: 'center'},
            {field: 'name', title: '姓名', width: 150, align: 'center'},
            {field: 'createTime', title: '创建日期', width: 150, align: 'center'},
            {field: 'birthday', title: '出生年月日', width: 150, align: 'center'},
            {field: 'status', title: '状态', width: 150, align: 'center'},
            {field: 'dutyid', title: '岗位ID', width: 150, align: 'center'},
            {field: 'phone', title: '电话', width: 150, align: 'center'},
            {field: 'email', title: 'EMail', width: 150, align: 'center'},
            {field: 'photo', title: '照片', width: 150, align: 'center'}

        ]],
        data:[],
        onClickRow: function (index, data) {
        }
    });

    $.ajax({
        url: BASE_URL + '/user/userlist',
        method: 'post',
        data: {},
        success: function (data) {
            if (data != null && data.list.length > 0) {
                $('#dg').datagrid('loadData', data.list);
            }
        },
        error: function (data) {
            alert('网络连接错误');
        }
    });
});

var add = function () {
    alert(123);
};
