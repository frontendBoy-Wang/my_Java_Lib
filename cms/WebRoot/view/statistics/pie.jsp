<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工拜访量占比</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
</head>
<body>
<div style="position: relative;left: 50px">
	<div class="layui-form layui-form-pane">
		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 100px">拜访时间:</label>
			<div class="layui-input-inline" style="width: 120px;">
        		<input type="text" id="minVisitTime" placeholder="开始时间" autocomplete="off" class="layui-input" readonly="readonly">
      		</div>
      		<div class="layui-form-mid">-</div>
      		<div class="layui-input-inline" style="width: 120px;">
        		<input type="text" id="maxVisitTime" placeholder="结束时间" autocomplete="off" class="layui-input" readonly="readonly">
      		</div>
      		<button type="button" class="layui-btn" id="searchBtn">搜索</button>
		</div>
	</div>
	<!-- 图表容器 -->
	<div id="contain" style="width: 500px;height: 500px"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['laydate','jquery','layer'],function(){
		var laydate = layui.laydate;
		var $ = layui.jquery;
		var layer = layui.layer;
		laydate.render({
			elem:"#minVisitTime"
		})
		laydate.render({
			elem:"#maxVisitTime"
		})
		
		//初始化echarts
		var echart = echarts.init(document.getElementById("contain"));
		//饼状图参数
		var options = {
				title:{//图表标题
					text:"员工拜访占比"
				},
				legend: {//图例
			        orient: 'vertical',
			        left: 'left',
			        top:'30px',
			        data: null //业务员数据
			    },
			    tooltip: {//提示工具
			        trigger: 'item',
			        formatter: '{a} <br/>{b} : {c} ({d}%)'
			    },
			    series: //图表系列
			        {
			            name: '拜访占比',//图表系列名称
			            type: 'pie',//图表类型
			            data: null//拜访数据
			        }
		}
		
		$("#searchBtn").click(function(){
			var minVisitTime = $("#minVisitTime").val();
			var maxVisitTime = $("#maxVisitTime").val();
			//使用ajax 获取数据
			$.get("${pageContext.request.contextPath}/visitlog.do?service=pie",{maxVisitTime:maxVisitTime,minVisitTime:minVisitTime},function(rs){
				if(rs.code != 200){
					layer.msg("统计数据获取失败");
					return false;
				}
				//从返回数据中解析数据
				var salesman = rs.data.legendData;
				var visitData = rs.data.seriesData;
				//修改option 中的数据
				options.series.data = visitData;
				options.legend.data = salesman ;
				console.log(options);
				//渲染图表
				echart.setOption(options);
			});
		});
		//让按钮点击
		$("#searchBtn").click();
	});
</script>

</body>
</html>