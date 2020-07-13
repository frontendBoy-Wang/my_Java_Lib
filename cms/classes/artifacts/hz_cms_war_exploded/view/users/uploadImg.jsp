<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传图像</title>
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
	<div class="layui-form-item layui-form-text" style="width: 300px">
		<label class="layui-form-label">图像:</label>
		<div class="layui-input-inline">
			<img  id="userImg" style="width: 298px;height: 300px;border: 1px solid gray" onerror="this.src='${pageContext.request.contextPath}/resources/images/user.jpg'" src="${pageContext.request.contextPath}${user.img}">
		</div>
	</div>

	<div class="layui-form-item" style="margin-top: 40px">
		<button class="layui-btn" id="submitBtn" type="button" style="width: 300px">上传图像</button>
	</div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','jquery','layer','upload'],function(){
		var form = layui.form;
		var $ = layui.jquery;
		var layer = layui.layer;
		var upload = layui.upload;
		
		//初始化图片上传组件
		upload.render({
			elem:"#userImg",//图片上传组件容器
			url:"${pageContext.request.contextPath}/user.do?service=uploadImg",//上传图片的接口地址
			accept:"images",//允许上传的文件类型
			acceptMime:'image/*',//只显示图片文件
			auto:false,//阻止自动上传
			bindAction:"#submitBtn",//触发文件上传的按钮
			field:"userImg",//设置文件域的name属性值  后端用这个值获取文件数据
			size:2048,//允许文件大小 只允许2048KB 以内的图片
			choose:function(obj){//选择文件后调用的函数
				//图片预览的方法
				obj.preview(function(index, file, result){
					//index 上传的文件的索引  多文件上传
					//file 就是上传的文件的信息
					//result 就是上传的文件BASE64编码字符串
					$("#userImg").attr("src",result);
				});
			},
			before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
				    layer.load(); //上传loading
			},
			done:function(res, index, upload){//上传完成的回调
				layer.closeAll();
				if(res.code == 200){
					layer.msg("头像修改成功!重新登录后生效");
					return false;
				}
			},
			error: function(index, upload){
				layer.closeAll();//关闭上传loading
				layer.msg("头像修改失败!");
			 }
		});
	});
</script>
</body>
</html>