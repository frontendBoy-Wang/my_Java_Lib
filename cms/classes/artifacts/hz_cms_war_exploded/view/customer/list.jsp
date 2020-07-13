<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
</head>
<body>
<form class="layui-form layui-form-pane">
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 100px">客户名:</label>
			<div class="layui-input-inline" style="width: 110px">
				<input id="custName" class="layui-input" placeholder="客户名" />
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 100px">公司:</label>
			<div class="layui-input-inline" style="width: 110px">
				<input id="company" class="layui-input" placeholder="公司" />
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 100px">职位:</label>
			<div class="layui-input-inline" style="width: 110px">
				<input id="position" class="layui-input" placeholder="职位" />
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 100px">工资:</label>
			<div class="layui-input-inline" style="width: 90px;">
        		<input type="text" id="minSalary" placeholder="最低工资" autocomplete="off" class="layui-input">
      		</div>
      		<div class="layui-form-mid">-</div>
      		<div class="layui-input-inline" style="width: 90px;">
        		<input type="text" id="maxSalary" placeholder="最高工资" autocomplete="off" class="layui-input">
      		</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 100px">电话:</label>
			<div class="layui-input-inline" style="width: 110px">
				<input id="phone" class="layui-input" placeholder="电话" />
			</div>
		</div>
	</div>
	<!-----------------------------------------------------------------  -->
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 100px">性别:</label>
			<div class="layui-input-inline" style="width: 110px">
				<select id="sex">
					<option value="">性别</option>
					<option value="1">男</option>
					<option value="2">女</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 100px">状态:</label>
			<div class="layui-input-inline" style="width: 110px">
				<select id="state">
					<option value="">状态</option>
					<option value="1">有效</option>
					<option value="2">无效</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 100px">业务员:</label>
			<div class="layui-input-inline" style="width: 110px">
				<select id="userId" lay-fiter="salesman" lay-search="">
					<option value="">业务员</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 100px">创建时间:</label>
			<div class="layui-input-inline" style="width: 120px;">
        		<input type="text" id="minCreateTime" placeholder="开始时间" autocomplete="off" class="layui-input" readonly="readonly">
      		</div>
      		<div class="layui-form-mid">-</div>
      		<div class="layui-input-inline" style="width: 120px;">
        		<input type="text" id="maxCreateTime" placeholder="结束时间" autocomplete="off" class="layui-input" readonly="readonly">
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
<div class="layui-btn-group">
	<button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon">&#xe608;</i>新增</button>
	<button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete"><i class="layui-icon">&#xe640;</i>删除</button>
	<button class="layui-btn layui-btn-sm layui-btn-warm" lay-event="setSalesman"><i class="layui-icon">&#xe612;</i>修改业务员</button>
</div>
</script>
<!-- 行工具栏 -->
<script type="text/html" id="rowBtns">
	<button class="layui-btn layui-btn-xs  layui-btn-warm" lay-event="update"><i class="layui-icon">&#xe642;</i>修改</button>
	<button class="layui-btn layui-btn-xs " lay-event="visit"><i class="layui-icon">&#xe609;</i>拜访</button>
</script>


<!-- 数据编辑模板 -->
<script type="text/html" id="editTpl">
<form class="layui-form layui-form-pane"  style="margin:10px" lay-filter="dataFormFilter">
	<div class="layui-form-item">
		<label class="layui-form-label">客户名称:</label>
		<div class="layui-input-inline">
			<input name="custName" class="layui-input" placeholder="客户名称" autocomplete="off"  lay-verify="required" lay-reqText="请输入客户名称"/>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">公司:</label>
		<div class="layui-input-inline">
			<input name="company" class="layui-input" placeholder="公司" autocomplete="off"  lay-verify="required" lay-reqText="请输入公司"/>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">职位:</label>
		<div class="layui-input-inline">
			<input name="position" class="layui-input" placeholder="职位" autocomplete="off"  lay-verify="required" lay-reqText="请输入职位" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">工资:</label>
		<div class="layui-input-inline">
			<input name="salary" class="layui-input" placeholder="工资" autocomplete="off"  lay-verify="required" lay-reqText="请输入工资" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">电话:</label>
		<div class="layui-input-inline">
			<input name="phone" class="layui-input" placeholder="电话" autocomplete="off"  lay-verify="required|phone" lay-reqText="请输入电话" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">性别:</label>
		<div class="layui-input-inline" style="width:210px">
			<input name="sex" type="radio"  title="男" value="1" checked  />
			<input name="sex" type="radio"  title="女" value="2"  />
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

<!-- 设置业务员模板  -->
<script type="text/html" id="salesmanTpl">
<form class="layui-form layui-form-pane"  style="margin:10px" lay-filter="salesmanFilter">
	<div class="layui-form-item">
		<label class="layui-form-label">业务员:</label>
		<div class="layui-input-inline" style="width:210px">
			<select id="updateUserId" name="userId" lay-fiter="salesman" lay-search="" lay-verify="required"   lay-reqText="请选择业务员">
					<option value="">业务员</option>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<button class="layui-btn" type="button" id="submitBtn" lay-submit lay-filter="submitBtnFilter" style="display:none">确认</button>
	</div>
</form>
</script>

<!-- 拜访记录模板 -->
<script type="text/html" id="visitLogTpl">
<form class="layui-form layui-form-pane"  style="margin:10px" lay-filter="visitLogFilter">
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">拜访客户:</label>
			<div class="layui-input-inline">
				<input class="layui-input" name="id" type="hidden" />
				<input class="layui-input" name="custName" readonly />
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">拜访时间:</label>
			<div class="layui-input-inline">
				<input class="layui-input" id="visitTime" name="visitTime" readonly   lay-verify="required"   lay-reqText="请选择拜访时间" />
			</div>
		</div>
	</div>
	<div class="layui-form-item layui-form-text" style="width:625px">
		<label class="layui-form-label">拜访内容</label>
    	<div class="layui-input-block" >
      		<textarea placeholder="请输入内容" class="layui-textarea" name="visitDesc"></textarea>
    	</div>
	</div>
	<div class="layui-form-item">
		<button class="layui-btn" type="button" id="submitBtn" lay-submit lay-filter="submitBtnFilter" style="display:none">确认</button>
	</div>
</form>
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','table','jquery','layer','laydate'],function(){
		var form = layui.form;
		var table = layui.table;
		var $ = layui.jquery;
		var layer = layui.layer;
		var laydate = layui.laydate;
		//初始化时间控件
		laydate.render({
			elem:"#minCreateTime",
			type:'date'
		});
		laydate.render({
			elem:"#maxCreateTime",
			type:'date'
		});
		//初始化业务员
		initSalesMan('userId');
		//初始化业务员信息
		function initSalesMan(domId){
			//获取待初始化的dom对象
			var select = $("#"+domId);
			//使用ajax获取所有的业务员信息
			$.get("${pageContext.request.contextPath}/user.do?service=allSalesman",function(rs){
				if(rs.code != 200){
					layer.msg("业务员信息异常!")
					return false;
				}
				//所有的业务员数据
				var data = rs.data;
				//待添加业务员信息
				var options = "";
				$.each(data,function(index,obj){
					options = options + "<option value='"+obj.id+"'>"+obj.realName+"</option>";
				});
				select.append(options);
				//重新渲染 业务员下拉框
				form.render();
			});
		}
		//初始化表格
		var tabIns = table.render({
			id:"dataTableId",
			elem:"#dataTable",
			width:'1250',
			height:'520',
			page:true,//开启分页
			url:"${pageContext.request.contextPath}/customer.do?service=page",
			toolbar:"#headerBtns",//头工具栏
			cols:[[
				{type:'checkbox',width:'60'},
				{title:"客户名",field:"custName",width:'100'},
				{title:"公司",field:"company",width:'120'},
				{title:"职位",field:"position",width:'150'},
				{title:"工资",field:"salary",width:'100'},
				{title:"电话",field:"phone",width:'120'},
				{title:"性别",width:'60',field:"sex",templet:function(d){
					if(d.sex == 1){
						return "<b style='color:green' >男</b>";
					}else if(d.sex == 2){
						return "<b>女</b>";
					}
				}},
				{title:"状态",field:"state",width:'60',templet:function(d){
					if(d.state == 1){
						return "<b style='color:green' >有效</b>";
					}else if(d.state == 2){
						return "<b style='color:red' >无效</b>";
					}
				}},
				{title:"业务员",field:"realName",width:'120'},
				{title:"创建时间",field:"createTime",width:'170'},
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
			var custName = $("#custName").val();
			var company = $("#company").val();
			var position = $("#position").val();
			var minSalary = $("#minSalary").val();
			var maxSalary = $("#maxSalary").val();
			var phone = $("#phone").val();
			var sex = $("#sex").val();
			var state = $("#state").val();
			var userId = $("#userId").val();
			var minCreateTime = $("#minCreateTime").val();
			var maxCreateTime = $("#maxCreateTime").val();
			//重载表格
			//根据输入的参数进行重载
			tabIns.reload({
				where:{//重载数据的条件
					custName:custName,
					company:company,
					position:position,
					minSalary:minSalary,
					maxSalary:maxSalary,
					phone:phone,
					sex:sex,
					state:state,
					userId:userId,
					minCreateTime:minCreateTime,
					maxCreateTime:maxCreateTime
				}
			});
		});
		
		//行监听事件
		table.on('tool(dataTableFilter)',function(d){
			var event = d.event;
			var data = d.data;
			if(event == 'update'){
				update(data);
			}else if(event == 'visit'){
				visit(data);
			}			
		});
		//修改客户信息
		function update(data){
			layer.open({
				type:1,//html字符串
				title:'编辑',
				content:$("#editTpl").html(),//弹层的内容
				area:['360px','550px'],
				success:function(layero,index){//弹层完成时的回调方法
					//为表单初始化值
					form.val("dataFormFilter",data);
					//重新渲染表单  不然单选按钮无效
					form.render();
					//form表单的监听事件
					form.on('submit(submitBtnFilter)',function(d){
						var formData = d.field;//获取表单中的数据
						formData.id = data.id;//设置ID属性
						//使用ajax提交数据
						$.post("${pageContext.request.contextPath}/customer.do?service=update",formData,function(rs){
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
		//新增拜访记录
		function visit(data){
			layer.open({
				type:1,//html字符串
				title:'编辑',
				content:$("#visitLogTpl").html(),//弹层的内容
				area:['662px','400px'],
				success:function(layero,index){//弹层完成时的回调方法
					//为表单初始化值
					form.val("visitLogFilter",data);
					//初始化时间组件
					laydate.render({
						elem:"#visitTime",
						type:"date"
					});
					//form表单的监听事件
					form.on('submit(submitBtnFilter)',function(d){
						var formData = d.field;//获取表单中的数据
						formData.id = data.id;//设置ID属性
						//使用ajax提交数据
						$.post("${pageContext.request.contextPath}/visitlog.do?service=add",formData,function(rs){
							if(rs.code != 200){
								layer.msg(rs.msg);
								return false;
							}
							//关闭弹层
							layer.close(index);
							layer.msg("操作成功");
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
		//头工具栏监听事件
		table.on('toolbar(dataTableFilter)',function(d){
			//获取事件类型
			var event = d.event;
			if(event == "add"){
				addCustomer();
			}else if(event == "delete"){
				batchDelete();
			}else if(event = "setSalesman"){
				setSalesman();
			}
			
		});
		//新增员工
		function addCustomer(){
			layer.open({
				type:1,//html字符串
				title:'编辑',
				content:$("#editTpl").html(),//弹层的内容
				area:['360px','550px'],
				success:function(layero,index){//弹层完成时的回调方法
					//重新渲染表单  不然单选按钮无效
					form.render();
					//form表单的监听事件
					form.on('submit(submitBtnFilter)',function(d){
						var data = d.field;//获取表单中的数据
						//使用ajax提交数据
						$.post("${pageContext.request.contextPath}/customer.do?service=add",data,function(rs){
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
		//批量删除
		function batchDelete(){
			//获取选中的数据
			var checkStatus = table.checkStatus('dataTableId'); //dataTableId 即为基础参数 id 对应的值
			var data = checkStatus.data;//选中的数据 数组
			if(data == null || data.length == 0){
				layer.msg("请选择要删除的数据!");
				return false;
			}
			layer.confirm("确定要删除吗?",function(index,layero){
				var ids = "";
				$.each(data,function(index,obj){
					ids = ids + "id="+obj.id+"&";
				});
				console.log(ids);
				$.get("${pageContext.request.contextPath}/customer.do?service=batchDelete&"+ids,function(rs){
					if(rs.code != 200){
						layer.msg(rs.msg);
						return false;
					}
					//重载表格
					$("#searchBtn").click();
					//关闭弹出层
					layer.close(index);
				});
				
			});
		}
		//修改业务员
		function  setSalesman(){
			layer.msg("修改业务员");
			//1. 获取待修改的客户的ID 
			//获取选中的数据
			var checkStatus = table.checkStatus('dataTableId'); //dataTableId 即为基础参数 id 对应的值
			var data = checkStatus.data;//选中的数据 数组
			if(data == null || data.length == 0){
				layer.msg("请选择要修改的客户!");
				return false;
			}
			//处理待修改的客户的ID
			var ids = "";
			$.each(data,function(index,obj){
				ids = ids + "id="+obj.id+"&";
			});
			//2. 获取新的业务员ID
			//弹出一个层  显示 所有的业务员 供管理员选择
			layer.open({
				type:1,//html字符串
				title:'编辑',
				content:$("#salesmanTpl").html(),//弹层的内容
				area:['360px','400px'],
				success:function(layero,index){//弹层完成时的回调方法
					//为dom添加业务员
					initSalesMan('updateUserId');
					//form表单的监听事件
					form.on('submit(submitBtnFilter)',function(d){
						var formData = d.field;//获取表单中的数据   userId 的值  业务员的值
						//使用ajax提交数据
						$.post("${pageContext.request.contextPath}/customer.do?service=setSalesman&"+ids,formData,function(rs){
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
			
			//3. 将所有待修改的客户的业务员ID 修改为新的业务员ID
		}
	});
</script>

</body>
</html>