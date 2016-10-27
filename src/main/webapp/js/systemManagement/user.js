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
        idField:'ID',
        columns: [[
            {field: 'ID', title: 'ID', width: 200, align: 'center'},
            {field: 'LOGINID', title: '登录ID', width: 150, align: 'center'},
            {field: 'PASSWORD', title: '密码', width: 150, align: 'center'},
            {field: 'NAME', title: '姓名', width: 150, align: 'center'},
            {field: 'CREATETIME', title: '创建日期', width: 150, align: 'center'},
            {field: 'BIRTHDAY', title: '出生年月日', width: 150, align: 'center'},
            {field: 'STATUS', title: '状态', width: 150, align: 'center'},
            {field: 'DUTYID', title: '岗位ID', width: 150, align: 'center'},
            {field: 'PHONE', title: '电话', width: 150, align: 'center'},
            {field: 'EMail', title: 'EMail', width: 150, align: 'center'},
            {field: 'PHOTO', title: '照片', width: 150, align: 'center'}

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
