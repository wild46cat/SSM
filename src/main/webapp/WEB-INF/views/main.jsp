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
    <title>主界面</title>
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
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/js/base.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</head>
<body ng-app="myMain" ng-controller="myMainController" class="container-fluid" style="overflow: visible">
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#example-navbar-collapse">
            <span class="sr-only">切换导航</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">W3Cschool</a>
    </div>
    <div class="collapse navbar-collapse" id="example-navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="#">iOS</a></li>
            <li><a href="#">SVN</a></li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown">
                    Java <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<div class="row">
    <!--<div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>
    <div class="col-lg-1" style="border: solid 1px green;">1</div>-->
    <div class="panel panel-primary col-lg-2 col-md-3 col-sm-4 col-xs-12" style="border: none;">
        <div class="panel-heading">
            <h3 class="panel-title">
                快捷菜单
            </h3>
        </div>
        <div class="panel-group" id="accordion">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapseOne">
                            系统管理
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse">
                    <ul class="list-group">
                        <li class="list-group-item"><a ng-click="goPage('/web/usermanagement');">用户管理</a>
                        </li>
                        <li class="list-group-item"><a>用户注册</a></li>
                        <li class="list-group-item"><a ng-click="goPage('/web/departmentmanagement');">部门管理</a></li>
                        <li class="list-group-item"><a>岗位管理</a></li>
                        <li class="list-group-item"><a>权限设置</a></li>
                        <li class="list-group-item"><a>角色设置</a></li>
                    </ul>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapseTwo">
                            第 2 部分
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse">
                    <ul class="list-group">
                        <li class="list-group-item"><a ng-click="goPage('/web/common/fileupload');">文件上传</a></li>
                        <li class="list-group-item"><a>内容3</a></li>
                        <li class="list-group-item"><a>内容4</a></li>
                        <li class="list-group-item"><a>内容5</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%--<div ui-view class="col-lg-10 col-md-9 col-sm-8 col-xs-12"></div>--%>
    <%--<div>{{menuURL}}</div>--%>
    <iframe name="mainpage" src="{{menuURL}}" frameborder="0" width="100%"
            height="100%" scrolling="no" onload="this.height=mainpage.document.body.scrollHeight"
            style="border: solid red 1px;" class="col-lg-10 col-md-9 col-sm-8 col-xs-12"></iframe>
</div>
</div>
</body>
</html>
