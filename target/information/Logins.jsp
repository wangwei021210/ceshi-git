<%--
  User: 邹顺
  Date: 2019/6/16
  Time: 1:21
--%>
<%@ page language="java" import="java.util.*,information.dao.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登入 - 学生信息管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="UI/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="UI/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="UI/layuiadmin/style/login.css" media="all">
    <script src="UI/layuiadmin/layui/layui.js"></script>
</head>
<body>
<form action="/LoginstudnetServlet" method="post">
    <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

        <div class="layadmin-user-login-main">
            <div class="layadmin-user-login-box layadmin-user-login-header">
                <h2>学生信息管理系统</h2>
                <p>wxxyzs</p>
            </div>
            <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                    <input type="text" name="account" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                    <input type="password" name="pwd" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
                </div>

                <%--<div class="layui-form-item" style="margin-bottom: 20px;">--%>
                    <%--<input type="checkbox" name="remember" lay-skin="primary" title="记住密码">--%>
                    <%--<a href="forget.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>--%>
                <%--</div>--%>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">登 入</button>
                </div>
            </div>
        </div>

        <div class="layui-trans layadmin-user-login-footer">

            <p>© 2018 <a href="http://www.layui.com/" target="_blank">wxxyzs.com</a></p>
            <p>

                <span><a href="https://me.csdn.net/csdnsevenn" target="_blank">程序人生</a></span>

            </p>
        </div>
    </div>
</form>


<script>
    layui.config({
        base: 'UI/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'user'], function(){
        var $ = layui.$
            ,setter = layui.setter
            ,admin = layui.admin
            ,form = layui.form
            ,router = layui.router()
            ,search = router.search;

        form.render();

    });
</script>
</body>
</html>
