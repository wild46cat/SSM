/**
 * Created by wuxueyou on 16/10/1.
 */
var userapp = angular.module('userapp', [], function ($httpProvider) {
    baseRequest($httpProvider);
});

userapp.controller('userController', function ($scope, $http) {

    var editFlag = undefined;
    $('#dg').datagrid({
        nowrap: false,
        striped: true,
        collapsible: true,
        singleSelect: true,
        loadMsg: '正在努力加载数据...',
        rownumbers: true,
        pagination: true,
        pageSize: 10,
        pageList: [10, 20, 30],
        idField: 'id',
        columns: [[
            {
                field: 'id', title: 'ID', width: 200, align: 'center', editor: {
                type: 'text', options: {required: true}
            }
            },
            {
                field: 'loginId', title: '登录ID', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            },
            {
                field: 'password', title: '密码', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            },
            {
                field: 'name', title: '姓名', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            },
            {
                field: 'sex', title: '性别', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            },
            {
                field: 'createTime', title: '创建日期', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            },
            {
                field: 'birthday', title: '出生年月日', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            },
            {
                field: 'dutyid', title: '岗位ID', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            },
            {
                field: 'phone', title: '电话', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            },
            {
                field: 'email', title: 'EMail', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            },
            {
                field: 'photo', title: '照片', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            },
            {
                field: 'status', title: '状态', width: 150, align: 'center', editor: {
                type: 'text', options: {}
            }
            }
        ]],
        data: [],
        onClickRow: function (index, data) {
        },
        toolbar: [{
            text: '添加',
            iconCls: 'icon-add',
            handler: function () {
                if (editFlag == undefined) {
                    $('#dg').datagrid('insertRow', {
                        index: 0,
                        row: {
                            id: '',
                            loginId: '',
                            password: '',
                            name: '',
                            sex: '',
                            createTime: '',
                            birthday: '',
                            dutyid: '',
                            phone: '',
                            email: '',
                            photo: '',
                            status: ''
                        }
                    });
                    $('#dg').datagrid('beginEdit', 0);
                    editFlag = 0;
                } else {
                    $('#dg').datagrid('endEdit', editFlag);
                }
            }
        }, '-', {
            text: '删除',
            iconCls: 'icon-remove',
            handler: function () {
                alert('删除');
            }
        }, '-', {
            text: '修改',
            iconCls: 'icon-edit',
            handler: function () {
                alert('修改');
            }
        }, '-', {
            text: '保存',
            iconCls: 'icon-save',
            handler: function () {
                alert('save');
                $('#dg').datagrid('endEdit', editFlag);
                var temparr = $('#dg').datagrid('getChanges', 'inserted');
                console.log(temparr);
                saveData(temparr[0]);
            }
        }, '-', {
            text: '撤销',
            iconCls: 'icon-redo',
            handler: function () {
                editFlag = undefined;
                $("#dg").datagrid('rejectChanges');
            }
        }, '-']
    });

    //加载数据
    function loadData() {
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
    };

    loadData();

    function saveData(item){
        console.log(item);
        $.ajax({
            url:BASE_URL + "/user/saveUser",
            method:'post',
            data:item,
            success: function (data) {
                if(data!= null && data.resCode > 0){
                    alert('添加成功');
                    loadData();
                }
            },
            error: function (data) {
                alert('网络连接错误');
            }
        });
    };

});

var add = function () {
    alert(123);
};
