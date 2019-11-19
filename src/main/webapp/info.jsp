<%@ page import="information.entity.User" %><%--
  User: 邹顺
  Date: 2019/6/8
  Time: 16:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*,information.dao.*" pageEncoding="utf-8"%>
<%
User user = (User)session.getAttribute("user1");
String account =  user.getAccount();
String name = user.getName();
String phone = user.getPhone();
String email = user.getEmail();
String img  = user.getImg();
%>
<html>
<head>
    <meta charset="utf-8">
    <title>设置我的资料</title>
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
                <div class="layui-card-header">设置我的资料</div>
                <div class="layui-card-body" pad15>

                    <div class="layui-form" lay-filter="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">我的角色</label>
                            <div class="layui-input-inline">
                                <select name="role" lay-verify="">
                                    <option value="1" selected>超级管理员</option>
                                    <option value="2" disabled>老师</option>
                                    <option value="3" disabled>学生</option>
                                </select>
                            </div>
                            <div class="layui-form-mid layui-word-aux">当前角色不可更改为其它角色</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">账号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="account" value="<%=account%>" readonly class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">不可修改。一般用于后台登入名</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="nickname" value="<%=name%>" lay-verify="nickname" autocomplete="off" placeholder="请输入昵称" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-block">
                                <input type="radio" name="sex" value="男" title="男" checked>
                                <input type="radio" name="sex" value="女" title="女" >
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">头像</label>
                            <div class="layui-input-inline">
                                <input name="avatar" lay-verify="required" id="LAY_avatarSrc" placeholder="图片地址" value="<%=img%>" class="layui-input message">
                            </div>
                            <div class="layui-input-inline layui-btn-container" style="width: auto;">
                                <button  type="button" class="layui-btn layui-btn-primary" id="LAY_avatarUpload">
                                    <i class="layui-icon">&#xe67c;</i>上传图片
                                </button>
                                <%--<button class="layui-btn layui-btn-primary">查看图片</button >--%>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机</label>
                            <div class="layui-input-inline">
                                <input type="text" name="cellphone" value="<%=phone%>" lay-verify="phone" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input type="text" name="email" value="<%=email%>" lay-verify="email" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <%--<div class="layui-form-item layui-form-text">--%>
                            <%--<label class="layui-form-label">备注</label>--%>
                            <%--<div class="layui-input-block">--%>
                                <%--<textarea name="remarks" placeholder="请输入内容" class="layui-textarea"></textarea>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="test" >确认修改</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重新填写</button>
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
    }).use(['index', 'set', 'upload', 'layer','form'], function() {
        var upload = layui.upload
            , $ = layui.$
            ,admin = layui.admin
            ,form = layui.form
            , layer = layui.layer;




        form.on('submit(test)', function(data){
            $.post('/infoServlet', data.field, function (result) {

            })
            layer.msg("修改成功")

            window.parent.location.href="main.jsp"

            // return false;


        });
    });



</script>
</body>
</html>