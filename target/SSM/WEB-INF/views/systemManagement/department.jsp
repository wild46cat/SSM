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
    <script src="${pageContext.request.contextPath}/js/systemManagement/department.js"></script>
</head>
<body class="container-fluid" ng-app="departmentapp" ng-controller="departmentController">
<div>{{departmentList}}</div>
<div class="page-header">
    <h1>系统管理
        <small>--部门管理</small>
    </h1>
</div>

<div id="dlg" class="easyui-dialog" title="新增部门" data-options="iconCls:'icon-add',closed:'true'" style="width:400px;height:200px;padding:10px">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="executeadd();">增加</a>
    <a href="#" class="easyui-linkbutton" onclick="executecancel();">取消</a>
</div>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">easyui tree</h3>
    </div>
    <div class="panel-body">
        <button class="btn btn-success" ng-click="add();"><i class="glyphicon glyphicon-plus"></i>增加</button>
        <button class="btn btn-warning" ng-click="edit();"><i class="glyphicon glyphicon-edit"></i>修改</button>
        <button class="btn btn-danger" ng-click="delete();"><i class="glyphicon glyphicon-trash"></i>删除</button>
        <button class="btn btn-success" ng-click="refresh();"><i class="glyphicon glyphicon-refresh"></i>刷新</button>
        <div class="easyui-panel" style="padding:5px">
            <ul id="mytree" class="easyui-tree" data-options="animate:true,lines:true" style="width: 300px;"></ul>
        </div>
    </div>
</div>

</body>
</html>
