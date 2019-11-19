<%--
  User: 邹顺
  Date: 2019/6/15
  Time: 20:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
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
                <div class="layui-card-header"></div>
                <div class="layui-card-body" pad15>

                    <div class="layui-form" lay-filter="">
                        <div class="layui-form-item">
                                <label class="layui-form-label">课程名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="name" value="" placeholder="请输入课程名" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">老师名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="name" value="" lay-verify="T_name" autocomplete="off" placeholder="请输入已存在的老师姓名" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">上课时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="time" value="" lay-verify="phone" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">最大选课人数</label>
                            <div class="layui-input-inline">
                                <input type="text" name="max" value=""  class="layui-input">
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
    }).use(['index', 'form','set', 'upload'], function(){
        var $ = layui.$
            ,form = layui.form
            ,upload = layui.upload ;
        form.on('submit(test)', function(data){
            $.post('/addCourseServlet', data.field, function (result) {

            })
            layer.msg("添加成功")

            window.parent.location.reload();


        });

    })



</script>
</body>
</html>

