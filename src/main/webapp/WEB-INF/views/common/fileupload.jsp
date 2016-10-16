<%--
  Created by IntelliJ IDEA.
  User: wuxueyou
  Date: 16/10/1
  Time: 下午2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <script src="${pageContext.request.contextPath}/Component/bootstrap/js/jquery-1.8.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/Component/ajaxfileupload.js"></script>
    <script src="${pageContext.request.contextPath}/Component/bootstrap/js/bootstrap.min.js"></script>
    <!--[if lte IE 9]>
    <script src="${pageContext.request.contextPath}/Component/bootstrap/js/respond.min.js"></script>
    <script src="${pageContext.request.contextPath}/Component/bootstrap/js/html5.js"></script>
    <![endif]-->
    <script src="${pageContext.request.contextPath}/js/base.js"></script>
    <script src="${pageContext.request.contextPath}/js/common/fileupload.js"></script>
</head>
<body ng-app="fileupload" ng-controller="fileuploadController" class="container">
<h1>fileupload.jsp</h1>
<hr/>
    select a file <input type="file" name="file" id="file">
<div id="resPath"></div>
<div id="fileimg"><img id="img" src="" style="width: 200px;height: 200px;border: solid #cccccc 1px;"/></div>
<button class="btn btn-primary" id="ajaxUpload">ajax上传</button>
</body>
</html>
