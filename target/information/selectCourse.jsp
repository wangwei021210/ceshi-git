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
        <div class="layui-form layui-card-header layuiadmin-card-header-auto">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">课程名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">教师名</label>
                    <div class="layui-input-block">
                        <input type="text" name="T_name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <button class="layui-btn layuiadmin-btn-useradmin" lay-submit lay-filter="LAY-user-front-search">
                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                    </button>
                </div>
            </div>
        </div>

        <div class="layui-card-body">
            <div style="padding-bottom: 10px;">
                <button class="layui-btn layuiadmin-btn-useradmin" data-type="add">添加</button>
            </div>

            <table class="layui-hide" id="demo" lay-filter="test"></table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
        //监听搜索
        form.on('submit(LAY-user-front-search)', function (obj) {
            console.log(obj.field);
            CourseTable.reload({
                where: {
                    'name':obj.field.name
                    ,'T_name': obj.field.T_name
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });





        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
            var id = data.C_id
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                layer.msg('查看操作');
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    layer.close(index);
                    //向服务端发送删除指令
                    $.ajax({
                        url:"/deleteCourseServlet",
                        method:"post",
                        data: {"C_id": id},
                        success:function(data){
                            if (data) {
                                obj.del(); //删除对应行（tr）的DOM结构
                                layer.msg('删除成功！', {time: 1500})
                            } else {
                                layer.msg('删除失败！', {time: 1500})
                            }
                        },
                        error:function(xhr,errorMessage,e){
                            layer.msg("系统异常");
                        }
                    });

                });
            } else if(layEvent === 'edit'){
                layer.msg('编辑操作');
            }
        });


        //事件
        var active = {
            add: function(){
                layer.open({
                    type: 2
                    ,title: '添加课程'
                    ,content: 'addCourse.jsp'
                    ,maxmin: true
                    ,area: ['500px', '450px']
                    ,yes: function(index, layero){
                        var iframeWindow = window['layui-layer-iframe'+ index]
                            ,submitID = 'LAY-user-front-submit'
                            ,submit = layero.find('iframe').contents().find('#'+ submitID);

                        //监听提交
                        iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
                            var field = data.field; //获取提交的字段

                            //提交 Ajax 成功后，静态更新表格中的数据
                            $.post('/addCourseServlet',field , function (result) {

                            })
                            layer.msg("修改成功")
                            table.reload('LAY-user-front-submit'); //数据刷新
                            layer.close(index); //关闭弹层
                        });

                        submit.trigger('click');
                    }
                });
            }
        };

        $('.layui-btn.layuiadmin-btn-useradmin').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
</body>
</html>

