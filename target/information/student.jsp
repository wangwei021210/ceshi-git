<%--
  User: 邹顺
  Date: 2019/6/19
  Time: 1:19
--%>
<%--
  User: 邹顺
  Date: 2019/6/12
  Time: 22:11
--%>
<%@ page language="java" import="java.util.*,information.dao.*" pageEncoding="utf-8"%>


<!DOCTYPE html>
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
    <div class="layui-card">
        <div class="layui-card-body">
            <table class="layui-hide" id="demo" lay-filter="test"></table>
        </div>
    </div>
</div>

<script src="UI/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: 'UI/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function(){
        var $ = layui.$
            ,element = layui.element
            ,form = layui.form
            ,table = layui.table;
        //监听Tab切换
        element.on('tab(demo)', function(data){
            console.log(data)
            layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
                tips: 1
            });
        });
        //执行一个 table 实例
        var studentTable = table.render({
            elem: '#demo'
            ,height: 420
            ,url: '/selectstudentServlet' //数据接口
            ,title: 'student表'
            ,page: true //开启分页
            ,limit: 5
            ,limits:[5,10,15]
            ,toolbar: true //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field:'S_id', type: 'numbers', title:'ID',  fixed: 'left', unresize: true, sort: true}
                ,{field:'S_account', title:'学号' }
                ,{field:'S_name', title:'姓名'}
                ,{field:'sex',title:'性别'}
                ,{field:'college',title:'学院'}
                ,{field: 'S_national',title:'专业'}
                ,{field:'classes' ,title:'班级'}
                ,{field: 'S_email', title:'邮件'}
                ,{field:'S_phone', title:'电话'}
                ,{field: 'S_addr',title:'地址'}
                ,{fixed: 'right', width: 80, align:'center', toolbar: '#barDemo'}
            ]]
        });

    });
</script>
</body>
</html>

