<%--
  Created by IntelliJ IDEA.
  User: wuxueyou
  Date: 16/10/1
  Time: 下午2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录</title>
    <script src="${pageContext.request.contextPath}/Component/angular.min-1.2.19.js"></script>
    <script src="${pageContext.request.contextPath}/Component/angular-route.min-1.2.19.js"></script>
    <script src="${pageContext.request.contextPath}/Component/angular-ui/angular-ui-router.min.js"></script>
    <link href="${pageContext.request.contextPath}/Component/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/Component/bootstrap/js/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/Component/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/Component/jqueryeasyui/jquery.easyui.min.js"></script>
    <link href="${pageContext.request.contextPath}/Component/jqueryeasyui/themes/default/easyui.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/Component/jqueryeasyui/themes/icon.css" rel="stylesheet">

    <!--[if lte IE 9]>
    <script src="${pageContext.request.contextPath}/Component/bootstrap/js/respond.min.js"></script>
    <script src="${pageContext.request.contextPath}/Component/bootstrap/js/html5.js"></script>
    <![endif]-->
    <script src="${pageContext.request.contextPath}/js/base.js"></script>
    <script src="${pageContext.request.contextPath}/js/systemManagement/duty.js"></script>
</head>
<body class="container-fluid" ng-app="dutyapp" ng-controller="dutyController">
<div class="page-header">
    <h1>系统管理
        <small>--岗位管理</small>
    </h1>
</div>
<div id="dlg" class="easyui-dialog" title="新增部门" data-options="iconCls:'icon-add',closed:'true',modal:'true',top:100,left:100"
     style="width:500px;height:250px;padding:10px">
    <div style="display: none;">
        <input id="depid" class="easyui-textbox" type="text" style="width: 250px;">
    </div>
    <table cellpadding="5">
        <tr style="margin-top: 10px;">
            <td>岗位名称:</td>
            <td><input id="dutyname" class="easyui-textbox" type="text" style="width: 250px;"></td>
        </tr>
        <tr style="margin-top: 10px;">
            <td>岗位描述:</td>
            <td><input id="memo" class="easyui-textbox" data-options="multiline:true"
                       style="height:60px;width: 250px;"/></td>
        </tr>
        <tr style="margin-top: 10px;">
            <td>序号:</td>
            <td><input id="ordernumber" class="easyui-textbox" type="text" style="width: 250px;"></td>
        </tr>
    </table>
    <div style="margin-top: 30px; text-align: center;">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="executeadd();">增加</a>
        <a class="easyui-linkbutton" onclick="executecancel();" style="text-align: center;">取消</a>
    </div>
</div>

<div id="dlgedit" class="easyui-dialog" title="修改部门" data-options="iconCls:'icon-edit',closed:'true',modal:'true',left:100,top:100"
     style="width:500px;height:300px;padding:10px">
    <table cellpadding="5">
        <tr style="margin-top: 10px;">
            <td>岗位名称:</td>
            <td><input id="dutynameedit" class="easyui-textbox" type="text" style="width: 250px;"></td>
        </tr>
        <tr style="margin-top: 10px;">
            <td>上级目录:</td>
            <td><input id="parentdepcombotree" style="width: 250px;"></td>
        </tr>
        <tr style="margin-top: 10px;">
            <td>岗位描述:</td>
            <td><input id="memoedit" class="easyui-textbox" data-options="multiline:true"
                       style="height:60px;width: 250px;"/></td>
        </tr>
        <tr style="margin-top: 10px;">
            <td>序号:</td>
            <td><input id="ordernumberedit" class="easyui-textbox" type="text" style="width: 250px;"/></td>
        </tr>
    </table>
    <div style="margin-top: 30px; text-align: center;">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="executeedit();">修改</a>
        <a class="easyui-linkbutton" onclick="executecancel();" style="text-align: center;">取消</a>
    </div>
    <div style="display: none;"><input id="nowid" class="easyui-textbox" type="text"></div>

</div>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">easyui tree</h3>
    </div>
    <div class="panel-body">
        <div class="easyui-layout" style="width:100%;height:100%;">
            <div data-options="region:'north'" style="height:auto;">
                <button class="btn btn-success" ng-click="add();"><i class="glyphicon glyphicon-plus"></i>增加</button>
                <button class="btn btn-warning" ng-click="edit();"><i class="glyphicon glyphicon-edit"></i>修改</button>
                <button class="btn btn-danger" ng-click="delete();"><i class="glyphicon glyphicon-trash"></i>删除</button>
                <button class="btn btn-success" ng-click="refresh();"><i class="glyphicon glyphicon-refresh"></i>刷新
                </button>
            </div>

            <div data-options="region:'west',title:'部门',split:true" style="width: 300px;">
                <div class="easyui-panel">
                    <ul id="mytree" class="easyui-tree" data-options="animate:true,lines:true"></ul>
                </div>
            </div>
            <div data-options="region:'center',title:'岗位'">
                <div id="mytreecombo" style="width: 300px;"></div>
                <table id="dg"></table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
