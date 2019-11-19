<%--
  User: 邹顺
  Date: 2019/6/24
  Time: 0:02
--%>
<%--
  User: 邹顺
  Date: 2019/6/13
  Time: 2:07
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
                            <label class="layui-form-label">学号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="account" value=""  class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="nickname" value="" lay-verify="nickname" autocomplete="off" placeholder="请输入昵称" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">专业</label>
                            <div class="layui-input-inline">
                                <select name="national" lay-verify="">
                                    <option value="计科" selected>计科</option>
                                    <option value="网络" selected>网络</option>
                                    <option value="生工" selected>生工</option>
                                    <option value="电子" selected>电子</option>
                                    <option value="电信" selected>电信</option>
                                    <option value="材料" selected>材料</option>
                                    <option value="机械" selected>机械</option>
                                    <option value="制药" selected>制药</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">班级</label>
                            <div class="layui-input-inline">
                                <input type="text" name="classes" value=""  class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">高数</label>
                            <div class="layui-input-inline">
                                <input type="text" name="math" value=""  class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">英语</label>
                            <div class="layui-input-inline">
                                <input type="text" name="english" value=""  class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">C语言</label>
                            <div class="layui-input-inline">
                                <input type="text" name="cprogram" value=""  class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="test" >确认添加</button>
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
            $.post('/addgradeServlet', data.field, function (result) {

            })
            layer.msg("添加成功")

            window.parent.location.reload();
        });

    })



</script>
</body>
</html>

