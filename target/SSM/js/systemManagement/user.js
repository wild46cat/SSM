/**
 * Created by wuxueyou on 16/10/1.
 */
var userapp = angular.module('userapp', [], function ($httpProvider) {
    baseRequest($httpProvider);
});

var editFlag = undefined;
userapp.controller('userController', function ($scope, $http) {


    $('#dg').datagrid({
        nowrap: false,
        striped: true,
        collapsible: true,
        singleSelect: true,
        loadMsg: '正在努力加载数据...',
        url: BASE_URL + '/user/userlist',
        rownumbers: true,
        pagination: true,
        pageSize: 5,
        pageList: [5,10, 20, 30],
        idField: 'id',
        columns: [[
            {
                field: 'id', title: 'ID', width: 200, align: 'center'
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
                field: 'sex', title: '性别', width: 150, align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    if (value == '1') {
                        return '男';
                    } else {
                        return '女';
                    }
                }, editor: {
                type: 'combobox', options: {
                    data: [{id: '1', name: '男'}, {id: '2', name: '女'}],
                    valueField: 'id',
                    textField: 'name'
                }
            }
            },
            {
                field: 'createTime', title: '创建日期', width: 150, align: 'center', editor: {
                type: 'datetimebox', options: {required: true}
            }
            },
            {
                field: 'birthday', title: '出生年月日', width: 150, align: 'center', editor: {
                type: 'datetimebox', options: {required: true}
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
                field: 'photo', title: '照片', width: 150, align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    return '<img id="img' + rowData.id + '" src="' + BASE_URL + value + '" style="width:80px;height:100px;" alt="图片"/><br/>' +
                        '<input id="file' + rowData.id + '" name="file" type="file">' +
                        '<input type="button" onclick="uploadPhoto(\'' + rowData.id + '\');" value="上传"/>' +
                        '<input type="button" onclick="changePhoto(\'' + rowData.id + '\');" value="替换"/>' +
                        '<div id="resPath' + rowData.id + '" style="display:none;">' + value + '</div>';
                }
                ,
                //editor: {
                //type: 'picture', options: {
                //    upload: function () {
                //        alert(123);
                //    }
                //}
                //}
            },
            {
                field: 'status', title: '状态', width: 150, align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    if (value == '1') {
                        return '启用';
                    } else {
                        return '禁用';
                    }
                }, editor: {
                type: 'combobox', options: {
                    data: [{id: '0', name: '禁用'}, {id: '1', name: '启用'}],
                    valueField: 'id',
                    textField: 'name'
                }
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
                if (editFlag == undefined) {
                    var rows = $('#dg').datagrid('getSelections');
                    if (rows.length == 1) {
                        deleteData(rows[0]);
                    }
                } else {
                    $('#dg').datagrid('endEdit', editFlag);
                }
            }
        }, '-', {
            text: '修改',
            iconCls: 'icon-edit',
            handler: function () {
                var rows = $('#dg').datagrid('getSelections');
                if (rows.length == 1) {
                    if (editFlag != undefined) {
                        $('#dg').datagrid('endEdit', editFlag);
                    } else {
                        var index = $("#dg").datagrid('getRowIndex', rows[0]);//获取选定行的索引
                        $("#dg").datagrid('beginEdit', index);//开启编辑并传入要编辑的行
                        editFlag = index;
                    }
                }
            }
        }, '-', {
            text: '保存',
            iconCls: 'icon-save',
            handler: function () {
                $('#dg').datagrid('endEdit', editFlag);
                var temparr = $('#dg').datagrid('getChanges', 'inserted');
                if (temparr.length == 0) {
                    //更新
                    var rows = $('#dg').datagrid('getSelections');
                    updateData(rows[0]);
                } else {
                    //添加
                    saveData(temparr[0]);
                }
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


    //loadData();

    //保存
    function saveData(item) {
        $.ajax({
            url: BASE_URL + "/user/saveUser",
            method: 'post',
            data: item,
            success: function (data) {
                if (data != null && data.resCode > 0) {
                    alert('添加成功');
                    refresh();
                }
            },
            error: function (data) {
                alert('网络连接错误');
            }
        });
    };

    //删除
    function deleteData(item) {
        if (confirm('确认删除当前选中行?')) {
            $.ajax({
                url: BASE_URL + "/user/deleteUser",
                method: 'post',
                data: item,
                success: function (data) {
                    if (data != null && data.resCode > 0) {
                        alert('删除成功');
                        refresh();
                    }
                },
                error: function (data) {
                    alert('网络连接错误');
                }
            });
        }
    };

    //修改
    function updateData(item) {
        $.ajax({
            url: BASE_URL + "/user/updateUser",
            method: 'post',
            data: item,
            success: function (data) {
                if (data != null && data.resCode > 0) {
                    alert('修改成功');
                    refresh();
                }
            },
            error: function (data) {
                alert('网络连接错误');
            }
        });
    }


});

//加载数据 由于分页需要使用url,所以,不能采用这种方式。
function loadData() {
    $.ajax({
        url: BASE_URL + '/user/userlist',
        method: 'post',
        data: {},
        success: function (data) {
            if (data != null && data.list.length > 0) {
                $('#dg').datagrid('loadData', data.list);
                editFlag = undefined;
            }
        },
        error: function (data) {
            alert('网络连接错误');
        }
    });
};

//刷新datagrid
function refresh(){
    $('#dg').datagrid('reload');
    editFlag = undefined;
}


var add = function () {
    alert(123);
};

//根据用户id 修改用户的图片
var changePhoto = function (id) {
    var newPhotoPath = $('#resPath' + id).text();
    $.ajax({
        url: BASE_URL + "/user/updateUserPhoto",
        method: 'post',
        data: {id: id, photo: newPhotoPath},
        success: function (data) {
            if (data != null && data.resCode > 0) {
                alert('修改成功');
                refresh();
            }
        },
        error: function (data) {
            alert('网络连接错误');
        }
    });
};

var uploadPhoto = function (id) {
    $.ajaxFileUpload({
        url: BASE_URL + '/file/upload',
        securityuri: false,
        fileElementId: 'file' + id,
        dataType: 'json',
        timeout: 30000,
        success: function (data, status) {
            if (data != null) {
                if (data.resCode == 1) {
                    var path = BASE_URL + data.resFilePath;
                    $('#img' + id).attr("src", path);
                    //ie8下,上传如果文件过大,渲染不出来
                    //$('#img').attr("src","data:image/jpg;base64," + data.resFile);
                    alert('上传成功!');
                    $('#resPath' + id).text(data.resFilePath);
                } else {
                    var errorPath = BASE_URL + '/img/404.jpg';
                    $('#img' + id).attr("src", errorPath);
                    alert('上传失败!');
                    $('#resPath' + id).text(' ');
                }
            }
        },
        error: function (data, status) {
            alert('error');
        }
    });
};
