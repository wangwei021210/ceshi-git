<%--
  User: 邹顺
  Date: 2019/6/18
  Time: 23:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*,information.dao.*" pageEncoding="utf-8"%>
<%@ page import="information.entity.User" %>
<%@ page import="information.entity.Student" %>
<%
    Student student = (Student)session.getAttribute("student1");
%>
<html>
<head>
    <meta charset="utf-8">
    <title>设置我的密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="UI/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="UI/layuiadmin/style/admin.css" media="all">
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">修改密码</div>
                <div class="layui-card-body" pad15>

                    <div class="layui-form" lay-filter="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">当前密码</label>
                            <div class="layui-input-inline">
                                <input type="text"  name="oldPassword" lay-verify="required" lay-verType="tips" class="layui-input",id="pwd">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">新密码</label>
                            <div class="layui-input-inline">
                                <input type="password" name="password" lay-verify="pass" lay-verType="tips" autocomplete="off" id="LAY_password" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">确认新密码</label>
                            <div class="layui-input-inline">
                                <input type="password" name="repassword" lay-verify="repass" lay-verType="tips" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="setmypass">确认修改</button>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="UI/layuiadmin/layui/layui.js"></script>
<script>

    layui.config({
        base: 'UI/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'set','form'],function () {
        var  $ = layui.$
            ,admin = layui.admin
            ,form = layui.form
            , layer = layui.layer;

        form.on('submit(setmypass)', function(data){
            $.post('/updataStuServlet', data.field, function (result) {

            })
            layer.msg("密码修改成功，请重新登陆！！")
            window.parent.location.href = "Logins.jsp"

            // return false;


        });
    });

</script>
</body>
</html>
