<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理页面</title>	<!--http://127.0.0.1:8080/cms/view/resources/layui/css/layui.css  -->
							<!-- ${pageContext.request.contextPath} /项目名称 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
<style type="text/css">
	html,body{
		height: 100%;
	}
</style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">CMS客戶管理</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img onerror="this.src='${pageContext.request.contextPath}/resources/images/user.jpg'" src="${pageContext.request.contextPath}${user.img}" class="layui-nav-img">
          	${user.realName}
        </a>
      </li>
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user.do?service=loginOut">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">基础信息</a>
          <dl class="layui-nav-child">
          
          <c:if test="${user.role == 1}">
           	<dd><a href="${pageContext.request.contextPath}/view/users/list.jsp" target="content">员工管理</a></dd>
          </c:if>
            <dd><a href="${pageContext.request.contextPath}/view/customer/list.jsp" target="content">客户管理</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">系统管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/view/users/updatePwd.jsp" target="content">修改密码</a></dd>
            <dd><a href="${pageContext.request.contextPath}/view/users/uploadImg.jsp" target="content">修改头像</a></dd>
          </dl>
        </li>
         <c:if test="${user.role == 1}">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">数据分析</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/view/statistics/pie.jsp" target="content">拜访记录占比</a></dd>
          </dl>
        </li>
        </c:if>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;height: 100%">
    	<iframe name="content" style="width: 100%;height: 100%;border: 0px" src="https://www.bjsxt.com/"></iframe>
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © 湖职-汪满青
  </div>
</div>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
</script>
</body>
</html>