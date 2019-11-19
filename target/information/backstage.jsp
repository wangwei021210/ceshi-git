<%--
  User: 邹顺
  Date: 2019/6/3
  Time: 20:56
--%>
<%@ page language="java" import="java.util.*,information.dao.*" pageEncoding="utf-8"%>
<%@ page import="information.entity.Student" %>
<%@ page import="information.entity.User" %>
<%--<%  User user =(User) session.getAttribute("user");--%>
    <%--if(user==null){// 页面访问控制--%>
        <%--out.printl("<scrit>alert('您尚未登录，禁止操作！');" +--%>
                <%--"location.href='login.jsp';</script>");--%>
    <%--}--%>
<%--%>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>wxxy 学会管理系统</title>
    <link rel="stylesheet" href="UI/layuiadmin/layui/css/layui.css">
    <link rel="stylesheet" href="UI/layuiadmin/layui/css/layui.css" media="all">
    <script src="UI/layuiadmin/layui/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">学生信息管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="login.jsp">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">学生信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">成绩信息</a></dd>
                        <dd><a href="javascript:;">个人信息</a></dd>
                        <dd><a href="javascript:;">选课管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <table class="layui-hide" id="demo" lay-filter="test"></table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<blockquote class="layui-elem-quote layui-quote-nm layui-hide" id="footer">layui {{ layui.v }} 提供强力驱动</blockquote>
<script>

    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function(){
        var
            layer = layui.layer //弹层
            ,table = layui.table //表格
            ,element = layui.element //元素操做

        //监听Tab切换
        element.on('tab(demo)', function(data){
            layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
                tips: 1
            });
        });
        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,height: 420
            ,url: '/gradeServlet' //数据接口
            ,title: '用户表'
            ,page: true //开启分页
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field:'S_id', title:'ID',  fixed: 'left', unresize: true, sort: true}
                ,{field:'S_account', title:'学号' }
                ,{field:'S_name', title:'姓名'}
                ,{align:'center', title:'学科',colspan:3}
                ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
            ],[
                {field:'name',title:'数学'}

            ]]


        });

        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                layer.msg('查看操作');
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if(layEvent === 'edit'){
                layer.msg('编辑操作');
            }
        });

        //底部信息
        var footerTpl = lay('#footer')[0].innerHTML;
        lay('#footer').html(layui.laytpl(footerTpl).render({}))
            .removeClass('layui-hide');
    });
</script>
<%--<script>--%>
    <%--//JavaScript代码区域--%>
    <%--layui.use(['element', 'table'], function(){--%>
        <%--var element = layui.element,--%>
            <%--table = layui.table;--%>


        <%--layui.use('demo', function(){--%>
            <%--var demo = layui.laypage;--%>

            <%--//执行一个laypage实例--%>
            <%--laypage.render({--%>
                <%--elem: 'demo' //注意，这里的 test1 是 ID，不用加 # 号--%>
                <%--,count: 50 //数据总数，从服务端得到--%>
            <%--});--%>
        <%--});--%>




        <%--table.render({--%>
            <%--elem: '#demo'--%>
            <%--,url:'/gradeServlet'--%>
            <%--,toolbar: '#toolbarDemo'--%>
            <%--,title: '学生成绩表'--%>
            <%--,limit:10--%>
            <%--,cols: [[--%>
                <%--{type: 'checkbox', fixed: 'left'}--%>
                <%--,{field:'S_id', title:'ID',  fixed: 'left', unresize: true, sort: true}--%>
                <%--,{field:'S_account', title:'学号' }--%>
                <%--,{field:'S_name', title:'姓名'}--%>
                <%--,{field: 'name', title:'name'}--%>
                <%--,{field:'grade', title:'成绩'}--%>

            <%--]]--%>
            <%--,page: true--%>
        <%--});--%>

        <%--//头工具栏事件--%>
        <%--table.on('toolbar(test)', function(obj){--%>
            <%--var checkStatus = table.checkStatus(obj.config.id);--%>
            <%--switch(obj.event){--%>
                <%--case 'getCheckData':--%>
                    <%--var data = checkStatus.data;--%>
                    <%--layer.alert(JSON.stringify(data));--%>
                    <%--break;--%>
                <%--case 'getCheckLength':--%>
                    <%--var data = checkStatus.data;--%>
                    <%--layer.msg('选中了：'+ data.length + ' 个');--%>
                    <%--break;--%>
                <%--case 'isAll':--%>
                    <%--layer.msg(checkStatus.isAll ? '全选': '未全选');--%>
                    <%--break;--%>
            <%--};--%>
        <%--});--%>

        <%--//监听行工具事件--%>
        <%--table.on('tool(test)', function(obj){--%>
            <%--var data = obj.data;--%>
            <%--//console.log(obj)--%>
            <%--if(obj.event === 'del'){--%>
                <%--layer.confirm('真的删除行么', function(index){--%>
                    <%--obj.del();--%>
                    <%--layer.close(index);--%>
                <%--});--%>
            <%--} else if(obj.event === 'edit'){--%>
                <%--layer.prompt({--%>
                    <%--formType: 2--%>
                    <%--,value: data.email--%>
                <%--}, function(value, index){--%>
                    <%--obj.update({--%>
                        <%--email: value--%>
                    <%--});--%>
                    <%--layer.close(index);--%>
                <%--});--%>
            <%--}--%>
        <%--});--%>

    <%--});--%>
<%--</script>--%>
</body>
</html>
