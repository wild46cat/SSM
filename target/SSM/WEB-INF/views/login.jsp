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
    <!--[if lte IE 9]>
    <script src="${pageContext.request.contextPath}/Component/bootstrap/js/respond.min.js"></script>
    <script src="${pageContext.request.contextPath}/Component/bootstrap/js/html5.js"></script>
    <![endif]-->
    <script src="${pageContext.request.contextPath}/js/base.js"></script>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
</head>
<body ng-app="myLogin" ng-controller="myLoginController" class="container">
<form class="form-horizontal" role="form">
    <div class="form-group">
        <label class="col col-md-3">用户名</label>
        <input type="text" class="form-control col col-md-9" placeholder="请输入用户名" ng-model="myLoginParams.username">
    </div>
    <div class="form-group">
        <label class="col col-md-3">密码</label>
        <input type="text" class="form-control col col-md-9" placeholder="请输入密码" ng-model="myLoginParams.password">
    </div>
    <div>
        <button class="btn btn-primary" ng-click="goLogin();">登录</button>
        <button class="btn btn-primary" ng-click="goClean();">重置</button>
    </div>
</form>
<div>{{myLoginParams}}</div>
</body>
</html>
