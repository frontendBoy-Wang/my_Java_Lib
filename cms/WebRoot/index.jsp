<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录页面</title>
    <link rel="stylesheet" href="resources/css/font.css">
    <link rel="stylesheet" href="resources/css/weadmin.css">
    <link rel="stylesheet" href="resources/layui/css/layui.css">
    <style type="text/css">
        .reg {
            color: #c2bfbe;
        }

        .reg:hover {
            color: #3260ac;
        }

    </style>
</head>

<body class="login-bg">
<div class="login">
    <div class="message">CMS-管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form">
        <input name="username" placeholder="用户名" type="text" lay-verify="required" lay-reqText="请输入用户名"
               class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码" lay-reqText="请输入密码" type="password"
               class="layui-input">
        <hr class="hr15">
        <!-- 滑块 -->
        <div id="slider"></div>
        <hr class="hr15">
        <input class="loginin" value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20">
    </form>
</div>
<!-- 引入layui核心js -->
<script type="text/javascript" src="resources/layui/layui.js"></script>
<script type="text/javascript">
    layui.config({base: 'resources/sliderVerify/'}).use(['jquery', 'form', 'layer', 'sliderVerify'], function () {
        //初始化组件
        var $ = layui.jquery;
        var form = layui.form;
        var layer = layui.layer;
        var sliderVerify = layui.sliderVerify;
        //初始化滑块
        var slider = sliderVerify.render({
            elem: "#slider",
            isAutoVerify: true,//滑块自动验证
        });
        //表单提交事件
        form.on("submit(login)", function (data) {
            console.log("表单可以提交了");
            //获取表单数据
            var formData = data.field; //获取表单的域的值
            //主动获取  val
            //使用ajax进行数据交互
            $.post("user.do?service=login", formData, function (rs) {
                console.log(rs);
                //将字符串转化为JSON对象 js对象
                //rs = JSON.parse(rs);
                console.log(rs);
                if (rs.code != 200) {
                    layer.msg(rs.msg);//对象的写法
                    //重置滑块
                    slider.reset();
                    return false;
                }
                //登录成功  要进行页面跳转
                location.href = "view/main.jsp";
            });
            return false;//阻止表单默认提交行为
        });
    });
</script>
</body>
</html>