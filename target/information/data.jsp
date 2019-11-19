
<%--
  User: 邹顺
  Date: 2019/6/8
  Time: 13:34
--%>
<%@ page language="java" import="java.util.*,information.dao.*" pageEncoding="utf-8"%>
<%@ page import="information.dao.DaoUtils" %>
<%
    DaoUtils daoUtils = new DaoUtils();
    Integer teacher= daoUtils.getTeacher();
    Integer student = daoUtils.getStudent();
    Integer classes = daoUtils.getClasss();
    Integer national = daoUtils.getNational();
%>
<html >
<head>
    <head>
        <meta charset="utf-8">
        <title>学生数据</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <link rel="stylesheet" href="UI/layuiadmin/layui/css/layui.css" media="all">
        <link rel="stylesheet" href="UI/layuiadmin/style/admin.css" media="all">
        <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>

    </head>
</head>
<body>

<div class="layui-col-sm6 layui-col-md3">
    <div class="layui-card">
        <div class="layui-card-header">
            老师人数
            <span class="layui-badge layui-bg-orange layuiadmin-badge">师</span>
        </div>
        <div class="layui-card-body layuiadmin-card-list">
            <p class="layuiadmin-big-font"  ><%=teacher%></p>
        </div>
    </div>
</div>
<div class="layui-col-sm6 layui-col-md3">
    <div class="layui-card">
        <div class="layui-card-header">
            学生总人数
            <span class="layui-badge layui-bg-orange layuiadmin-badge">生</span>
        </div>
        <div class="layui-card-body layuiadmin-card-list">
            <p  class="layuiadmin-big-font" ><%=student%></p>
        </div>
    </div>
</div>
<div class="layui-col-sm6 layui-col-md3">
    <div class="layui-card">
        <div class="layui-card-header">
            学院个数
            <span class="layui-badge layui-bg-orange layuiadmin-badge">院</span>
        </div>
        <div class="layui-card-body layuiadmin-card-list">
            <p  class="layuiadmin-big-font"  ><%=national%></p>
        </div>
    </div>
</div>
<div class="layui-col-sm6 layui-col-md3">
    <div class="layui-card">
        <div class="layui-card-header">
            班级个数
            <span class="layui-badge layui-bg-orange layuiadmin-badge">班</span>
        </div>
        <div class="layui-card-body layuiadmin-card-list">
            <p class="layuiadmin-big-font" ><%=classes%></p>
        </div>
    </div>
</div>
<div class="layui-col-sm12">
    <div class="layui-card">
        <div class="layui-card-header">
            专业人数分布
        </div>
        <div class="layui-card-body">
            <div class="layui-row">
                <div class="layui-col-sm8">
                    <div class="layui-carousel layadmin-carousel layadmin-dataview" >
                        <div carousel-item id="main">
                            <%--<div><i class="layui-icon layui-icon-loading1 layadmin-loading"></i></div>--%>
                                <script type="text/javascript">
                                    // 基于准备好的dom，初始化echarts实例
                                    var myChart = echarts.init(document.getElementById('main'));

                                    // 指定图表的配置项和数据
                                    var option = {
                                        series : [
                                            {
                                                name: '访问来源',
                                                type: 'pie',
                                                radius: '55%',
                                                data:[
                                                    {value:3, name:'计科'},
                                                    {value:1, name:'生工'},
                                                    {value:3, name:'网络'},
                                                    {value:2, name:'机械'},
                                                    {value:1, name:'电子'}
                                                ]
                                            }
                                        ]
                                        };

                                    // 使用刚指定的配置项和数据显示图表。
                                    myChart.setOption(option);
                                </script>
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
    }).use(['index', 'sample']);
</script>



</body>
</html>
