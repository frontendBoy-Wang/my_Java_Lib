<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
</head>
<body>
<form class="layui-form layui-form-pane">
	<div class="layui-form-item">
		<label class="layui-form-label">姓名:</label>
		<div class="layui-input-inline">
			<input class="layui-input"   value="${user.realName}"  readonly="readonly">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">用户名:</label>
		<div class="layui-input-inline">
			<input class="layui-input"   value="${user.username}"  readonly="readonly">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">原密码:</label>
		<div class="layui-input-inline">
			<input class="layui-input" name="password" type="password" lay-verify="required"  lay-reqText="请输入原密码"    >
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">新密码:</label>
		<div class="layui-input-inline">
			<input class="layui-input" name="newPassword" type="password" lay-verify="required"  lay-reqText="请输入新密码"    >
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">确认密码:</label>
		<div class="layui-input-inline">
			<input class="layui-input" name="confirmPassword" type="password" lay-verify="required"  lay-reqText="请再次输入新密码"    >
		</div>
	</div>
	<div class="layui-form-item" style="margin-top: 40px">
		<button class="layui-btn" lay-submit lay-filter="submitBtnFilter" type="button" style="margin-left: 50px;margin-right: 30px;">确认</button>
		<button class="layui-btn layui-btn-primary"  type="reset">重置</button>
	</div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','jquery','layer'],function(){
		var form = layui.form;
		var $ = layui.jquery;
		var layer = layui.layer;
		
		//为form表单绑定监听事件
		form.on('submit(submitBtnFilter)',function(d){
			var newPassword = d.field.newPassword;//新密码
			var confirmPassword = d.field.confirmPassword;
			if(newPassword != confirmPassword){
				layer.msg("两次新密码请保持一致!")
				return false;
			}
			//使用ajax进行数据交互
			$.post("${pageContext.request.contextPath}/user.do?service=updatePwd",d.field,function(rs){
				if(rs.code != 200){
					layer.msg(rs.msg);
					return false;
				}
				layer.msg("密码修改成功!");
				//重新登录
				//跳转到首页 
				parent.location.href = "${pageContext.request.contextPath}/redirect.jsp"; 
			});
			return false;//阻止表单默认提交
		});
	});
</script>
</body>
</html>