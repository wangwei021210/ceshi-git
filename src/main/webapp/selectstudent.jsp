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
                    <label class="layui-form-label">学号</label>
                    <div class="layui-input-block">
                        <input type="text" name="account" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">专业</label>
                    <div class="layui-input-block">
                        <input type="text" name="national" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">班级</label>
                    <div class="layui-input-block">
                        <input type="text" name="classes" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">学院</label>
                    <div class="layui-input-block">
                        <input type="text" name="college" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <select name="sex">
                            <option value="">不限</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
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
        //监听搜索
        form.on('submit(LAY-user-front-search)', function (obj) {
            studentTable.reload({
                where: {
                    'account':obj.field.account
                    ,'name':obj.field.name
                    ,'national':obj.field.national
                    ,'classes':obj.field.classes
                    ,'college':obj.field.college
                    ,'sex':obj.field.sex
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });
        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
            var id = data.S_id
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                layer.msg('查看操作');
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    layer.close(index);
                    //向服务端发送删除指令
                    $.ajax({
                        url:"/deleteStudentServlet",
                        method:"post",
                        data: {"S_id": id},
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
                    ,title: '添加学生'
                    ,content: 'addstudent.jsp'
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
                            $.post('/addstudentServlet',field , function (result) {

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

