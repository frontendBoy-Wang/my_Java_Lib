<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
</head>
<body>
<form class="layui-form layui-form-pane">
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">用户名:</label>
			<div class="layui-input-inline" style="width: 120px">
				<input id="username" class="layui-input" placeholder="用户名" />
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">姓名:</label>
			<div class="layui-input-inline" style="width: 120px">
				<input id="realName" class="layui-input" placeholder="姓名" />
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">角色:</label>
			<div class="layui-input-inline" style="width: 130px">
				<select id="role">
					<option value="">请选择角色</option>
					<option value="1">管理员</option>
					<option value="2">业务员</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">状态:</label>
			<div class="layui-input-inline" style="width: 130px">
				<select id="state">
					<option value="">请选择状态</option>
					<option value="1">在职</option>
					<option value="2">离职</option>
				</select>
			</div>
		</div>
		<button type="button" class="layui-btn" id="searchBtn">搜索</button>
		<button class="layui-btn layui-btn-primary">重置</button>
	</div>
</form>
<hr class="layui-bg-green">
<table id="dataTable" lay-filter="dataTableFilter" ></table>

<!-- 头工具栏 -->
<script type="text/html" id="headerBtns">
	<button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon">&#xe608;</i>新增</button>
</script>
<!-- 行工具栏 -->
<script type="text/html" id="rowBtns">
	<button class="layui-btn layui-btn-xs  layui-btn-warm" lay-event="reset"><i class="layui-icon">&#xe609;</i>重置密码</button>
	<button class="layui-btn layui-btn-xs layui-btn-danger" lay-event="quit"><i class="layui-icon">&#xe640;</i>离职</button>
</script>



<script type="text/html" id="editTpl">
<form class="layui-form layui-form-pane"  style="margin:10px">
	<div class="layui-form-item">
		<label class="layui-form-label">姓名:</label>
		<div class="layui-input-inline">
			<input name="realName" class="layui-input" placeholder="姓名"  lay-verify="required" lay-reqText="请输入姓名"/>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">用户名:</label>
		<div class="layui-input-inline">
			<input name="username" class="layui-input" placeholder="用户名"  lay-verify="required" lay-reqText="请输入用户名"/>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">密码:</label>
		<div class="layui-input-inline">
			<input name="password" class="layui-input" placeholder="密码"  value="123456"   readonly="readonly" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色:</label>
		<div class="layui-input-inline" style="width:210px">
			<input name="role" type="radio"  title="管理员" value="1"  />
			<input name="role" type="radio"  title="业务员" value="2" checked />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">状态:</label>
		<div class="layui-input-inline">
			<input name="state" type="radio"  title="有效" value="1"  checked />
			<input name="state" type="radio"  title="无效" value="2"  />
		</div>
	</div>
	<div class="layui-form-item">
		<button class="layui-btn" type="button" id="submitBtn" lay-submit lay-filter="submitBtnFilter" style="display:none">确认</button>
	</div>
</form>

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','table','jquery','layer'],function(){
		var form = layui.form;
		var table = layui.table;
		var $ = layui.jquery;
		var layer = layui.layer;
		//初始化表格
		var tabIns = table.render({
			id:"dataTableId",
			elem:"#dataTable",
			width:'1150',
			height:'520',
			page:true,//开启分页
			url:"${pageContext.request.contextPath}/user.do?service=page",
			toolbar:"#headerBtns",//头工具栏
			cols:[[
				{type:'checkbox',width:'100'},
				{title:"用户名",field:"username",width:'150'},
				{title:"密码",field:"password",width:'150'},
				{title:"姓名",field:"realName",width:'150'},
				{title:"角色",width:'100',field:"role",templet:function(d){
					if(d.role == 1){
						return "<b style='color:green' >管理员</b>";
					}else if(d.role == 2){
						return "<b>业务员</b>";
					}
				}},
				{title:"状态",field:"state",width:'100',templet:function(d){
					if(d.state == 1){
						return "<b style='color:green' >在职</b>";
					}else if(d.state == 2){
						return "<b style='color:red' >离职</b>";
					}
				}},
				{title:"创建时间",field:"createTime",width:'200'},
				{title:"操作",toolbar:"#rowBtns",width:'200',fixed:'right'}
			]],
			parseData:function(rs){//解析数据格式
				return {
					code:rs.code,
					msg:rs.msg,
					count:rs.data.count,
					data:rs.data.data
				};
			},
			response:{//设置响应码
				statusCode:200
			}
		});
		//搜索功能
		$("#searchBtn").click(function(){
			//获取用户名
			var username = $("#username").val();
			var realName = $("#realName").val();
			var role = $("#role").val();
			var state = $("#state").val();
			//重载表格
			//根据输入的参数进行重载
			tabIns.reload({
				where:{//重载数据的条件
					username:username,
					realName:realName,
					role:role,
					state:state
				}
			});
		});
		
		//行监听事件
		table.on('tool(dataTableFilter)',function(d){
			var event = d.event;
			var data = d.data;
			if(event == 'reset'){
				resetPwd(data);
			}else if(event == 'quit'){
				quit(data);
			}			
		});
		//重置密码方法
		function resetPwd(data){
			layer.confirm("确定要重置密码吗?",function(index,layero){
				//将数据的ID 提交给服务器  将数据库中这条数据的密码改为默认密码
				$.get("${pageContext.request.contextPath}/user.do?service=resetPwd",{id:data.id},function(rs){
					if(rs.code != 200){
						layer.msg("密码重置失败!");
						return;
					}
					//重载表格数据  点击查询按钮触发表格数据的重载
					$("#searchBtn").click();
					//关闭弹出层
					layer.close(index);
				});
			});
		}
		//员工离职
		function quit(data){
			if(data.state == 2){
				layer.msg("员工当前是离职状态!请刷新数据!");
				return;
			}
			layer.confirm("确定员工要离职吗?",function(index,layero){
				//将数据的ID 提交给服务器  将数据库中这条数据的密码改为默认密码
				$.get("${pageContext.request.contextPath}/user.do?service=quit",{id:data.id},function(rs){
					if(rs.code != 200){
						layer.msg("员工离职失败!");
						return;
					}
					//重载表格数据  点击查询按钮触发表格数据的重载
					$("#searchBtn").click();
					//关闭弹出层
					layer.close(index);
				});
			});
		}
		//头工具栏监听事件
		table.on('toolbar(dataTableFilter)',function(d){
			//获取事件类型
			var event = d.event;
			if(event == "add"){
				addUser();
			}
			
		});
		//新增员工
		function addUser(){
			layer.open({
				type:1,//html字符串
				title:'编辑',
				content:$("#editTpl").html(),//弹层的内容
				area:['360px','450px'],
				success:function(layero,index){//弹层完成时的回调方法
					//重新渲染表单  不然单选按钮无效
					form.render();
					//form表单的监听事件
					form.on('submit(submitBtnFilter)',function(d){
						var data = d.field;//获取表单中的数据
						//使用ajax提交数据
						$.post("${pageContext.request.contextPath}/user.do?service=add",data,function(rs){
							if(rs.code != 200){
								layer.msg(rs.msg);
								return false;
							}
							//重载表格
							$("#searchBtn").click();
							//关闭弹层
							layer.close(index);
						});
						return false;//阻止表单默认提交
					});
				
				},
				btn:['确认','取消'],
				yes:function(index,layero){//确认按钮被点击
					//使用js点击 form中的确认按钮
					$("#submitBtn").click();
				},
				btnAlign:'c',//按钮居中
			});
		}
	});
</script>

</body>
</html>