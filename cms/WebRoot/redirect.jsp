<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>跳板</title>
</head>
<body>
<!-- 
	此jsp用于跳转到登录页面的jsp
	统一处理
 -->
 <script type="text/javascript">
 	/* 跳转到登录页面 */
 	window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
 </script>
</body>
</html>