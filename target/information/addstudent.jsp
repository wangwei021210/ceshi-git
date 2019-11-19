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
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="password" value="" lay-verify="password" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">年龄</label>
                            <div class="layui-input-inline">
                                <select name="age" lay-verify="">
                                    <option value="16" selected>16</option>
                                    <option value="17" selected>17</option>
                                    <option value="18" selected>18</option>
                                    <option value="19" selected>19</option>
                                    <option value="20" selected>20</option>
                                    <option value="21" selected>21</option>
                                    <option value="22" selected>22</option>
                                    <option value="23" selected>23</option>
                                </select>
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
                                <input name="avatar" lay-verify="required" id="LAY_avatarSrc" placeholder="图片地址" value="" class="layui-input message">
                            </div>
                            <div class="layui-input-inline layui-btn-container" style="width: auto;">
                                <button style="float: left;" type="button" class="layui-btn" id="LAY_avatarUpload">上传图片</button>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">手机</label>
                            <div class="layui-input-inline">
                                <input type="text" name="cellphone" value="" lay-verify="phone" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input type="text" name="email" value="" lay-verify="email" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">学院</label>
                            <div class="layui-input-inline">
                                <select name="college" lay-verify="">
                                    <option value="计科" selected>电信</option>
                                    <option value="网络" selected>生工</option>
                                    <option value="电子" selected>机械</option>
                                    <option value="电信" selected>材料</option>
                                </select>
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
            $.post('/addstudentServlet', data.field, function (result) {

            })
            layer.msg("修改成功")

            window.parent.location.reload();




        });

    })



</script>
</body>
</html>
