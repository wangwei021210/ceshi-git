<%--
  User: 邹顺
  Date: 2019/6/16
  Time: 1:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*,information.dao.*" pageEncoding="utf-8"%>
<%@ page import="information.entity.Student" %>
<%
    Student student = (Student) session.getAttribute("student1");
    String account =  student.getS_account();
    String name = student.getS_name();
    String phone = student.getS_phone();
    String email = student.getS_email();
    String img  = student.getS_img();
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
                                    <option value="1" disabled>超级管理员</option>
                                    <option value="2" disabled>老师</option>
                                    <option value="3" selected>学生</option>
                                </select>
                            </div>
                            <div class="layui-form-mid layui-word-aux">当前角色不可更改为其它角色</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">学号</label>
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
                            <label class="layui-form-label">手机</label>
                            <div class="layui-input-inline">
                                <input type="text" name="cellphone" value="<%=phone%>" lay-verify="phone" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                        0*********    <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input type="text" name="email" value="<%=email%>" lay-verify="email" autocomplete="off" class="layui-input">
                            </div>
                        </div>
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

        //执行实例
        // upload.render({
        //     elem: '#LAY_avatarUpload' //绑定元素
        //     , url: '/UploadServlet' //上传接口
        //     ,choose: function () {
        //         console.log(12123)
        //     }
        //     ,before: function () {
        //         console.log(111)
        //     }
        //     ,success: function(res){
        //         console.log('上传完毕');
        //     }
        // });
        // admin.events.avartatPreview = function(othis){
        //     var src = avatarSrc.val();
        //     layer.photos({
        //         photos: {
        //             "title": "查看头像" //相册标题
        //             ,"data": [{
        //                 "src": imgs //原图地址
        //             }]
        //         }
        //         ,shade: 0.01
        //         ,closeBtn: 1
        //         ,anim: 5
        //     });
        // };

        form.on('submit(test)', function(data){
            $.post('/infosServlet', data.field, function (result) {

            })
            layer.msg("修改成功")

            window.parent.location.href="main1.jsp"




        });
    });



</script>
</body>
</html>