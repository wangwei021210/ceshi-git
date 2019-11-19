<%--
  User: 邹顺
  Date: 2019/6/18
  Time: 22:00
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

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn layui-btn-xs" lay-event="add">选课</a>
            </script>
        </div>
    </div>
</div>

<script src="UI/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: 'UI/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'layer', 'table', 'element', 'slider'], function(){
        var $ = layui.$
            ,element = layui.element
            ,form = layui.form
            ,table = layui.table;
        //监听Tab切换
        element.on('tab(demo)', function(data){
            console.log(data);
            layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
                tips: 1
            });
        });
        //执行一个 table 实例
        var CourseTable=table.render({
            elem: '#demo'
            ,height: 420
            ,url: '/CoursesServlet' //数据接口
            ,title: '选修课表'
            ,page: true //开启分页
            ,limit: 5
            ,limits:[5,10,15]
            ,toolbar:true//开启工具栏，此处显示    默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field:'C_id',type :'numbers', title:'课程号',  fixed: 'left', unresize: true, sort: true}
                ,{field:'name', title:'课程名'}
                ,{field: 'T_name', title:'教师'}
                ,{field:'time', title:'上课时间'}
                ,{field:'classroom',title:'教室'}
                ,{field:"maxstudent",title:"已选的人数"}
                ,{field:"max",title:"最大选修人数"}
                ,{fixed: 'right', width: 80, align:'center', toolbar: '#barDemo'}
            ]]
        });


        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
            var id = data.C_id
                ,layEvent = obj.event; //获得 lay-event 对应的值

           if(layEvent === 'add'){
                layer.confirm('确认选修该课程！！！选过后不可更改！！！', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    $.ajax({
                        url:"/addMaxstudentServlet",
                        method:"post",
                        data: {"C_id": id},
                        success:function(data){
                            if (data) {
                                CourseTable.reload();
                                layer.msg('选课成功！', {time: 1500})
                            } else {
                                layer.msg('选课失败，已选课不可再选！', {time: 1500})
                            }
                        },
                        error:function(xhr,errorMessage,e){
                            layer.msg("系统异常");
                        }
                    });
                });
            }
        });
    });
</script>
</body>
</html>


